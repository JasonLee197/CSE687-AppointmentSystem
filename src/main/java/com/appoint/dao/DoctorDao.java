package com.appoint.dao;

import com.appoint.entity.Doctor;
import org.apache.ibatis.annotations.Param;

public interface DoctorDao {

    //用户登录，验证id及密码
    Doctor queryDoctor(@Param("doctorId") String doctorId, @Param("password") String password);

    //医生注册，写入数据库
    int signUpDoctor(@Param("doctorId") String doctorId,
                     @Param("doctorName") String doctorName,
                     @Param("password") String password);
}
