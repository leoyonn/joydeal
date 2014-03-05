/**
 * Constants.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date May 14, 2013 5:28:07 PM
 */
package com.joydeal.base;

/**
 * @author leo
 */
public interface Constants {
    int COOKIE_EXPIRE_SECONDS_2WEEK = 60 * 60 * 24 * 14;
    int COOKIE_EXPIRE_SECONDS_DEFAULT = -1;
    int INTERCEPTOR_PRIORITY_LOGIN = 1000;

    long INVALID_ID = -1;

    String DOMAIN = "wiselink.com";
    String COOKIE_KEY_USER_ID = "userId";
    String COOKIE_KEY_EXPIRE_TIME = "expireTime";
    String COOKIE_KEY_PASS_TOKEN = "passToken";
    String COOKIE_KEY_CORP_ID = "corpId";
    String COOKIE_KEY_DEPT_ID = "deptId";
    String SECURITY_KEY = "MTIzNDU2Nzg5MDEyMzQ1Ng==";
    String ENCODING = "UTF-8";

    int MAX_ROLE_NUM = 9999;
}
