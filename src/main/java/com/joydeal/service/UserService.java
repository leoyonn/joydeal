/**
 * UserService.java
 * [CopyRight]
 * @author leo leoyonn@gmail.com
 * @date May 14, 2013 7:55:46 PM
 */
package com.joydeal.service;

import com.joydeal.dao.UserDAO;
import com.joydeal.result.OperResult;
import com.joydeal.thrift.User;
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

    public OperResult<Object> getUserById(String id) {
        return null;
    }

    public OperResult<User> login(String user, String password, String ip) {
        return null;
    }

    public OperResult<User> register(String account, String name, int gender, String email, String phone, String avatar,
                                     String pasword, String ip) {
        return null;
    }
}