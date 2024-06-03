package com.webapp.projeto.infrastructure.exception;

import java.util.List;

import com.webapp.projeto.application.dto.response.ApiErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
        ApiErrorMessage apiErrorMessage =
                new ApiErrorMessage(HttpStatus.NOT_FOUND.value(), List.of(ex.getMessage()));
        return new ResponseEntity<>(apiErrorMessage, HttpStatus.valueOf(apiErrorMessage.getStatus()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        ApiErrorMessage apiErrorMessage =
                new ApiErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), List.of(ex.getMessage()));
        return new ResponseEntity<>(apiErrorMessage, HttpStatus.valueOf(apiErrorMessage.getStatus()));
    }
}
