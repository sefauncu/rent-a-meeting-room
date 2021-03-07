package com.example.meeting.exception;

public class MeetingRoomAlreadyHasCampaignException extends RuntimeException {

    public MeetingRoomAlreadyHasCampaignException() {
    }

    public MeetingRoomAlreadyHasCampaignException(String message) {
        super(message);
    }

    public MeetingRoomAlreadyHasCampaignException(Throwable cause) {
        super(cause);
    }

    public MeetingRoomAlreadyHasCampaignException(String message, Throwable cause) {
        super(message, cause);
    }

    public MeetingRoomAlreadyHasCampaignException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
