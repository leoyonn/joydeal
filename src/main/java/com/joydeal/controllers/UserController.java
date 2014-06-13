/**
 * UserController.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date 2013-6-11 下午5:36:55
 */
package com.joydeal.controllers;

import com.joydeal.base.Constants;
import com.joydeal.controllers.annotations.LoginRequired;
import com.joydeal.result.ErrorCode;
import com.joydeal.result.OperResult;
import com.joydeal.service.UserService;
import com.joydeal.thrift.User;
import com.joydeal.utils.CookieUtils;
import com.joydeal.utils.HttpUtils;
import com.joydeal.utils.IdUtils;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author leo
 */
@LoginRequired
@Path("u")
public class UserController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Get("")
    public String index(Invocation inv) {
        User user = (User) inv.getModel("userInfo");
        LOGGER.debug("User in model: {}", user);
        if (user == null) {
            long userId = Long.valueOf((String) inv.getModel("uuid"));
            LOGGER.debug("User index page after login/reg: {}", userId);
            OperResult<User> userResult = userService.getUser(userId);
            if (userResult.getError() != ErrorCode.Success) {
                inv.addModel("message", userResult.error.desc() + ": " + userResult.reason);
                return "login";
            }
            inv.addModel("userInfo", userResult.result);
        }
        return "user_info";
    }

    @Get("/{user:.+}")
    public String userInfo(Invocation inv, @Param("user") String user) {

        return "user_info";
    }


}