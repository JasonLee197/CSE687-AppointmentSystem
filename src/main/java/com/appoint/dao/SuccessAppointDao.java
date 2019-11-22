package com.appoint.dao;

import com.appoint.entity.AppointmentList;
import com.appoint.entity.SuccessAppoint;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SuccessAppointDao {

    //查询预约历史记录
    List<AppointmentList> queryHistory(String userId);

    //用户预约成功，插入成功数据
    int insertSuccessAppoint(@Param("appointId") long appointId,
                             @Param("userId") String userId,
                             @Param("doctorId") String doctorId,
                             @Param("doctorName") String doctorName,
                             @Param("startTime") Date startTime);

    SuccessAppoint querySuccessAppoint(long appointId);
}
