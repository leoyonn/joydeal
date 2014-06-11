/**
 *
 * DaoConnectionTest.java
 * @date 14-6-11 下午8:26
 * @author leo [liuy@xiaomi.com]
 * [CopyRight] All Rights Reserved.
 */

package com.joydeal.dao;

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
public class DaoConnectionTest {
    @Autowired
    private DemoDAO dao;

    @Test
    public void test() throws SQLException {
        System.out.println(dao.clear());
        String v = "Hi!豆芽爸爸爱豆芽！";
        Assert.assertEquals(1, dao.add(v));
        List<String> r = dao.all();
        Assert.assertEquals(1, r.size());
        Assert.assertEquals(v, r.get(0));
        Assert.assertEquals(1, dao.clear());
    }
}
