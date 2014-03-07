/**
 * UserController.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date 2013-6-11 下午5:36:55
 */
package com.joydeal.controllers;

import com.joydeal.base.Constants;
import com.joydeal.result.ErrorCode;
import com.joydeal.result.OperResult;
import com.joydeal.service.UserService;
import com.joydeal.thrift.User;
import com.joydeal.utils.CookieUtils;
import com.joydeal.utils.HttpUtils;
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
@Path("user")
public class UserController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Get("login")
    public String login(Invocation inv) {
        return "login";
    }

    @Get("reg")
    public String register(Invocation inv) {
        return "reg";
    }

    @Get("info")
    public String userInfo(Invocation inv) {
        return "user_info";
    }

    @Get("{account:.+}")
    public String otherUserInfo(Invocation inv) {
        return "user_other";
    }

    @Get("info/up")
    public String userInfoUp(Invocation inv) {
        return "user_info_up";
    }

    @Post("reg")
    public String register(Invocation inv, @Param("account") String account, @Param("name") String name,
                           @Param("gender") int gender, @Param("email") String email, @Param("phone") String phone,
                           @Param("avatar") String avatar, @NotBlank @Param("password") String password) {
        OperResult<User> user = userService.register(account, name, gender, email, phone, avatar, password,
                inv.getRequest().getRemoteAddr());
        if (user.error != ErrorCode.Success) {
            return apiResult(user);
        }
        setAuthCookie(inv, user.result);
        return apiResult(user);
    }

    @Post("login")
    public String login(Invocation inv, @NotBlank @Param("user") String user, @NotBlank @Param("password") String password) {
        // TODO: permission check
        OperResult<User> loginUser = userService.login(user, password, inv.getRequest().getRemoteAddr());
        if (loginUser.error != ErrorCode.Success) {
            return apiResult(loginUser);
        }
        setAuthCookie(inv, loginUser.result);
        return apiResult(loginUser);
    }

    /**
     * 退出登录
     *
     * @param inv
     * @return
     */
    @SuppressWarnings("@Post")
    @Get("logout")
    public String logout(Invocation inv) {
        LOGGER.error("logout: {}", inv);
        CookieUtils.clearCookies(inv);
        return successResult("退出登录成功");
    }

    /**
     * 检查登录情况
     *
     * @param inv
     * @return
     */
    @Get("check")
    public String check(Invocation inv) {
        String userId = CookieUtils.getUserId(inv);
        LOGGER.info("got user from cookie: {}", userId);
        if (StringUtils.isBlank(userId)) {
            return failResult(ErrorCode.LoginRequired, "尚未登录");
        }
        return apiResult(userService.getUserById(userId));
    }

    private boolean setAuthCookie(Invocation inv, User user) {
        int expire = Constants.COOKIE_EXPIRE_SECONDS_2WEEK;
        CookieUtils.saveCookie(inv.getResponse(), Constants.COOKIE_KEY_USER_ID, String.valueOf(user.getId()), expire, "/",
                HttpUtils.getRootDomain(inv.getRequest()));
        CookieUtils.saveCookie(inv.getResponse(), Constants.COOKIE_KEY_USER_ID, String.valueOf(user.getId()), expire, "/", "");
        CookieUtils.saveCookie(inv.getResponse(), Constants.COOKIE_KEY_EXPIRE_TIME, String.valueOf(expire), expire, "/", "");
        CookieUtils.saveCookie(inv.getResponse(), Constants.COOKIE_KEY_PASS_TOKEN, user.getPasstoken(), expire, "/", "");
        return true;
    }
}