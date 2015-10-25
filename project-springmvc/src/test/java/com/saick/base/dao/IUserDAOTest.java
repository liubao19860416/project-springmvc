package com.saick.base.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.saick.base.dao.api.IUserDAO;
import com.saick.base.dao.entiy.User;

/**
 * 下面使用了两种方式进行测试
 * 
 * 1.使用注解整合spring和junit测试
 * 
 * 2.使用加载applicationContext.xml配置文件实现
 *  
 *  3.可以读取数据库相关的信息
 *  
 * @author Liubao
 * @Version 1.0
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test/test-*.xml" })
public class IUserDAOTest {

    @Autowired
    private IUserDAO iUserDAO;// dao需要手动获取才能访问正常;

    @Resource(name = "sqlSessionFactory")
    SqlSessionFactory sqlSessionFactory;

    private ClassPathXmlApplicationContext applicationContext = null;

    // 不加载配置文件也是可以的;
    @Before
    public void setUp() throws IOException {
        System.out.println("提前执行的部分....");
        //applicationContext = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml"});
        // 方式二:直接获取sessionFactory对象(基于mybatis的获取方式)
        InputStream inputStream = Resources.getResourceAsStream("test/mybatis.cfg.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    
    /**
     * 通过sessionFactoryBean实现，读取数据库相关的信息
     */
    @Test
    public void testFindList() throws SQLException {
        // SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)applicationContext.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取当前数据库相关的版本信息
        String name = sqlSession.getConnection().getMetaData().getDatabaseProductName();
        String version = sqlSession.getConnection().getMetaData().getDatabaseProductVersion();
        System.out.println("名称:" + name + ",版本:" + version);
        //List<User> users = sqlSession.selectList("com.saick.base.dao.mapper.UserMapper.findAllUsers", null);
        //System.out.println(users);
    }

    /**
     * 通过mapper.xml文件实现
     */
    @Test
    public void testFindById() {
        // IUserDAO iUserDAO = (IUserDAO)applicationContext.getBean("IUserDAO");
        // 直接使用自动注入的也是可以的,也可以像上面这样通过applicationContext对象获取bean;
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        IUserDAO iUserDAO1 = sqlSession1.getMapper(IUserDAO.class);
        User user1 = iUserDAO1.findById(3l);
        // SqlSession sqlSession2 = sqlSessionFactory.openSession();
        // sqlSession2.selectOne("");
        // 一级缓存默认存在(查询缓存测试,需要跨session才可以实现)
        user1.setUsername("阿三1");
        iUserDAO1.update(user1);
        sqlSession1.close();
        //User user6 = iUserDAO2.findById(3l);
        //System.out.println(user6);
    }

    /**
     * 通过直接获取dao实体bean实现(基于spring与junit整合后的注解注入实现)
     */
    @Test
    public void testSave() {
        User user = new User("强强00", "123", "aqiang", "liu@123.com");
        iUserDAO.save(user);
    }

    /**
     * 测试批量添加数据
     */
    @Test
    public void testSaveManyByMap() {
        Map<String, List<User>> userMap = new HashMap<String, List<User>>();
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {
            User user = new User("QQQ" + i, "123", "aqiang", "liu@123.com");
            userList.add(user);
        }
        userMap.put("userMap", userList);
        iUserDAO.saveManyByMap(userMap);
    }

    @Test
    public void testSaveManyByList() {
        Map<String, List<User>> userMap = new HashMap<String, List<User>>();
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {
            User user = new User("88QQQ" + i, "123", "aqiang", "liu@123.com");
            userList.add(user);
        }
        iUserDAO.saveManyByList(userList);
    }

}
