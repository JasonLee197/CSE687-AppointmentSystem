package com.appoint.dto;

import com.appoint.entity.AppointmentList;
import com.appoint.entity.SuccessAppoint;
import com.appoint.enums.AppointStateEnums;

import java.util.Date;

public class AppointExecution {

    private int state;
    private String stateInfo;
    private SuccessAppoint successAppoint;

    public AppointExecution(){};

    public AppointExecution(AppointStateEnums appointStateEnums, SuccessAppoint successAppoint) {
        this.state = appointStateEnums.getState();
        this.stateInfo = appointStateEnums.getStateInfo();
        this.successAppoint = successAppoint;
    }

    public AppointExecution(AppointStateEnums appointStateEnums) {
        this.state = appointStateEnums.getState();
        this.stateInfo = appointStateEnums.getStateInfo();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessAppoint getSuccessAppoint() {
        return successAppoint;
    }

    public void setSuccessAppoint(SuccessAppoint successAppoint) {
        this.successAppoint = successAppoint;
    }

    @Override
    public String toString() {
        return "AppointExecution{" +
                "state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successAppoint=" + successAppoint +
                '}';
    }
}
