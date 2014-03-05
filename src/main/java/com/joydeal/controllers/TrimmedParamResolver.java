/**
 * TrimmedParamResolver.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date May 14, 2013 5:11:18 PM
 */
package com.joydeal.controllers;

import com.joydeal.controllers.annotations.Trimmed;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.paramresolver.ParamMetaData;
import net.paoding.rose.web.paramresolver.ParamResolver;
import org.apache.commons.lang.StringUtils;

/**
 * @author leo
 */
public class TrimmedParamResolver implements ParamResolver {

    @Override
    public boolean supports(ParamMetaData metaData) {
        return metaData.getAnnotation(Trimmed.class) != null;
    }

    @Override
    public Object resolve(Invocation inv, ParamMetaData metaData) throws Exception {
        String paramName = metaData.getParamName();
        String value = inv.getParameter(paramName);
        if (StringUtils.isBlank(value)) {
            return StringUtils.EMPTY;
        }
        return value.trim();
    }
}
