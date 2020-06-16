package com.example.meeting.handler;


import com.example.meeting.exception.MeetingBusinessException;
import com.example.meeting.response.MeetingExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class MeetingExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MeetingBusinessException.class)
    public final ResponseEntity<MeetingExceptionResponse> handleNotFoundException(MeetingBusinessException ex, WebRequest request) {
        MeetingExceptionResponse exceptionResponse = new MeetingExceptionResponse(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }
}
