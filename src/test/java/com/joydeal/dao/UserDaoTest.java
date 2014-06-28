/**
 *
 * UserDaoTest.java
 * @date 14-6-11 下午9:41
 * @author leo [liuy@xiaomi.com]
 * [CopyRight] All Rights Reserved.
 */

package com.joydeal.dao;

import com.joydeal.thrift.Gender;
import com.joydeal.thrift.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * @author leo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest {
    @Autowired
    private UserDAO dao;

    @Test
    public void test() throws SQLException {
        dao.clear();
        User user = new User().setAccount("account-001").setName("我是leo").setDesc("joydeal创始人")
                .setGender(Gender.findByValue(Gender.Man.ordinal()))
                .setEmail("leo@joydeal.com").setPhone("13811811888")
                .setAvatar("111.jpg").setPassword("pass").setPasstoken("passtoken");
        dao.add(user);
        long id = dao.lastAddedId();
        User got = dao.get(id);
        user.setId(id);
        Assert.assertEquals(user, got);
        dao.update(user.setAvatar("222.jpg"));
        got = dao.get(id);
        Assert.assertEquals(user, got);

        dao.add(user.setAccount("account-002"));
        id = dao.lastAddedId();
        got = dao.get(id);
        user.setId(id);
        Assert.assertEquals(user, got);
        Assert.assertEquals(user, dao.get(user.account));
        Assert.assertEquals(user, dao.auth(user.account, user.password));
        Assert.assertEquals(user, dao.auth(user.id, user.password));

        dao.updatePassword("account-001", "pass", "pass111");
        dao.updatePassword(user.id, "pass", "pass222");

        List<User> all = dao.all();
        Assert.assertEquals(2, all.size());
        Assert.assertEquals("account-001", all.get(0).account);
        Assert.assertEquals("account-002", all.get(1).account);
        Assert.assertEquals("pass111", all.get(0).password);
        Assert.assertEquals("pass222", all.get(1).password);
        Assert.assertNull(dao.auth(user.account, user.password));
        Assert.assertNull(dao.auth(user.id, user.password));
        dao.clear();
    }
}
