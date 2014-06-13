/**
 * UserService.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date May 14, 2013 7:55:46 PM
 */
package com.joydeal.service;

import com.joydeal.dao.UserDAO;
import com.joydeal.result.ErrorCode;
import com.joydeal.result.OperResult;
import com.joydeal.thrift.User;
import com.joydeal.utils.IdUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author leo
 */
@Service
public class UserService extends BaseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDAO userDao;

    public OperResult<User> getUserById(String id) {
        return null;
    }

    public OperResult<User> login(String accountOrId, String password, String ip) {
        long id = IdUtils.userId(accountOrId);
        try {
            User user = IdUtils.invalid(id)
                    ? userDao.auth(accountOrId, password)
                    : userDao.auth(id, password);
            if (user == null) {
                return fail(ErrorCode.AuthDenied, "用户名或密码无效");
            }
            return success(user);
        } catch (Exception ex) {
            LOGGER.warn("Login user " + accountOrId + " got exception", ex);
            return fail(ErrorCode.DbError, "登录用户失败", ex);
        }
    }

    public OperResult<User> register(User user) {
        try {
            if (!userDao.add(user)) {
                return fail(ErrorCode.DbError, "注册用户失败");
            }
            user.setId(userDao.lastAddedId());
        } catch (Exception ex) {
            LOGGER.warn("Add user " + user + " got exception", ex);
            return fail(ErrorCode.DbError, "注册用户失败", ex);
        }
        return success(user);
    }

    public OperResult<User> auth(long id, String password) {
        try {
            User user = userDao.auth(id, password);
            if (user == null) {
                return fail(ErrorCode.AuthDenied, "用户名或密码无效");
            }
            return success(user);
        } catch (Exception ex) {
            LOGGER.warn("Auth user " + id + " got exception", ex);
            return fail(ErrorCode.DbError, "登录用户失败", ex);
        }
    }

    public OperResult<User> getUser(long id) {
        try {
            User user = userDao.get(id);
            if (user == null) {
                return fail(ErrorCode.InvalidUser, "无此用户");
            }
            return success(user);
        } catch (Exception ex) {
            LOGGER.warn("Auth user " + id + " got exception", ex);
            return fail(ErrorCode.DbError, "获取用户信息失败", ex);
        }
    }

    public OperResult<User> getUser(String accountOrId) {
        long id = IdUtils.userId(accountOrId);
        if (!IdUtils.invalid(id)) {
            return getUser(id);
        }
        try {
            User user = userDao.get(accountOrId);
            if (user == null) {
                return fail(ErrorCode.InvalidUser, "无此用户");
            }
            return success(user);
        } catch (Exception ex) {
            LOGGER.warn("Auth user " + accountOrId + " got exception", ex);
            return fail(ErrorCode.DbError, "获取用户信息失败", ex);
        }
    }

}