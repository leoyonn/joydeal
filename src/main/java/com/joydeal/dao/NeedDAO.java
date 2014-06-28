/**
 *
 * NeedDAO.java
 * @date 14-6-17 下午10:17
 * @author leo [liuy@xiaomi.com]
 * [CopyRight] All Rights Reserved.
 */

package com.joydeal.dao;

import com.joydeal.thrift.Need;
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
public interface NeedDAO {
    String TableName = "need";

    String KEYS = "`name`,`category`,`desc`,`owner`,`seller`,`zone`,`ttl`,`price`,`status`,`icon`,`createAt`";
    String VALUES_OBJ = ":n.name,:n.category.name,:n.desc,:n.owner.id,:n.seller.id,:n.zone.id," +
            ":n.ttl,:n.price,:n.status.value,:n.icon,:n.createAt";
    String KVS_OBJ = "name=:n.name,category=:n.category.name,`desc`=:n.desc,owner=:n.owner.id,seller=:n.seller.id," +
            "zone=:n.zone.id,ttl=:n.ttl,price=:n.price,status=:n.status.value,icon=:n.icon,createAt=:n.createAt";

    @SQL("INSERT INTO " + TableName + "(" + KEYS + ") VALUES (" + VALUES_OBJ + ")")
    public boolean add(@SQLParam("n") Need need) throws SQLException, DataAccessException;

    @SQL("UPDATE " + TableName + " SET " + KVS_OBJ + " WHERE id=:n.id")
    public boolean update(@SQLParam("n") Need need) throws SQLException, DataAccessException;

    @RowHandler(rowMapper = NeedConverter.class, checkColumns = false)
    @SQL("SELECT `id`," + KEYS + " FROM " + TableName + " ORDER BY id")
    public List<Need> all() throws SQLException, DataAccessException;

    @RowHandler(rowMapper = NeedConverter.class, checkColumns = false)
    @SQL("SELECT `id`," + KEYS + " FROM " + TableName + " WHERE id = :id")
    public Need get(@SQLParam("id") long id) throws SQLException, DataAccessException;

    @SQL("SELECT MAX(LAST_INSERT_ID()) FROM " + TableName)
    public long lastAddedId() throws SQLException, DataAccessException;

    @SQL("DELETE FROM " + TableName)
    public int clear() throws SQLException, DataAccessException;

}
