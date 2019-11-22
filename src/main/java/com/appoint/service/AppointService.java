package com.appoint.service;

import com.appoint.dto.AppointExecution;
import com.appoint.entity.AppointmentList;
import com.appoint.entity.Doctor;
import com.appoint.entity.SuccessAppoint;
import com.appoint.entity.User;
import com.appoint.exception.AppointException;
import com.appoint.exception.IsAppointedException;
import com.appoint.exception.RepeatAppointException;

import java.util.Date;
import java.util.List;

public interface AppointService {

    int signUpUser(String userId, String password);

    int signUpDoctor(String doctorId, String doctorName, String password);

    User validateUser(String userId, String password);

    Doctor validateDoctor(String doctorId, String password);

    List<AppointmentList> getAppointmentList();

    int insertAppoint(String doctorId, String doctorName, Date startTime, Date endTime);

    int deleteAppoint(long appointId);

    List<AppointmentList> queryHistory(String userId);

    AppointExecution executeAppoint(String userId, long appointId)
            throws AppointException, IsAppointedException;

}
