/**
 * LoginRequired.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date 2013-5-26 上午11:16:12
 */
package com.joydeal.controllers.annotations;

import java.lang.annotation.*;

/**
 * @author leo
 */
@Inherited
@Target({
        ElementType.TYPE, ElementType.METHOD
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginCheck {

}
