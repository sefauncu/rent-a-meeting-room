package com.example.meeting.exception;

public class MeetingBusinessException extends RuntimeException {

    public MeetingBusinessException() {
    }

    public MeetingBusinessException(String message) {
        super(message);
    }

    public MeetingBusinessException(Throwable cause) {
        super(cause);
    }

    public MeetingBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public MeetingBusinessException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
