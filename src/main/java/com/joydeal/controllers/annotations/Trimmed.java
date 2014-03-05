/**
 * Trimmed.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date May 14, 2013 5:01:40 PM
 */

package com.joydeal.controllers.annotations;

import java.lang.annotation.*;

/**
 * @author leo
 */
@Target({
        ElementType.PARAMETER
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Trimmed {

}
