/**
 *
 * NeedConverter.java
 * @date 14-6-12 下午1:40
 * @author leo [liuy@xiaomi.com]
 * [CopyRight] All Rights Reserved.
 */

package com.joydeal.dao;

import com.joydeal.service.CategoryService;
import com.joydeal.service.UserService;
import com.joydeal.service.ZoneService;
import com.joydeal.thrift.Good;
import com.joydeal.thrift.Need;
import com.joydeal.thrift.Status;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author leo
 */
public class NeedConverter implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Need()
                .setId(rs.getLong("id"))
                .setName(rs.getString("name"))
                .setDesc(rs.getString("desc"))
                .setIcon(rs.getString("icon"))
                .setCategory(CategoryService.instance().get(rs.getString("category")).getResult())
                .setOwner(UserService.instance().getUser(rs.getLong("owner")).getResult())
                .setSeller(UserService.instance().getUser(rs.getLong("seller")).getResult())
                .setZone(ZoneService.instance().get(rs.getLong("zone")).getResult())
                .setStatus(Status.findByValue(rs.getByte("status")))
                .setTtl(rs.getLong("ttl"))
                .setPrice(rs.getDouble("price"))
                .setCreateAt(rs.getLong("createAt"));
    }
}
