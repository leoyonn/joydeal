/**
 *
 * ZoneDAO.java
 * @date 14-6-17 下午10:17
 * @author leo [liuy@xiaomi.com]
 * [CopyRight] All Rights Reserved.
 */

package com.joydeal.dao;

import com.joydeal.thrift.Zone;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.RowHandler;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;
import org.springframework.dao.DataAccessException;

import java.sql.SQLException;
import java.util.List;

/**
 * @author leo
 */
@DAO
public interface ZoneDAO {
    String TableName = "zone";

    String KEYS = "`name`,`category`,`desc`,`lon`,`lat`,`landmark`,`address`," +
            "`lord`,`creator`,`icon`,`createAt`";
    String VALUES_OBJ = ":z.name,:z.category.name,:z.desc,:z.pos.lon,:z.pos.lat,:z.pos.name,:z.pos.address," +
            ":z.lord.id,:z.creator.id,:z.icon,:z.createAt";
    String KVS_OBJ = "`name`=:z.name,`category`=:z.category.name,`desc`=:z.desc," +
            "`lon`=:z.pos.lon,`lat`=:z.pos.lat,`landmark`=:z.pos.name,`address`=:z.pos.address," +
            "`lord`=:z.lord.id,`creator`=:z.creator.id," +
            "`icon`=:z.icon,`createAt`=:z.createAt";

    @SQL("INSERT INTO " + TableName + "(" + KEYS + ") VALUES (" + VALUES_OBJ + ")")
    public boolean add(@SQLParam("z") Zone zone) throws SQLException, DataAccessException;

    @SQL("UPDATE " + TableName + " SET " + KVS_OBJ + " WHERE id=:z.id")
    public boolean update(@SQLParam("z") Zone zone) throws SQLException, DataAccessException;

    @RowHandler(rowMapper = ZoneConverter.class, checkColumns = false)
    @SQL("SELECT `id`," + KEYS + " FROM " + TableName + " ORDER BY id")
    public List<Zone> all() throws SQLException, DataAccessException;

    @RowHandler(rowMapper = ZoneConverter.class, checkColumns = false)
    @SQL("SELECT `id`," + KEYS + " FROM " + TableName + " WHERE id = :id")
    public Zone get(@SQLParam("id") long id) throws SQLException, DataAccessException;

    @SQL("SELECT MAX(LAST_INSERT_ID()) FROM " + TableName)
    public long lastAddedId() throws SQLException, DataAccessException;

    @SQL("DELETE FROM " + TableName)
    public int clear() throws SQLException, DataAccessException;

}
