package com.example.authorization.advice;

import com.example.authorization.exceptionHandler.InvalidCredentials;
import com.example.authorization.exceptionHandler.UnauthorizedUser;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unknownHandler(UnauthorizedUser e) {
        System.out.println(e);
        return new ResponseEntity<>("Unknown user", HttpStatusCode.valueOf(401));
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> emptyFields(InvalidCredentials e) {
        System.out.println(e);
        return new ResponseEntity<>("Empty fields", HttpStatusCode.valueOf(400));
    }
}
