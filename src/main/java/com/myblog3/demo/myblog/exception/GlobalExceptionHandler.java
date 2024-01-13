package com.myblog3.demo.myblog.exception;

import com.myblog3.demo.myblog.util.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
            ResourceNotFoundException e, WebRequest webRequest
    ){
        ErrorDetails error = new ErrorDetails(HttpStatus.NOT_FOUND,new Date(),e.getMessage(),webRequest.getDescription(true));
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
