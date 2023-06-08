package com.example.sendingnotification.controller;

import com.example.sendingnotification.dto.error.InvalidInputErrorResponseREST;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    //there many exception MethodArgumentNotValidException,BindException
    @ExceptionHandler(MethodArgumentNotValidException.class) // this class for exception handling
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)// this return status code
    @ResponseBody //this make a response body
    public InvalidInputErrorResponseREST handleRequestParameterException(MethodArgumentNotValidException e) {
        String message = "Invalid inputs";
        Integer statusCode = HttpStatus.BAD_REQUEST.value();

        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new InvalidInputErrorResponseREST(message, statusCode,errors);
    }


}
