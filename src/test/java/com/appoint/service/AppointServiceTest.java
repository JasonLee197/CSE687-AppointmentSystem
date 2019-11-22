package com.appoint.service;

import com.appoint.dto.AppointExecution;
import com.appoint.entity.AppointmentList;
import com.appoint.entity.Doctor;
import com.appoint.entity.User;
import com.appoint.exception.IsAppointedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class AppointServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AppointService appointService;

    @Test
    public void signUpUser() {
        String id = "12345@gmail.com", pin = "54321";
        appointService.signUpUser(id, pin);
    }

    @Test
    public void signUpDoctor() {
        String id = "qinghan@gmail.com", name = "qinghan", pin = "qh123";
        appointService.signUpDoctor(id, name, pin);
    }

    @Test
    public void validateUser() {
        String id = "12345@gmail.com", pin = "54321";
        User user = appointService.validateUser(id, pin);
        logger.info("user={}", user);
    }

    @Test
    public void validateDoctor() {
        String id = "qinghan@gmail.com", pin = "qh123";
        Doctor doctor = appointService.validateDoctor(id, pin);
        logger.info("doctor={}", doctor);
    }

    @Test
    public void getAppointmentList() {
        List<AppointmentList> appointmentLists = appointService.getAppointmentList();
        logger.info("list={}", appointmentLists);
    }

    @Test
    public void insertAppoint() throws ParseException {
        SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = simFormat.parse("2019-11-22 15:20:00");
        Date endTime = simFormat.parse("2019-11-22 16:20:00");
        String doctorId = "10002";
        String doctorName = "Jack";
        appointService.insertAppoint(doctorId, doctorName, startTime, endTime);
    }

    @Test
    public void deleteAppoint() {
        long id = 1000;
        appointService.deleteAppoint(id);
    }

    @Test
    public void queryHistory() {
        String id = "10000001";
        List<AppointmentList> appointmentLists = appointService.queryHistory(id);
        logger.info("history={}", appointmentLists);
    }

    @Test
    public void executeAppoint() {
        String userId = "12345@gmail.com";
        long appointId = 1008;
        try{
            AppointExecution appointExecution = appointService.executeAppoint(userId, appointId);
            logger.info("result={}", appointExecution);
        }
        catch (IsAppointedException e){
            logger.error(e.getMessage(), e);
        }
    }
}