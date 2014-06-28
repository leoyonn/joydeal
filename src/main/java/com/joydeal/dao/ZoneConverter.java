/**
 *
 * UserConverter.java
 * @date 14-6-12 下午1:40
 * @author leo [liuy@xiaomi.com]
 * [CopyRight] All Rights Reserved.
 */

package com.joydeal.dao;

import com.joydeal.service.CategoryService;
import com.joydeal.service.UserService;
import com.joydeal.service.ZoneService;
import com.joydeal.thrift.Good;
import com.joydeal.thrift.Position;
import com.joydeal.thrift.Status;
import com.joydeal.thrift.Zone;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author leo
 */
public class ZoneConverter implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Position pos = new Position().setName(rs.getString("landmark"))
                .setAddress(rs.getString("address"))
                .setLon(rs.getDouble("lon"))
                .setLat(rs.getDouble("lat"));
        return new Zone()
                .setId(rs.getLong("id"))
                .setName(rs.getString("name"))
                .setDesc(rs.getString("desc"))
                .setIcon(rs.getString("icon"))
                .setPos(pos)
                .setCategory(CategoryService.instance().get(rs.getString("category")).getResult())
                .setCreator(UserService.instance().getUser(rs.getLong("creator")).getResult())
                .setLord(UserService.instance().getUser(rs.getLong("lord")).getResult())
                .setCreateAt(rs.getLong("createAt"));
    }
}
