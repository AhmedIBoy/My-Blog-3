package com.myblog3.demo.myblog.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private HttpStatus statusCode;
    private Date date;
    private String message;
    private String uri;
}
