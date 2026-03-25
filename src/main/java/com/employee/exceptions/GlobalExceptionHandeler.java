package com.employee.exceptions;

import com.employee.model.dto.ErrorResponce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeler {

    @ExceptionHandler(ResourceNotFoundExceptions.class)
    public ResponseEntity<ErrorResponce>  handelResourceNotFoundException(ResourceNotFoundExceptions resourceNotFoundExceptions){

        ErrorResponce errorResponce = new ErrorResponce(resourceNotFoundExceptions.getMassage(), resourceNotFoundExceptions.getStatus());
        //return ResponseEntity.status(resourceNotFoundExceptions.getStatus()).body(errorResponce);
        return  new ResponseEntity<>(errorResponce,resourceNotFoundExceptions.getStatus());
    }

    @ExceptionHandler(BadRequestExceptions.class)
    public ResponseEntity<ErrorResponce>  handelBadRequestException(BadRequestExceptions badRequestExceptions){
        ErrorResponce errorResponce = new ErrorResponce(badRequestExceptions.getMassage(), badRequestExceptions.getStatus());
        return new ResponseEntity<>(errorResponce,badRequestExceptions.getStatus());
    }

    @ExceptionHandler(MissingParameterException.class)
    public ResponseEntity<ErrorResponce>  handelMissingParameterException(MissingParameterException missingParameterException){
        ErrorResponce errorResponce = new ErrorResponce(missingParameterException.getMassage(), missingParameterException.getStatus());
        return new ResponseEntity<>(errorResponce,missingParameterException.getStatus());
    }
}
