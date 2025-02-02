package com.jbdl.LibraryManagement.aspects;

import com.jbdl.LibraryManagement.exception.BookException;
import com.jbdl.LibraryManagement.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice
public class ExceptionHandlingAop {

    //this is handling exception in my controller
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<String> invalidArgumentException(MethodArgumentNotValidException exception){
        return new ResponseEntity<>(exception.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UserException.class)
    public ResponseEntity<String> invalidUser(UserException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BookException.class)
    public ResponseEntity<String> invalidBook(BookException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //next exception handler to be called in all the cases
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> unkonwnException(BookException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
