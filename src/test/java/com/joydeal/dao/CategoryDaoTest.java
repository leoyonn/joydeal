/**
 *
 * CategoryDaoTest.java
 * @date 14-6-28 下午1:58
 * @author leo [liuy@xiaomi.com]
 * [CopyRight] All Rights Reserved.
 */

package com.joydeal.dao;

import com.joydeal.thrift.Category;
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
public class CategoryDaoTest {
    @Autowired
    private CategoryDAO dao;

    @Test
    public void test() throws SQLException {
        dao.clear();
        Category c1 = new Category().setName("买房").setParent("生活").setDesc("买房买房买房了");
        dao.add(c1);
        Category c2 = new Category().setName("买车").setParent("生活").setDesc("买车买车买车了");
        dao.add(c2);
        Category got1 = dao.get("买房");
        Category got2 = dao.get("买车");
        Assert.assertEquals(got1, c1);
        Assert.assertEquals(got2, c2);
        List<Category> all = dao.all();
        List<Category> children = dao.children("生活");
        Assert.assertEquals(2, children.size());
        Assert.assertEquals(all, children);
        dao.clear();
    }
}
