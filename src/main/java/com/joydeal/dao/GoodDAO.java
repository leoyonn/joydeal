/**
 *
 * GoodDAO.java
 * @date 14-6-17 下午10:17
 * @author leo [liuy@xiaomi.com]
 * [CopyRight] All Rights Reserved.
 */

package com.joydeal.dao;

import com.joydeal.thrift.Good;
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
public interface GoodDAO {
    String TableName = "good";

    String KEYS = "`name`,`category`,`desc`,`owner`,`buyer`,`zone`,`ttl`,`price`,`status`,`icon`,`createAt`";
    String VALUES_OBJ = ":g.name,:g.category.name,:g.desc,:g.owner.id,:g.buyer.id,:g.zone.id," +
            ":g.ttl,:g.price,:g.status.value,:g.icon,:g.createAt";
    String KVS_OBJ = "name=:g.name,category=:g.category.name,`desc`=:g.desc,owner=:g.owner.id,buyer=:g.buyer.id," +
            "zone=:g.zone.id,ttl=:g.ttl,price=:g.price,status=:g.status.value,icon=:g.icon,createAt=:g.createAt";

    @SQL("INSERT INTO " + TableName + "(" + KEYS + ") VALUES (" + VALUES_OBJ + ")")
    public boolean add(@SQLParam("g") Good good) throws SQLException, DataAccessException;

    @SQL("UPDATE " + TableName + " SET " + KVS_OBJ + " WHERE id=:g.id")
    public boolean update(@SQLParam("g") Good good) throws SQLException, DataAccessException;

    @RowHandler(rowMapper = GoodConverter.class, checkColumns = false)
    @SQL("SELECT `id`," + KEYS + " FROM " + TableName + " ORDER BY id")
    public List<Good> all() throws SQLException, DataAccessException;

    @RowHandler(rowMapper = GoodConverter.class, checkColumns = false)
    @SQL("SELECT `id`," + KEYS + " FROM " + TableName + " WHERE id = :id")
    public Good get(@SQLParam("id") long id) throws SQLException, DataAccessException;

    @SQL("SELECT MAX(LAST_INSERT_ID()) FROM " + TableName)
    public long lastAddedId() throws SQLException, DataAccessException;

    @SQL("DELETE FROM " + TableName)
    public int clear() throws SQLException, DataAccessException;

}
