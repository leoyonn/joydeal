/**
 * IndexController.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date 2013-5-3 下午10:24:49
 */
package com.joydeal.controllers;

import com.joydeal.controllers.annotations.LoginRequired;
import com.joydeal.result.ErrorCode;
import com.joydeal.result.OperResult;
import com.joydeal.service.CategoryService;
import com.joydeal.service.GoodService;
import com.joydeal.thrift.*;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author leo
 */
@Path("/good")
public class GoodController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodController.class);
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GoodService goodService;

    @Get("{id:[0-9]+}")
    public String good(Invocation inv, @Param("id") long id) {
        OperResult<Good> r = goodService.get(id);
        if (r.getError() != ErrorCode.Success) {
            inv.addModel("message", r.error.desc() + ": " + r.reason);
            return "index";
        }
        inv.addModel("zone", r.result);
        return "good";
    }

    @Get("new")
    public String create(Invocation inv) {
        return "new_good";
    }

    @Post("new")
    @LoginRequired
    public String create(Invocation inv, @NotBlank @Param("category") String category,
                         @NotBlank @Param("name") String name,
                         @Param("desc") String desc,
                         @NotBlank @Param("icon") String icon,
                         @NotBlank @Param("price") double price,
                         @NotBlank @Param("ttl") long ttl) {
        User user = (User) inv.getModel("userInfo");
        Good good = new Good().setCategory(categoryService.get(category).getResult()).setDesc(desc)
                .setIcon(icon).setName(name).setPrice(price).setOwner(user).setTtl(ttl)
                .setStatus(Status.Valid).setCreateAt(System.currentTimeMillis());
        OperResult<Good> result = goodService.create(good);
        if (result.error != ErrorCode.Success) {
            inv.addModel("message", result.error.desc() + "：" + result.reason);
            return "new_good";
        }
        inv.addModel("good", result.result);
        return "good";
    }
}
