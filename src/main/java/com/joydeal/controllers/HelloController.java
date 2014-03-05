/**
 * HelloController.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date 2013-5-3 下午10:24:49
 */
package com.joydeal.controllers;

import com.joydeal.controllers.annotations.LoginRequired;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author leo
 */
@Path("")
public class HelloController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Get("")
    public String index(Invocation inv) {
        return successResult("welcome to joydeal home page!欢迎来到交易地首页！");
    }

    @LoginRequired
    @Get("shouldlogin")
    public String shouldlogin() {
        LOGGER.info("{HelloController.index} debug in hello ");
        return successResult("Good! This api required login, and u got that!");
    }
}
