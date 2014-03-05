/**
 * UserDAO.java
 * [CopyRight]
 * @author leo [leoyonn@gmail.com]
 * @date 2013-8-18 下午4:04:42
 */
package com.joydeal.dao;

import com.joydeal.base.TableName;
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
    String KEYS_CARD = "\"id\", \"name\", \"posCode\", \"corpId\", \"deptId\"";
    String KEYS_NO_PASS = " \"id\", \"account\", \"name\", \"avatar\", \"email\", \"phone\", \"tel\","
            + "\"desc\", \"province\", \"city\", \"createTime\", \"creatorId\", \"updateTime\", \"operId\","
            + "\"catCode\",\"posCode\", \"froleCode\",\"droleCode\",\"statCode\",\"corpId\",\"deptId\"";
    String KEYS_HAS_PASS = KEYS_NO_PASS + ", \"password\"";

    String VALUES_NO_PASS = ":id,:account,:name,:avatar,:email,:phone,:tel,"
            + ":desc,:province,:city,sysdate,:creatorId,sysdate,:operId,"
            + ":catCode,:posCode,:froleCode,:droleCode,:statCode,:corpId,:deptId";
    String VALUES_HAS_PASS = VALUES_NO_PASS + ",:password";

    String VALUES_NO_PASS_OBJ = ":u.id,:u.account,:u.name,:u.avatar,:u.email,:u.phone,:u.tel,"
            + ":u.desc,:u.province,:u.city,sysdate,:u.creatorId,sysdate,:u.operId,"
            + ":u.catCode,:u.posCode,:u.froleCode,:u.droleCode,:u.statCode,:u.corpId,:u.deptId";
    String VALUES_HAS_PASS_OBJ = VALUES_NO_PASS_OBJ + ",:password";

    String KVS_NO_PASS = " \"account\"=:account, \"name\"=:name, \"avatar\"=:avatar, \"email\"=:email,"
            + " \"phone\"=:phone, \"tel\"=:tel, \"desc\"=:desc, \"province\"=:province, \"city\"=:city,"
            + " \"updateTime\"=sysdate, \"operId\"=:operId,"
            + " \"catCode\"=:catCode, \"posCode\"=:posCode, \"froleCode\"=:froleCode, \"droleCode\"=:droleCode,"
            + " \"statCode\"=:statCode,\"corpId\"=:corpId,\"deptId\"=:deptId";

    String KVS_NO_PASS_OBJ = " \"account\"=:u.account, \"name\"=:u.name, \"avatar\"=:u.avatar, \"email\"=:u.email,"
            + " \"phone\"=:u.phone, \"tel\"=:u.tel, \"desc\"=:u.desc, \"province\"=:u.province, \"city\"=:u.city,"
            + " \"updateTime\"=sysdate, \"operId\"=:u.operId,"
            + " \"catCode\"=:u.catCode, \"posCode\"=:u.posCode, \"froleCode\"=:u.froleCode, \"droleCode\"=:u.droleCode,"
            + " \"statCode\"=:u.statCode,\"corpId\"=:u.corpId,\"deptId\"=:u.deptId";

    /**
     * 添加一个用户信息
     *
     * @param userId
     * @param account
     * @param name
     * @param password
     * @param avatar
     * @param email
     * @param phone
     * @param tel
     * @param desc
     * @param province
     * @param city
     * @param creatorId
     * @param operId
     * @param catCode
     * @param posCode
     * @param froleCode
     * @param droleCode
     * @param statCode
     * @param corpId
     * @param deptId
     * @return
     * @throws java.sql.SQLException
     * @throws DataAccessException
     */
    @SQL("INSERT INTO " + TableName.User + "(" + KEYS_HAS_PASS + ") VALUES (" + VALUES_HAS_PASS + ")")
    public boolean add(@SQLParam("id") String userId,
                       @SQLParam("account") String account,
                       @SQLParam("name") String name,
                       @SQLParam("password") String password,
                       @SQLParam("avatar") String avatar,
                       @SQLParam("email") String email,
                       @SQLParam("phone") String phone,
                       @SQLParam("tel") String tel,
                       @SQLParam("desc") String desc,
                       @SQLParam("province") String province,
                       @SQLParam("city") String city,
                       @SQLParam("creatorId") String creatorId,
                       @SQLParam("operId") String operId,

                       @SQLParam("catCode") int catCode,
                       @SQLParam("posCode") int posCode,
                       @SQLParam("froleCode") int froleCode,
                       @SQLParam("droleCode") int droleCode,
                       @SQLParam("statCode") int statCode,
                       @SQLParam("corpId") String corpId,
                       @SQLParam("deptId") String deptId) throws SQLException, DataAccessException;

    /**
     * 添加一个用户信息
     *
     * @param user
     * @param password
     * @return
     * @throws java.sql.SQLException
     * @throws DataAccessException
     */
    @SQL("INSERT INTO " + TableName.User + "(" + KEYS_HAS_PASS + ") VALUES (" + VALUES_HAS_PASS_OBJ + ")")
    public boolean add(@SQLParam("u") User user, @SQLParam("password") String password) throws SQLException, DataAccessException;

    /**
     * 更新一个用户信息
     *
     * @param id
     * @param account
     * @param name
     * @param avatar
     * @param email
     * @param phone
     * @param tel
     * @param desc
     * @param province
     * @param city
     * @param creatorId
     * @param operId
     * @param catCode
     * @param posCode
     * @param froleCode
     * @param droleCode
     * @param statCode
     * @param corpId
     * @param deptId
     * @return
     * @throws java.sql.SQLException
     * @throws DataAccessException
     */
    @SQL("UPDATE " + TableName.User + " SET " + KVS_NO_PASS + " WHERE \"id\"=:id")
    public boolean update(@SQLParam("id") String id,
                          @SQLParam("account") String account,
                          @SQLParam("name") String name,
                          @SQLParam("avatar") String avatar,
                          @SQLParam("email") String email,
                          @SQLParam("phone") String phone,
                          @SQLParam("tel") String tel,
                          @SQLParam("desc") String desc,
                          @SQLParam("province") String province,
                          @SQLParam("city") String city,
                          @SQLParam("creatorId") String creatorId,
                          @SQLParam("operId") String operId,

                          @SQLParam("catCode") int catCode,
                          @SQLParam("posCode") int posCode,
                          @SQLParam("froleCode") int froleCode,
                          @SQLParam("droleCode") int droleCode,
                          @SQLParam("statCode") int statCode,
                          @SQLParam("corpId") String corpId,
                          @SQLParam("deptId") String deptId) throws SQLException, DataAccessException;

    /**
     * 更新一个用户信息
     *
     * @param u
     * @return
     * @throws java.sql.SQLException
     * @throws DataAccessException
     */
    @SQL("UPDATE " + TableName.User + " SET " + KVS_NO_PASS_OBJ + " WHERE \"id\"=:u.id")
    public boolean update(@SQLParam("u") User u) throws SQLException, DataAccessException;

    /**
     * 更新用户密码
     *
     * @param id
     * @param oldpass
     * @param newpass
     * @return
     * @throws java.sql.SQLException
     * @throws DataAccessException
     */
    @SQL("UPDATE " + TableName.User + " SET " + "\"password\"=:newpass"
            + " WHERE \"id\"=:id and \"password\"=:oldpass")
    public boolean updatePasswordById(@SQLParam("id") String id,
                                      @SQLParam("oldpass") String oldpass, @SQLParam("newpass") String newpass) throws SQLException, DataAccessException;

    /**
     * 更新用户密码
     *
     * @param account
     * @param oldpass
     * @param newpass
     * @return
     * @throws java.sql.SQLException
     * @throws DataAccessException
     */
    @SQL("UPDATE " + TableName.User + " SET " + "\"password\"=:newpass"
            + " WHERE \"account\"=:account and \"password\"=:oldpass")
    public boolean updatePasswordByAccount(@SQLParam("account") String account,
                                           @SQLParam("oldpass") String oldpass, @SQLParam("newpass") String newpass) throws SQLException, DataAccessException;

    @SQL("UPDATE " + TableName.User + " SET " + "\"froleCode\"=:froleCode WHERE \"id\"=:id")
    public boolean updateFuncRole(@SQLParam("id") String id, @SQLParam("froleCode") int froleCode)
            throws SQLException, DataAccessException;

    @SQL("UPDATE " + TableName.User + " SET " + "\"droleCode\"=:droleCode WHERE \"id\"=:id")
    public boolean updateDataRole(@SQLParam("id") String id, @SQLParam("droleCode") int droleCode)
            throws SQLException, DataAccessException;

    /**
     * 获取用户密码
     *
     * @param id
     * @return
     * @throws java.sql.SQLException, DataAccessException
     */
    @SQL("SELECT \"id\", \"account\", \"password\" , \"corpId\" , \"deptId\" FROM "
            + TableName.User + " WHERE \"id\" = :id")
    public Auth authById(@SQLParam("id") String id) throws SQLException, DataAccessException;

    /**
     * 获取用户密码
     *
     * @param account
     * @return
     * @throws java.sql.SQLException, DataAccessException
     */
    @SQL("SELECT \"id\", \"account\", \"password\" , \"corpId\" , \"deptId\" FROM "
            + TableName.User + " WHERE \"account\" = :account")
    public Auth authByAccount(@SQLParam("account") String account) throws SQLException, DataAccessException;

    /**
     * 获取一个用户的所有信息
     *
     * @param account
     * @return
     * @throws java.sql.SQLException, DataAccessException
     */
    @SQL("SELECT " + KEYS_NO_PASS + " FROM " + TableName.User + " WHERE \"account\" = :account")
    public User getUserByAccount(@SQLParam("account") String account) throws SQLException, DataAccessException;

    /**
     * 获取一个用户的所有信息
     *
     * @param id
     * @return
     * @throws java.sql.SQLException, DataAccessException
     */
    @SQL("SELECT " + KEYS_NO_PASS + " FROM " + TableName.User + " WHERE \"id\" = :id")
    public User getUserById(@SQLParam("id") String id) throws SQLException, DataAccessException;

    /**
     * 通过id列表获取多个用户的所有信息
     *
     * @param userIds
     * @return
     */
    @SQL("SELECT " + KEYS_CARD + " FROM " + TableName.User + " WHERE \"id\" IN (:ids) ORDER BY \"id\"")
    public List<User> getUserCardsById(@SQLParam("ids") List<String> userIds) throws SQLException, DataAccessException;

    /**
     * 获取所有的用户
     * 警告：仅供测试、调试使用！
     *
     * @return
     */
    @SQL("SELECT " + KEYS_NO_PASS + " FROM " + TableName.User + " ORDER BY \"id\"")
    public List<User> all() throws SQLException, DataAccessException;

    @SQL("SELECT " + KEYS_CARD + " FROM " + TableName.User
            + " WHERE \"corpId\" = :corpId AND (\"froleCode\" <= 0 OR \"froleCode\" = :froleCode) ORDER BY \"id\"")
    public List<User> getUserCardsOfCorpWithFroleOrNoFrole(
            @SQLParam("corpId") String corpId, @SQLParam("froleCode") int froleCode) throws SQLException, DataAccessException;

    @SQL("SELECT " + KEYS_CARD + " FROM " + TableName.User
            + " WHERE \"corpId\" = :corpId AND \"deptId\" = :deptId AND"
            + " (\"froleCode\" <= 0 OR \"froleCode\" = :froleCode) ORDER BY \"id\"")
    public List<User> getUserCardsOfDeptWithFroleOrNoFrole(
            @SQLParam("corpId") String corpId, @SQLParam("deptId") String deptId,
            @SQLParam("froleCode") int froleCode) throws SQLException, DataAccessException;

    @SQL("SELECT " + KEYS_CARD + " FROM " + TableName.User
            + " WHERE \"corpId\" = :corpId AND (\"droleCode\" <= 0 OR \"droleCode\" = :droleCode) ORDER BY \"id\"")
    public List<User> getUserCardsOfCorpWithDroleOrNoDrole(
            @SQLParam("corpId") String corpId, @SQLParam("droleCode") int droleCode) throws SQLException, DataAccessException;

    @SQL("SELECT " + KEYS_CARD + " FROM " + TableName.User
            + " WHERE \"corpId\" = :corpId AND \"deptId\" = :deptId AND"
            + " (\"droleCode\" <= 0 OR \"droleCode\" = :droleCode) ORDER BY \"id\"")
    public List<User> getUserCardsOfDeptWithDroleOrNoDrole(
            @SQLParam("corpId") String corpId, @SQLParam("deptId") String deptId,
            @SQLParam("droleCode") int droleCode) throws SQLException, DataAccessException;

    @SQL("SELECT COUNT(\"id\") FROM " + TableName.User + " WHERE \"deptId\" IN (:deptIds)")
    public int countUserOfDepts(@SQLParam("deptIds") List<String> deptIds) throws SQLException, DataAccessException;

    @SQL("SELECT COUNT(\"id\") FROM " + TableName.User + " WHERE \"corpId\" IN (:corpIds)")
    public int countUserOfCorps(@SQLParam("corpIds") List<String> corpIds) throws SQLException, DataAccessException;

    /**
     * 删除用户
     *
     * @return
     * @throws java.sql.SQLException, DataAccessException
     */
    @SQL("DELETE FROM " + TableName.User + " WHERE \"id\" IN (:ids)")
    public int delete(@SQLParam("ids") List<String> ids) throws SQLException, DataAccessException;


    /**
     * 删除所有数据
     * 警告：仅供测试、调试使用！
     *
     * @return
     * @throws java.sql.SQLException
     * @throws DataAccessException
     */
    @SQL("DELETE FROM " + TableName.User)
    public int clear() throws SQLException, DataAccessException;
}
