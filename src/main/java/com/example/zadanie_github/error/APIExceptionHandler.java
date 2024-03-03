package com.example.zadanie_github.error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    protected APIErrorResponse handleUserNotFound(UserNotFoundException e) {
        return new APIErrorResponse(HttpStatus.NOT_FOUND,"User not found");
    }

    @ExceptionHandler(InvalidHeaderException.class)
    protected APIErrorResponse handleInvalidHeader(InvalidHeaderException e) {
        return new APIErrorResponse(HttpStatus.BAD_REQUEST,"Invalid header");
    }
}
