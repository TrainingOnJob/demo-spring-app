package web.project.demo.controller;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import web.project.demo.exceptions.ApiError;
import web.project.demo.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(0)
public class ExceptionHandlers {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    private ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        return new ResponseEntity<>(
                new ApiError(methodArgumentNotValidException.getMessage(), "409"),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler({UserNotFoundException.class})
    private ResponseEntity<ApiError> handleMethodArgumentNotValidException(UserNotFoundException notFoundException){
        return new ResponseEntity<>(
                new ApiError(notFoundException.getMessage(), "404"),
                HttpStatus.NOT_FOUND
        );
    }
}
