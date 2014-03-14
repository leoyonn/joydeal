/**
 * IndexController.java
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
public class IndexController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Get("")
    public String index(Invocation inv) {
        return index1(inv);
    }

    @Get("index")
    public String index1(Invocation inv) {
        return "index";
    }

    @LoginRequired
    @Get("shouldlogin")
    public String shouldlogin() {
        LOGGER.info("{IndexController.index} debug in hello ");
        return successResult("Good! This api required login, and u got that!");
    }
}
