/*
package com.encora.alumno.controller;

import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(Throwable.class)
    public Mono<Map<String, Object>> handleException(Throwable e) {
        String errorMessage = e.getMessage();
        Map<String, Object> response = Map.of("message", errorMessage);
        if (e instanceof WebExchangeBindException)
             errorMessage =  ((WebExchangeBindException) e).getAllErrors().get(0).getDefaultMessage();
        if (e instanceof MethodArgumentNotValidException)
            errorMessage = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().get(0).getDefaultMessage();
        if (e instanceof TransientDataAccessResourceException)
            errorMessage = ((TransientDataAccessResourceException) e).getMessage();
        return Mono.just(Map.of("message", errorMessage));
    }


}

 */



