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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

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
                .setAvatar("1").setPassword("pass").setPasstoken("passtoken");
        dao.add(user);
        System.out.println(dao.lastAddedId());
        user = new User().setAccount("account-002").setName("我是leo").setDesc("joydeal创始人")
                .setGender(Gender.findByValue(Gender.Man.ordinal()))
                .setEmail("leo@joydeal.com").setPhone("13811811888")
                .setAvatar("1").setPassword("pass").setPasstoken("passtoken");
        dao.add(user);
        System.out.println(dao.lastAddedId());
        System.out.println(dao.all());
        System.out.println(user = dao.get(user.account));
        System.out.println(dao.get(user.id));
        System.out.println(dao.auth(user.account, user.password));
        System.out.println(dao.auth(user.id, user.password));

        dao.clear();
    }
}
