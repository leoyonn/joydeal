/**
 * IndexController.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date 2013-5-3 下午10:24:49
 */
package com.joydeal.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author leo
 */
@Path("/need")
public class NeedController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NeedController.class);

    @Get("")
    public String need(Invocation inv) {
        return "need";
    }

    @Get("{id:.*}")
    public String need(Invocation inv, @Param("id") String id) {
        inv.addModel("name", "测试需求");
        inv.addModel("desc", "测试说明");
        return "need";
    }
}
