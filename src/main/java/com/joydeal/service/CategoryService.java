/**
 *
 * CategoryService.java
 * @date 14-6-16 下午10:26
 * @author leo [liuy@xiaomi.com]
 * [CopyRight] All Rights Reserved.
 */

package com.joydeal.service;

import com.joydeal.dao.CategoryDAO;
import com.joydeal.dao.UserDAO;
import com.joydeal.result.ErrorCode;
import com.joydeal.result.OperResult;
import com.joydeal.thrift.Category;
import com.joydeal.thrift.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author leo
 */
@Service
public class CategoryService extends BaseService {
    private static CategoryService instance;

    @Autowired
    private CategoryDAO dao;

    public CategoryService() {
        synchronized (CategoryService.class) {
            instance = this;
        }
    }

    public static CategoryService instance() {
        return instance;
    }

    @Autowired
    private CategoryDAO categoryDAO;

    public OperResult<Category> get(String name) {
        try {
            Category category = dao.get(name);
            if (category == null) {
                return fail(ErrorCode.InvalidParam, "无此分类信息");
            }
            return success(category);
        } catch (Exception ex) {
            LOGGER.warn("Load category info " + name + " got exception", ex);
            return fail(ErrorCode.DbError, "获取分类信息失败", ex);
        }
    }
}
