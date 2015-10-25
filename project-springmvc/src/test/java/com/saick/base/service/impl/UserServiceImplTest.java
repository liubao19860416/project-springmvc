package com.saick.base.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.saick.base.dao.entiy.User;
import com.saick.base.service.api.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test/test-*.xml"})
public class UserServiceImplTest {

    @Autowired
    private IUserService iUserService;

    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() {
        System.out.println("提前执行的部分....");
        // applicationContext = new ClassPathXmlApplicationContext(new String[]
        // { "applicationContext.xml" });

    }
    
    @Test
    @SuppressWarnings("deprecation")
    public void TestGetnow() {
        Date date = iUserService.getDateNow();
        System.out.println(date.toLocaleString());
        
        Timestamp timestamp = iUserService.getTimestampNow();
        System.out.println(timestamp.toLocaleString());
    }

    @Test
    public void testFindUserList() {
        List<User> userList = iUserService.findUserList();
        System.out.println(userList);
    }

    @Test
    public void testFindUserById() {
        User user1 = iUserService.findUserById(3l);
        User user2 = iUserService.findUserById(3l);
    }

    @Test
    public void testSaveUser() {
        User user = new User("强强", "123", "aqiang", "liu@123.com");
        iUserService.saveUser(user);
    }

}
