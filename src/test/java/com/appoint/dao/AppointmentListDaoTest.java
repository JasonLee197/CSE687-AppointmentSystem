package com.appoint.dao;

import com.appoint.entity.AppointmentList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class AppointmentListDaoTest {

    @Resource
    private AppointmentListDao appointmentListDao;

    @Test
    public void queryAll() {
        List<AppointmentList> appointmentLists = appointmentListDao.queryAll(0, 100);
        for(AppointmentList appointmentList : appointmentLists)
            System.out.println(appointmentList.toString());
    }

    @Test
    public void queryByName() {
        String doctorName = "Jason";
        List<AppointmentList> appointmentLists = appointmentListDao.queryByName(doctorName);
        for(AppointmentList appointmentList : appointmentLists)
            System.out.println(appointmentList.toString());
    }

    @Test
    public void queryByStartTime() throws ParseException {
        SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = simFormat.parse("2019-11-13 09:00:00");
        List<AppointmentList> appointmentLists = appointmentListDao.queryByStartTime(startTime);
        for(AppointmentList appointmentList : appointmentLists)
            System.out.println(appointmentList.toString());
    }

    @Test
    public void queryById() {
        long id = 1003;
        AppointmentList appointmentList = appointmentListDao.queryById(id);
        System.out.println(appointmentList);
    }

    @Test
    public void queryByEndTime() throws ParseException {
        SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date endTime = simFormat.parse("2019-11-13 10:00:00");
        List<AppointmentList> appointmentLists = appointmentListDao.queryByEndTime(endTime);
        for(AppointmentList appointmentList : appointmentLists)
            System.out.println(appointmentList.toString());
    }

    @Test
    public void queryByState() {
        short state = 0;
        List<AppointmentList> appointmentLists = appointmentListDao.queryByState(state);
        for(AppointmentList appointmentList : appointmentLists)
            System.out.println(appointmentList.toString());
    }

    @Test
    public void updateState() {
        long appointId = 1000;
        appointmentListDao.updateState(appointId);
    }

    @Test
    public void insertAppointmentList() throws ParseException {
        //Initialize Date
        SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = simFormat.parse("2019-11-21 16:00:00");
        Date endTime = simFormat.parse("2019-11-21 17:00:00");
        String doctorId = "10002";
        String doctorName = "Jack";
        int insertResult;
        insertResult = appointmentListDao.insertAppointmentList(doctorId, doctorName, startTime, endTime);
        System.out.println(insertResult);
    }

    @Test
    public void deleteAppointmentList() {
        long appointId = 1006;
        appointmentListDao.deleteAppointmentList(appointId);
    }
}