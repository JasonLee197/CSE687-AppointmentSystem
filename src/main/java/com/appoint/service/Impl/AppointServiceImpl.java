package com.appoint.service.Impl;

import com.appoint.dao.AppointmentListDao;
import com.appoint.dao.DoctorDao;
import com.appoint.dao.SuccessAppointDao;
import com.appoint.dao.UserDao;
import com.appoint.dto.AppointExecution;
import com.appoint.entity.AppointmentList;
import com.appoint.entity.Doctor;
import com.appoint.entity.SuccessAppoint;
import com.appoint.entity.User;
import com.appoint.enums.AppointStateEnums;
import com.appoint.exception.AppointException;
import com.appoint.exception.IsAppointedException;
import com.appoint.service.AppointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointServiceImpl implements AppointService {

    @Autowired
    private AppointmentListDao appointmentListDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private SuccessAppointDao successAppointDao;

    @Override
    public int signUpUser(String userId, String password) {
        return userDao.signUpUser(userId, password);
    }

    @Override
    public int signUpDoctor(String doctorId, String doctorName, String password) {
        return doctorDao.signUpDoctor(doctorId, doctorName, password);
    }

    @Override
    public User validateUser(String userId, String password) {
        return userDao.queryUser(userId, password);
    }

    @Override
    public Doctor validateDoctor(String doctorId, String password) {
        return doctorDao.queryDoctor(doctorId, password);
    }

    @Override
    public List<AppointmentList> getAppointmentList() {
        return appointmentListDao.queryAll(0, 100);
    }


    @Override
    public int insertAppoint(String doctorId, String doctorName, Date startTime, Date endTime) {
        return appointmentListDao.insertAppointmentList(doctorId, doctorName, startTime, endTime);
    }

    @Override
    public int deleteAppoint(long appointId) {
        return appointmentListDao.deleteAppointmentList(appointId);
    }

    @Override
    public List<AppointmentList> queryHistory(String userId) {
        return successAppointDao.queryHistory(userId);
    }

    @Override
    public AppointExecution executeAppoint(String userId, long appointId)
            throws AppointException, IsAppointedException{

        try {
            int updateAppoint = appointmentListDao.updateState(appointId);
            if(updateAppoint <= 0){
                throw new IsAppointedException(AppointStateEnums.IS_APPOINTED.getStateInfo());
            }
            else{
                AppointmentList appointmentList = appointmentListDao.queryById(appointId);
                successAppointDao.insertSuccessAppoint(appointId, userId,
                        appointmentList.getDoctorId(), appointmentList.getDoctorName(),
                        appointmentList.getStartTime());
                SuccessAppoint successAppoint = successAppointDao.querySuccessAppoint(appointId);
                return new AppointExecution(AppointStateEnums.SUCCESS, successAppoint);
            }
        }
        catch (IsAppointedException e1){
            throw e1;
        }
        catch (Exception e){
            throw new AppointException("Inner error" + e.getMessage());
        }
    }
}
