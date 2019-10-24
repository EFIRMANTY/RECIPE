package moj_spring2.recipe_api.WEB;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice

public class ErrorHandler {
    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<Object>exeption (NoSuchElementException exeption) {
        return new ResponseEntity<>("bad key req", HttpStatus.BAD_REQUEST);
    }
/*    @ExceptionHandler (value = NoSuchElementException.class)
    public ResponseEntity<Object> exceptionNoData(NoSuchElementException exception) {
        return new ResponseEntity<>("No item find", HttpStatus.NOT_FOUND);
    }*/
}
