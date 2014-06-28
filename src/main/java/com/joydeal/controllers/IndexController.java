/**
 * IndexController.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date 2013-5-3 下午10:24:49
 */
package com.joydeal.controllers;

import com.joydeal.base.Constants;
import com.joydeal.controllers.annotations.LoginCheck;
import com.joydeal.controllers.annotations.LoginRequired;
import com.joydeal.result.ErrorCode;
import com.joydeal.result.OperResult;
import com.joydeal.service.UserService;
import com.joydeal.thrift.Gender;
import com.joydeal.thrift.User;
import com.joydeal.utils.AuthUtils;
import com.joydeal.utils.CookieUtils;
import com.joydeal.utils.HttpUtils;
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
@LoginCheck
@Path("")
public class IndexController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private UserService userService;

    @Get("")
    public String index(Invocation inv) {
        return "index";
    }

    @Get("index")
    public String index1(Invocation inv) {
        return index(inv);
    }

    @LoginRequired
    @Get("shouldlogin")
    public String shouldlogin() {
        LOGGER.info("{IndexController.index} debug in hello ");
        return successResult("Good! This api required login, and u got that!");
    }

    @Get("reg")
    public String register(Invocation inv) {
        return "reg";
    }

    @Post("reg")
    public String register(Invocation inv, @NotBlank @Param("account") String account,
                           @NotBlank @Param("name") String name,
                           @Param("desc") String desc,
                           @NotBlank @Param("gender") byte gender,
                           @NotBlank @Param("email") String email,
                           @NotBlank @Param("phone") String phone,
                           @Param("avatar") String avatar,
                           @NotBlank @Param("password") String password) {
        User user = new User().setAccount(account).setName(name).setDesc(desc)
                .setGender(Gender.findByValue(gender)).setEmail(email).setPhone(phone)
                .setAvatar(avatar).setPassword(password).setCreateAt(System.currentTimeMillis());
        OperResult<User> result = userService.register(user);
        if (result.error != ErrorCode.Success) {
            inv.addModel("message", result.error.desc() + "：" + result.reason);
            return "reg";
        }
        setAuthCookie(inv, result.result);
        inv.addModel("userInfo", result.result);
        return "user_info";
    }

    @Get("login")
    public String login(Invocation inv) {
        return "login";
    }

    @Post("login")
    public String login(Invocation inv, @NotBlank @Param("user") String user, @NotBlank @Param("password") String password) {
        OperResult<User> loginUser = userService.login(user, password, inv.getRequest().getRemoteAddr());
        if (loginUser.error != ErrorCode.Success) {
            inv.addModel("message", loginUser.error.desc() + ": " + loginUser.reason);
            return "login";
        }
        setAuthCookie(inv, loginUser.result);
        inv.addModel("userInfo", loginUser.result);
        return "user_info";
    }

    @Get("lost")
    public String lost(Invocation inv) {
        return "lost_password";
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
        inv.addModel("message", "登出成功！");
        return "login"; // TODO return "/"
    }

    /**
     * 检查登录情况
     *
     * @param inv
     * @return
     */
    @Get("check")
    public String check(Invocation inv) {
        String passtoken = getPasstoken(inv);
        LOGGER.info("got passtoken from cookie: {}", passtoken);
        User authed = AuthUtils.decryptPasstoken(passtoken);
        if (authed == null || authed.account == null) {
            return failResult(ErrorCode.LoginRequired, "尚未登录");
        }
        return apiResult(userService.auth(authed.id, authed.password));
    }

    private boolean setAuthCookie(Invocation inv, User user) {
        AuthUtils.genPasstoken(user, inv.getRequest().getRemoteAddr());
        int expire = Constants.COOKIE_EXPIRE_SECONDS_2WEEK;
        CookieUtils.saveCookie(inv.getResponse(), Constants.COOKIE_KEY_USER_ID, String.valueOf(user.getId()), expire, "/",
                HttpUtils.getRootDomain(inv.getRequest()));
        CookieUtils.saveCookie(inv.getResponse(), Constants.COOKIE_KEY_USER_ID, String.valueOf(user.getId()), expire, "/", "");
        CookieUtils.saveCookie(inv.getResponse(), Constants.COOKIE_KEY_EXPIRE_TIME, String.valueOf(expire), expire, "/", "");
        CookieUtils.saveCookie(inv.getResponse(), Constants.COOKIE_KEY_PASSTOKEN, user.getPasstoken(), expire, "/", "");
        return true;
    }


}
