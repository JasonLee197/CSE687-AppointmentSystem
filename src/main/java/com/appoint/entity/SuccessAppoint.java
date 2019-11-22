package com.appoint.entity;

import java.util.Date;

public class SuccessAppoint {

    private long appointId;
    private String userId;
    private String doctorId;
    private String doctorName;
    private Date startTime;
    //private AppointmentList appointmentList;

    public SuccessAppoint(){};

    public SuccessAppoint(long appointId, String userId, String doctorId, String doctorName, Date startTime) {
        this.appointId = appointId;
        this.userId = userId;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.startTime = startTime;
        //this.appointmentList = appointmentList;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

  /*  public AppointmentList getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(AppointmentList appointmentList) {
        this.appointmentList = appointmentList;
    } */

    @Override
    public String toString() {
        return "SuccessAppoint{" +
                "appointId=" + appointId +
                ", userId='" + userId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
