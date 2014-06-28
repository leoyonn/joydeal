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
import com.joydeal.service.NeedService;
import com.joydeal.thrift.Good;
import com.joydeal.thrift.Need;
import com.joydeal.thrift.Status;
import com.joydeal.thrift.User;
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
@Path("/need")
public class NeedController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NeedController.class);
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private NeedService needService;

    @Get("")
    public String need(Invocation inv) {
        return "need";
    }

    @Get("{id:.*}")
    public String need(Invocation inv, @Param("id") long id) {
        OperResult<Need> r = needService.get(id);
        if (r.getError() != ErrorCode.Success) {
            inv.addModel("message", r.error.desc() + ": " + r.reason);
            return "index";
        }
        inv.addModel("need", r.result);
        return "need";
    }

    @Get("new")
    @LoginRequired
    public String create(Invocation inv) {
        return "new_need";
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
        Need need = new Need().setCategory(categoryService.get(category).getResult()).setDesc(desc)
                .setIcon(icon).setName(name).setPrice(price).setOwner(user).setTtl(ttl)
                .setStatus(Status.Valid);
        OperResult<Need> result = needService.create(need);
        if (result.error != ErrorCode.Success) {
            inv.addModel("message", result.error.desc() + "：" + result.reason);
            return "new_need";
        }
        inv.addModel("need", result.result);
        return "need";
    }
}
