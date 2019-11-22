package com.appoint.dao;

import com.appoint.entity.AppointmentList;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AppointmentListDao {

    //显示所有列表
    List<AppointmentList> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    //多种查询
    AppointmentList queryById(long appointId);
    List<AppointmentList> queryByName(String doctorName);
    List<AppointmentList> queryByStartTime(Date startTime);
    List<AppointmentList> queryByEndTime(Date endTime);
    List<AppointmentList> queryByState(short state);

    //用户预约，更新预约状态
    int updateState(long appointId);

    //医生增加可预约项目
    int insertAppointmentList(@Param("doctorId") String doctorId,
                              @Param("doctorName") String doctorName,
                              @Param("startTime") Date startTime,
                              @Param("endTime") Date endTime);

    //医生删除可预约项目
    int deleteAppointmentList(long appointId);
}
