package com.appoint.dao;

import com.appoint.entity.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    @Test
    public void queryUser() {
        String id = "20000001", pin = "000000";
        User user = userDao.queryUser(id, pin);
        System.out.println(user.toString());
    }

    @Test
    public void signUpUser() {
        String id = "20000001", pin = "000000";
        int signUp = userDao.signUpUser(id, pin);
        System.out.println(signUp);
    }
}
