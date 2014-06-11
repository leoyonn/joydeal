/**
 * UserDAO.java
 * [CopyRight]
 * @author leo [leoyonn@gmail.com]
 * @date 2013-8-18 下午4:04:42
 */
package com.joydeal.dao;

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
public interface DemoDAO {
    String tableName = "demo";

    @SQL("SELECT * FROM " + tableName)
    List<String> all() throws SQLException, DataAccessException;

    @SQL("INSERT INTO " + tableName + "(v) VALUES (:v)")
    int add(@SQLParam("v") String v) throws SQLException, DataAccessException;

    @SQL("DELETE FROM " + tableName)
    int clear() throws SQLException, DataAccessException;
}
