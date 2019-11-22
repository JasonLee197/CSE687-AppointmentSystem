package com.appoint.exception;

public class IsAppointedException extends AppointException {

    public IsAppointedException(String message) {
        super(message);
    }

    public IsAppointedException(String message, Throwable cause) {
        super(message, cause);
    }
}
