package com.example.meeting.response;


import java.time.LocalDateTime;

public class MeetingExceptionResponse {
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public MeetingExceptionResponse(LocalDateTime timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}