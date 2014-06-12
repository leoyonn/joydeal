/**
 * IdUtils.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date May 14, 2013 7:25:24 PM
 */
package com.joydeal.utils;

import com.joydeal.base.Constants;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Pattern;

/**
 *
 * @author leo
 */
public class IdUtils {
    public static boolean invalid(long id) {
        return Constants.INVALID_ID == id;
    }

    public static long userId(String s) {
        try {
            return Long.valueOf(s);
        } catch (Exception ex) {
            return Constants.INVALID_ID;
        }
    }
}
