/**
 *
 * ZoneDaoTest.java
 * @date 14-6-11 下午9:41
 * @author leo [liuy@xiaomi.com]
 * [CopyRight] All Rights Reserved.
 */

package com.joydeal.dao;

import com.joydeal.service.CategoryService;
import com.joydeal.service.UserService;
import com.joydeal.service.ZoneService;
import com.joydeal.thrift.*;
import org.junit.Assert;
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
public class ZoneDaoTest {
    @Autowired
    private ZoneDAO dao;
    @Autowired
    private CategoryDAO categoryDao;
    @Autowired
    private UserDAO userDao;

    @Autowired
    private CategoryService cs;
    @Autowired
    private UserService us;

    @Test
    public void test() throws SQLException {
        dao.clear();
        categoryDao.clear();
        userDao.clear();

        Category category = new Category().setName("租房").setDesc("...").setParent("生活");
        categoryDao.add(category);

        User user = new User().setAccount("account-001").setName("我是leo").setDesc("joydeal创始人")
                .setGender(Gender.findByValue(Gender.Man.ordinal()))
                .setEmail("leo@joydeal.com").setPhone("13811811888")
                .setAvatar("1").setPassword("pass").setPasstoken("passtoken");
        userDao.add(user);
        user.setId(userDao.lastAddedId());

        Zone zone = new Zone().setCategory(category).setDesc("我的区我做主")
                .setIcon("zone/123.jpg").setName("燕清源小区").setCreator(user).setLord(user)
                .setPos(new Position().setLon(116.46).setLat(39.92).setAddress("毛纺路69号").setName("燕清源"));
        dao.add(zone);
        long id = dao.lastAddedId();
        zone.setId(id);
        Zone got = dao.get(id);
        Assert.assertEquals(got, zone);
        dao.update(zone.setDesc("你的区我也做主"));
        got = dao.get(id);
        Assert.assertEquals(got, zone);
        Assert.assertEquals(zone, dao.all().get(0));

        dao.clear();
        categoryDao.clear();
        userDao.clear();
    }
}
