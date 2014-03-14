/**
 * IndexController.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date 2013-5-3 下午10:24:49
 */
package com.joydeal.controllers;

import com.joydeal.controllers.annotations.LoginRequired;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author leo
 */
@Path("/good")
public class GoodController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodController.class);

    @Get("")
    public String good(Invocation inv) {
        return "good";
    }

    @Get("{id:.*}")
    public String good(Invocation inv, @Param("id") String id) {
        inv.addModel("name", "测试宝贝");
        inv.addModel("desc", "测试说明");
        return "good";
    }

    @LoginRequired
    @Get("shouldlogin")
    public String shouldlogin() {
        LOGGER.info("{IndexController.index} debug in hello ");
        return successResult("Good! This api required login, and u got that!");
    }
}
