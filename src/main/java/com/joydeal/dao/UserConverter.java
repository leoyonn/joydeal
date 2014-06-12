/**
 *
 * UserConverter.java
 * @date 14-6-12 下午1:40
 * @author leo [liuy@xiaomi.com]
 * [CopyRight] All Rights Reserved.
 */

package com.joydeal.dao;

import com.joydeal.thrift.Gender;
import com.joydeal.thrift.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author leo
 */
public class UserConverter implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User()
                .setId(rs.getLong("id"))
                .setAccount(rs.getString("account"))
                .setName(rs.getString("name"))
                .setDesc(rs.getString("desc"))
                .setGender(Gender.findByValue(rs.getByte("gender")))
                .setEmail(rs.getString("email"))
                .setPhone(rs.getString("phone"))
                .setAvatar(rs.getString("avatar"))
                .setPassword(rs.getString("password"))
                .setPasstoken(rs.getString("passtoken"));
    }
}
