package com.appoint.entity;

import java.util.Date;

public class AppointmentList {

    private long appointId;
    private String doctorId;
    private String doctorName;
    private Date startTime;
    private Date endTime;
    private short state;

    //public AppointmentList(){};

    public AppointmentList(long appointId, String doctorId, String doctorName, Date startTime, Date endTime, short state) {
        this.appointId = appointId;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.state = state;
    }

    //query history constructor
    public AppointmentList(long appointId, String doctorId, String doctorName, Date startTime) {
        this.appointId = appointId;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.startTime = startTime;
        this.endTime = new Date(startTime.getTime() + 1000 * 60 * 60L);
        this.state = 1;
    }

    public long getAppointId() {
        return appointId;
    }

    public void setAppointId(long appointId) {
        this.appointId = appointId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "AppointmentList{" +
                "appointId=" + appointId +
                ", doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", state=" + state +
                '}';
    }
}
