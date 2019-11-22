package com.appoint.enums;

public enum  AppointStateEnums {

    SUCCESS(1, "Successful!"),
    IS_APPOINTED(0, "It has been appointed!"),
    REPEAT_APPOINT(-1, "You have appointed!");

    private int state;
    private String stateInfo;

    AppointStateEnums(int i, String s) {
        this.state = i;
        this.stateInfo = s;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static AppointStateEnums stateOf(int index){
        for(AppointStateEnums state : values()) {
            if (state.getState() == index)
                return state;
        }
        return null;
    }
}
