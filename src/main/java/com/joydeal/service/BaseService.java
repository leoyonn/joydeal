/**
 * BaseService.java
 * [CopyRight]
 * @author leo [leoyonn@gmail.com]
 * @date 2013-8-25 上午10:35:15
 */
package com.joydeal.service;

import com.joydeal.result.ErrorCode;
import com.joydeal.result.OperResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author leo
 */
public class BaseService {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);

    protected static <T> OperResult<T> fail(ErrorCode e, String reason, Throwable ex) {
        String msg = ex.getMessage();
        if (ex.getCause() != null && ex.getCause().toString().contains("SQLIntegrityConstraintViolationException")) {
            msg = "违反唯一约束条件";
        }
        return new OperResult<T>(e, reason + msg);
    }

    protected static <T> OperResult<T> fail(ErrorCode e, String reason) {
        return new OperResult<T>(e, reason);
    }

    protected static <T> OperResult<T> success(T data) {
        return new OperResult<T>(data);
    }

    protected static <T> OperResult<List<T>> success(List<T> data) {
        return new OperResult<List<T>>(data, data.size());
    }

    protected static <T> OperResult<List<T>> success(List<T> data, int total) {
        return new OperResult<List<T>>(data, total);
    }

}
