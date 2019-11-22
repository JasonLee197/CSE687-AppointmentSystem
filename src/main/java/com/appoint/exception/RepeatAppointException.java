package com.appoint.exception;

//TODO 也许可删除
public class RepeatAppointException extends AppointException {

    public RepeatAppointException(String message) {
        super(message);
    }

    public RepeatAppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
