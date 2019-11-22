package com.appoint.entity;

import javax.print.Doc;

public class Doctor {

    private String doctorId;
    private String doctorName;
    private String password;

    public Doctor(){};

    public Doctor(String doctorId, String doctorName, String password) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
