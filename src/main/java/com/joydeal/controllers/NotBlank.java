/**
 * NotBlank.java
 * [CopyRight]
 * @author leo [leoyonn@gmail.com]
 * @date 2013-7-7 上午10:45:45
 */
package com.joydeal.controllers;

import net.paoding.rose.web.annotation.Path;

import java.lang.annotation.*;

/**
 * 将{@link NotBlank}标注在控制器方法的参数上，可以获得在{@link Path}
 * 中的占位符的参数，或者request的请求参数，当这个参数为blank时，请求将中断，抛出对应的出错提示
 * {"S":"Err","R":"test2参数不能为空"}。
 * <p/>
 * 一般情况下，实际上在url
 * path中的参数，不需要标这个标注，因为如果path中的参数为blank，连上层的路由都通不过，
 * 当然在明白原理的情况下也可以使用，不会造成额外的开销
 * <p/>
 * blank的判断方式：<br>
 * StringUtils.isBlank(null) = true<br>
 * StringUtils.isBlank("") = true<br>
 * StringUtils.isBlank(" ") = true<br>
 * StringUtils.isBlank("bob") = false<br>
 * StringUtils.isBlank("  bob  ") = false<br>
 *
 * @author leo
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotBlank {

}
