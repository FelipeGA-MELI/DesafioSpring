package com.example.meli.desafioSpring.desafioSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DataBaseReadException.class)
    public void dbReadExceptionHandler(DataBaseReadException dataBaseReadException) {
        System.out.println(dataBaseReadException.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataBaseWriteException.class)
    public void dbWriteExceptionHandler(DataBaseWriteException dataBaseWriteException) {
        System.out.println(dataBaseWriteException.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public void userNotFoundHandler(UserNotFoundException userNotFoundException) {
        System.out.println(userNotFoundException.getMessage());
    }
}
