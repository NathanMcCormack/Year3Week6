package ie.atu.week6;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> display(MethodArgumentNotValidException ex){
        Map<String, String> errorList = new HashMap<>();

        for(FieldError error : ex.getBindingResult().getFieldErrors()) { //searches through all errors
            String errorName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errorList.put(errorName, errorMessage);
        }
        return ResponseEntity.status(400).body(errorList); //Returns ERROR 400 message
    }
}