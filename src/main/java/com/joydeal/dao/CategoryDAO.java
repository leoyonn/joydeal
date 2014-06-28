/**
 *
 * CategoryDAO.java
 * @date 14-6-28 下午1:52
 * @author leo [liuy@xiaomi.com]
 * [CopyRight] All Rights Reserved.
 */

package com.joydeal.dao;

import com.joydeal.thrift.Category;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;
import org.springframework.dao.DataAccessException;

import java.sql.SQLException;
import java.util.List;

/**
 * @author leo
 */
@DAO
public interface CategoryDAO {
    String TableName = "category";
    String KEYS = "`name`,`desc`,`parent`";
    String VALUES_OBJ = ":c.name,:c.desc,:c.parent";

    @SQL("INSERT INTO " + TableName + "(" + KEYS + ") VALUES (" + VALUES_OBJ + ")")
    public boolean add(@SQLParam("c") Category category) throws SQLException, DataAccessException;

    @SQL("SELECT " + KEYS + " FROM " + TableName + " ORDER BY name")
    public List<Category> all() throws SQLException, DataAccessException;

    @SQL("SELECT " + KEYS + " FROM " + TableName + " WHERE parent = :name ORDER BY name")
    public List<Category> children(@SQLParam("name") String name) throws SQLException, DataAccessException;

    @SQL("SELECT " + KEYS + " FROM " + TableName + " WHERE name = :name")
    public Category get(@SQLParam("name") String name) throws SQLException, DataAccessException;

    @SQL("DELETE FROM " + TableName)
    public int clear() throws SQLException, DataAccessException;
}
