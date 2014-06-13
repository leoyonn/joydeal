/**
 * LoginChecker.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date 2013-5-26 下午1:06:44
 */
package com.joydeal.controllers;

import com.google.gson.Gson;
import com.joydeal.base.Constants;
import com.joydeal.thrift.User;
import com.joydeal.utils.AuthUtils;
import com.joydeal.utils.CookieUtils;
import com.joydeal.utils.IdUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * handle login required checking.
 *
 * @author leo
 */
public class LoginChecker {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginChecker.class);

    // private UserService userService = new UserService();

    public static class LoginRequiredCheckResult {
        public boolean success = false;
        public String ssecurity;
        public String uuid;
        public User user;

        public String toString() {
            return new Gson().toJson(this, getClass());
        }
    }

    /**
     * constructor
     */
    public LoginChecker() {
    }

    /**
     * check if request is with login.
     *
     * @param request
     * @param response
     * @param isBrowser
     * @return
     */
    public LoginRequiredCheckResult doCheck(HttpServletRequest request, HttpServletResponse response, boolean isBrowser) {
        LOGGER.debug("enter doCheck, isBrowser:{}", isBrowser);
        LoginRequiredCheckResult result = new LoginRequiredCheckResult();
        result.success = false;

        // check token from cookie
        String token = CookieUtils.getCookie(request, Constants.COOKIE_KEY_PASSTOKEN);
        User authed = AuthUtils.decryptPasstoken(token);
        LOGGER.debug("check token: {}|{}", token, authed);
        if (token == null || authed == null || authed.account == null) {
            return result;
        }

        // check user id from cookie and token
        long userIdFromCookie = IdUtils.userId(CookieUtils.getCookie(request, "userId"));
        if (IdUtils.invalid(userIdFromCookie) || userIdFromCookie != authed.id) {
            LOGGER.warn("invalid userId, in-cookie {}, in-serviceToken {}", userIdFromCookie, authed.id);
            return result;
        }
        // check token and user id from request parameters
        if (isBrowser) {
            if (request.getMethod().toUpperCase().equals("POST")) {
                String tokenFromReq = request.getParameter(Constants.COOKIE_KEY_PASSTOKEN);
                if (StringUtils.isEmpty(tokenFromReq) || !tokenFromReq.equals(token)) {
                    LOGGER.warn("invalid service token, in-paramter {}, in-cookie {}", tokenFromReq, token);
                    return result;
                }
            }
            // String userIdFromParam = request.getParameter("userId");
            // if (StringUtils.isBlank(userIdFromParam) ||
            // !userIdFromParam.equals(userIdFromCookie)) {
            // return com.joydeal.result;
            // }
        }
        // got check com.joydeal.result
        result.success = true;
        result.uuid = String.valueOf(userIdFromCookie);
        result.user = authed;
        // TODO: result.ssecurity = authed.ssecurity;
        LOGGER.info("check login required: {}", result);
        return result;
    }
}
