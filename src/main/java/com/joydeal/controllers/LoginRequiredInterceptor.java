/**
 * LoginRequiredInterceptor.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date 2013-5-26 上午11:21:55
 */
package com.joydeal.controllers;

import com.joydeal.base.Constants;
import com.joydeal.controllers.LoginRequiredChecker.LoginRequiredCheckResult;
import com.joydeal.controllers.annotations.LoginRequired;
import com.joydeal.result.ErrorCode;
import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;

/**
 * @author leo
 */
public class LoginRequiredInterceptor extends ControllerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginRequiredInterceptor.class);

    private LoginRequiredChecker checker;

    public LoginRequiredInterceptor() {
        checker = new LoginRequiredChecker();
    }

    @Override
    public int getPriority() {
        return Constants.INTERCEPTOR_PRIORITY_LOGIN;
    }

    @Override
    public Class<? extends Annotation> getRequiredAnnotationClass() {
        return LoginRequired.class;
    }

    @Override
    public Object before(Invocation inv) throws Exception {
        LOGGER.debug("enter LoginRequiredInterceptor with invocation: {}...", inv);
        LoginRequiredCheckResult result = checker.doCheck(inv.getRequest(), null, true);
        LOGGER.debug("exit sso required, com.joydeal.result {}", result.success);
        if (result.success) {
            inv.addModel("uuid", result.uuid);
            inv.addModel("ssecurity", result.ssecurity);
            return true;
        } else {
            return BaseController.failResult(ErrorCode.LoginRequired);
        }
    }
}
