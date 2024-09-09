package org.sig.sentiment_management.controller.advice;

import jakarta.persistence.EntityNotFoundException;
import org.sig.sentiment_management.dtos.ErrorEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
@ControllerAdvice
public class AppControllerAdvice {


    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({EntityNotFoundException.class})
    public @ResponseBody ErrorEntity handleException(EntityNotFoundException exception) {
        return new ErrorEntity(null, exception.getMessage());
    }
    @ResponseStatus(CONFLICT)
    @ExceptionHandler({RuntimeException.class})
    public @ResponseBody ErrorEntity handleRuntimeException(RuntimeException exception) {
        return new ErrorEntity(null, exception.getMessage());
    }
}
