
-- 功能待开发

CREATE DATABASE Appointment;
USE Appointment;

CREATE TABLE `appointmentList`(
    `appoint_id` bigint not null auto_increment comment '预约列表id',
    `doctor_id` varchar(20) not null comment '医生ID',
    `doctor_name` varchar(30) NOT NULL COMMENT '医生姓名',
    `start_time` timestamp NOT NULL COMMENT '预约开始时间',
    `end_time` timestamp NOT NULL COMMENT '预约结束时间',
    `state` tinyint NOT NULL default 0 COMMENT '预约状态: 0 - 可预约, 1 - 已预约',
    PRIMARY KEY (`appoint_id`),

-- 按条件搜索功能（选做）
    key idx_appoint_id(`appoint_id`),
    key idx_doctor_name(`doctor_name`),
    key idx_start_time(`start_time`),
    key idx_end_time(`end_time`),
    key idx_state(`state`)
) ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='预约清单';

create table `successAppoint`(
    `appoint_id` bigint(20) not null comment '预约列表id',
    `user_id` varchar(20) not null comment '用户id',
    `doctor_id` varchar(20) NOT NULL comment '医生id',
    `doctor_name` varchar(30) NOT NULL COMMENT '医生姓名',
    `start_time` timestamp NOT NULL COMMENT '预约开始时间',
    primary key (`appoint_id`, `user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成功预约明细表';

CREATE TABLE `user`(
    `user_id` varchar(20) NOT NULL COMMENT '学生ID',
    `password`  varchar(30) NOT NULL COMMENT '密码',
    PRIMARY KEY(`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户数据';

create table `doctor`(
    `doctor_id` varchar(20) not null comment '医生id',
    `doctor_name` varchar(30) NOT NULL COMMENT '医生姓名',
    `password` varchar(30) not null comment '密码',
    primary key (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医生数据';

-- 初始化，测试用

insert into `user`(`user_id`, `password`)
VALUES
       (12345678,12345678),
       (10000001,12312312),
       (10000002,12345678);

insert into `doctor`(`doctor_id`, `doctor_name`, `password`)
values
       (10001, 'Jason', 'jason'),
       (10002, 'Jack', 'jack');

insert into `appointmentList`(`doctor_id`, `doctor_name`, `start_time`, `end_time`, state)
values
       (10001, 'Jason', '2019-11-13 09:00:00', '2019-11-13 10:00:00', 0),
       (10001, 'Jason', '2019-11-13 10:10:00', '2019-11-13 11:10:00', 0),
       (10001, 'Jason', '2019-11-13 14:00:00', '2019-11-13 15:00:00', 0),
       (10002, 'Jack', '2019-11-13 09:00:00', '2019-11-13 10:00:00', 0),
       (10002, 'Jack', '2019-11-13 15:00:00', '2019-11-13 16:00:00', 0);
