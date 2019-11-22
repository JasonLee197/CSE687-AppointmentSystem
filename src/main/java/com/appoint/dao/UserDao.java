package com.appoint.dao;

import com.appoint.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    //用户登录，验证id及密码
    User queryUser(@Param("userId") String userId, @Param("password") String password);

    //用户注册，写入数据库
    int signUpUser(@Param("userId") String userId, @Param("password") String password);

}
