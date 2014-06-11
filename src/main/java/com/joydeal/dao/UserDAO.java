/**
 * UserDAO.java
 * [CopyRight]
 * @author leo [leoyonn@gmail.com]
 * @date 2013-8-18 下午4:04:42
 */
package com.joydeal.dao;

import com.joydeal.result.Auth;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;
import org.springframework.dao.DataAccessException;
import com.joydeal.thrift.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author leo
 */
@DAO
public interface UserDAO {
    String TableName = "user";
    String KEYS = "id,account,name,desc,gender,email,phone,avatar,password,passtoken";
    String VALUES = ":id,:account,:name,:desc,:gender,:email,:phone,:avatar,:password,:passtoken";
    String VALUES_OBJ = ":u.id,:u.account,:u.name,:u.desc,:u.gender.ordinal()," +
            ":u.email,:u.phone,:u.avatar,:u.password,:u.passtoken";
    String KVS = "account=:account,name=:name,desc=:desc,gender=:gender," +
            "email=:email,phone=:phone,avatar=:avatar,password=:password,passtoken=:passtoken";

    String KVS_OBJ = "id=:u.id,account=:u.account,name=:u.name,desc=:u.desc,gender=:u.gender," +
            "email=:u.email,phone=:u.phone,avatar=:u.avatar,password=:u.password,passtoken=:u.passtoken";


    @SQL("INSERT INTO " + TableName + "(" + KEYS + ") VALUES (" + VALUES + ")")
    public boolean add(@SQLParam("id") String userId,
                       @SQLParam("account") String account,
                       @SQLParam("name") String name,
                       @SQLParam("desc") String desc,
                       @SQLParam("gender") byte gender,
                       @SQLParam("email") String email,
                       @SQLParam("phone") String phone,
                       @SQLParam("avatar") String avatar,
                       @SQLParam("password") String password,
                       @SQLParam("passtoken") String passtoken) throws SQLException, DataAccessException;

    @SQL("INSERT INTO " + TableName + "(" + KEYS + ") VALUES (" + VALUES_OBJ + ")")
    public boolean add(@SQLParam("u") User user) throws SQLException, DataAccessException;

    @SQL("UPDATE " + TableName + " SET " + KVS + " WHERE id=:id")
    public boolean update(@SQLParam("id") String userId,
                          @SQLParam("account") String account,
                          @SQLParam("name") String name,
                          @SQLParam("desc") String desc,
                          @SQLParam("gender") byte gender,
                          @SQLParam("email") String email,
                          @SQLParam("phone") String phone,
                          @SQLParam("avatar") String avatar,
                          @SQLParam("password") String password,
                          @SQLParam("passtoken") String passtoken) throws SQLException, DataAccessException;

    @SQL("UPDATE " + TableName + " SET " + KVS_OBJ + " WHERE id=:u.id")
    public boolean update(@SQLParam("u") User user) throws SQLException, DataAccessException;

    @SQL("UPDATE " + TableName + " SET " + "password=:newpass" + " WHERE id=:id AND password=:oldpass")
    public boolean updatePasswordById(@SQLParam("id") String id, @SQLParam("oldpass") String oldpass,
                                      @SQLParam("newpass") String newpass) throws SQLException, DataAccessException;

    @SQL("UPDATE " + TableName + " SET " + "password=:newpass" + " WHERE account=:account AND password=:oldpass")
    public boolean updatePasswordByAccount(@SQLParam("account") String account,
                                           @SQLParam("oldpass") String oldpass, @SQLParam("newpass") String newpass) throws SQLException, DataAccessException;

//    /**
//     * 获取用户密码
//     *
//     * @param id
//     * @return
//     * @throws java.sql.SQLException, DataAccessException
//     */
//    @SQL("SELECT \"id\", \"account\", \"password\" , \"corpId\" , \"deptId\" FROM "
//            + TableName + " WHERE \"id\" = :id")
//    public Auth authById(@SQLParam("id") String id) throws SQLException, DataAccessException;
//
//    /**
//     * 获取用户密码
//     *
//     * @param account
//     * @return
//     * @throws java.sql.SQLException, DataAccessException
//     */
//    @SQL("SELECT \"id\", \"account\", \"password\" , \"corpId\" , \"deptId\" FROM "
//            + TableName + " WHERE \"account\" = :account")
//    public Auth authByAccount(@SQLParam("account") String account) throws SQLException, DataAccessException;
//
//    /**
//     * 获取一个用户的所有信息
//     *
//     * @param account
//     * @return
//     * @throws java.sql.SQLException, DataAccessException
//     */
//    @SQL("SELECT " + KEYS_NO_PASS + " FROM " + TableName + " WHERE \"account\" = :account")
//    public User getUserByAccount(@SQLParam("account") String account) throws SQLException, DataAccessException;
//
//    /**
//     * 获取一个用户的所有信息
//     *
//     * @param id
//     * @return
//     * @throws java.sql.SQLException, DataAccessException
//     */
//    @SQL("SELECT " + KEYS_NO_PASS + " FROM " + TableName + " WHERE \"id\" = :id")
//    public User getUserById(@SQLParam("id") String id) throws SQLException, DataAccessException;
//
//    /**
//     * 通过id列表获取多个用户的所有信息
//     *
//     * @param userIds
//     * @return
//     */
//    @SQL("SELECT " + KEYS_CARD + " FROM " + TableName + " WHERE \"id\" IN (:ids) ORDER BY \"id\"")
//    public List<User> getUserCardsById(@SQLParam("ids") List<String> userIds) throws SQLException, DataAccessException;
//
//    /**
//     * 获取所有的用户
//     * 警告：仅供测试、调试使用！
//     *
//     * @return
//     */
//    @SQL("SELECT " + KEYS_NO_PASS + " FROM " + TableName + " ORDER BY \"id\"")
//    public List<User> all() throws SQLException, DataAccessException;
//
//    @SQL("SELECT " + KEYS_CARD + " FROM " + TableName
//            + " WHERE \"corpId\" = :corpId AND (\"froleCode\" <= 0 OR \"froleCode\" = :froleCode) ORDER BY \"id\"")
//    public List<User> getUserCardsOfCorpWithFroleOrNoFrole(
//            @SQLParam("corpId") String corpId, @SQLParam("froleCode") int froleCode) throws SQLException, DataAccessException;
//
//    @SQL("SELECT " + KEYS_CARD + " FROM " + TableName
//            + " WHERE \"corpId\" = :corpId AND \"deptId\" = :deptId AND"
//            + " (\"froleCode\" <= 0 OR \"froleCode\" = :froleCode) ORDER BY \"id\"")
//    public List<User> getUserCardsOfDeptWithFroleOrNoFrole(
//            @SQLParam("corpId") String corpId, @SQLParam("deptId") String deptId,
//            @SQLParam("froleCode") int froleCode) throws SQLException, DataAccessException;
//
//    @SQL("SELECT " + KEYS_CARD + " FROM " + TableName
//            + " WHERE \"corpId\" = :corpId AND (\"droleCode\" <= 0 OR \"droleCode\" = :droleCode) ORDER BY \"id\"")
//    public List<User> getUserCardsOfCorpWithDroleOrNoDrole(
//            @SQLParam("corpId") String corpId, @SQLParam("droleCode") int droleCode) throws SQLException, DataAccessException;
//
//    @SQL("SELECT " + KEYS_CARD + " FROM " + TableName
//            + " WHERE \"corpId\" = :corpId AND \"deptId\" = :deptId AND"
//            + " (\"droleCode\" <= 0 OR \"droleCode\" = :droleCode) ORDER BY \"id\"")
//    public List<User> getUserCardsOfDeptWithDroleOrNoDrole(
//            @SQLParam("corpId") String corpId, @SQLParam("deptId") String deptId,
//            @SQLParam("droleCode") int droleCode) throws SQLException, DataAccessException;
//
//    @SQL("SELECT COUNT(\"id\") FROM " + TableName + " WHERE \"deptId\" IN (:deptIds)")
//    public int countUserOfDepts(@SQLParam("deptIds") List<String> deptIds) throws SQLException, DataAccessException;
//
//    @SQL("SELECT COUNT(\"id\") FROM " + TableName + " WHERE \"corpId\" IN (:corpIds)")
//    public int countUserOfCorps(@SQLParam("corpIds") List<String> corpIds) throws SQLException, DataAccessException;
//
//    /**
//     * 删除用户
//     *
//     * @return
//     * @throws java.sql.SQLException, DataAccessException
//     */
//    @SQL("DELETE FROM " + TableName + " WHERE \"id\" IN (:ids)")
//    public int delete(@SQLParam("ids") List<String> ids) throws SQLException, DataAccessException;
//
//
//    /**
//     * 删除所有数据
//     * 警告：仅供测试、调试使用！
//     *
//     * @return
//     * @throws java.sql.SQLException
//     * @throws DataAccessException
//     */
//    @SQL("DELETE FROM " + TableName)
//    public int clear() throws SQLException, DataAccessException;
}
