package com.appoint.dao;

import com.appoint.entity.Doctor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class DoctorDaoTest {
    @Resource
    private DoctorDao doctorDao;

    @Test
    public void queryDoctor() {
        String id = "10001", pin = "jason";
        Doctor doctor = doctorDao.queryDoctor(id, pin);
        System.out.println(doctor.toString());
    }

    @Test
    public void signUpDoctor() {
        String id = "10003", pin = "123456", name = "William";
        int signUp = doctorDao.signUpDoctor(id, name, pin);
        System.out.println(signUp);
    }
}