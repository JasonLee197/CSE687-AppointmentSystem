package com.appoint.dao;

import com.appoint.entity.AppointmentList;
import com.appoint.entity.SuccessAppoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessAppointDaoTest {
    @Resource
    private SuccessAppointDao successAppointDao;

    @Test
    public void queryHistory() {
        String userId = "10000001";
        List<AppointmentList> appointmentLists = successAppointDao.queryHistory(userId);
        for(AppointmentList appointmentList : appointmentLists)
            System.out.println(appointmentList.toString());
    }

    @Test
    public void insertSuccessAppoint() throws ParseException {
        long appointId = 1000;
        String userId = "10000001",
                doctorId = "10001",
                doctorName = "Jason";
        SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = simFormat.parse("2019-11-13 09:00:00");
        successAppointDao.insertSuccessAppoint(appointId, userId, doctorId, doctorName, startTime);
    }

    @Test
    public void querySuccessAppoint() {
        long appointId = 1000;
       // String userId = "10000001";
        SuccessAppoint successAppoint = successAppointDao.querySuccessAppoint(appointId);
        System.out.println(successAppoint.toString());
    }
}