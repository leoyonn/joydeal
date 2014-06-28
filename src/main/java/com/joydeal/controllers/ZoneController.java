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
import com.joydeal.service.ZoneService;
import com.joydeal.thrift.Need;
import com.joydeal.thrift.Position;
import com.joydeal.thrift.User;
import com.joydeal.thrift.Zone;
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
@Path("/zone")
public class ZoneController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZoneController.class);
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ZoneService zoneService;

    @Get("{id:.*}")
    public String zone(Invocation inv, @Param("id") long id) {
        OperResult<Zone> r = zoneService.get(id);
        if (r.getError() != ErrorCode.Success) {
            inv.addModel("message", r.error.desc() + ": " + r.reason);
            return "index";
        }
        inv.addModel("zone", r.result);
        return "zone";
    }

    @Get("new")
    @LoginRequired
    public String create(Invocation inv) {
        return "new_zone";
    }

    @Post("new")
    @LoginRequired
    public String create(Invocation inv, @NotBlank @Param("category") String category,
                         @NotBlank @Param("name") String name,
                         @Param("desc") String desc,
                         @NotBlank @Param("icon") String icon,
                         @NotBlank @Param("address") String address,
                         @NotBlank @Param("landmark") String landmark,
                         @NotBlank @Param("lon") double lon,
                         @NotBlank @Param("lat") double lat) {
        User user = (User) inv.getModel("userInfo");
        Zone zone = new Zone().setCategory(categoryService.get(category).getResult()).setDesc(desc)
                .setIcon(icon).setName(name).setCreator(user).setLord(user).setCreateAt(System.currentTimeMillis())
                .setPos(new Position().setLon(lon).setLat(lat).setAddress(address).setName(landmark));
        OperResult<Zone> result = zoneService.create(zone);
        if (result.error != ErrorCode.Success) {
            inv.addModel("message", result.error.desc() + "：" + result.reason);
            return "new_zone";
        }
        inv.addModel("zone", result.result);
        return "zone";
    }
}
