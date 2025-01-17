package org.abhinavgpt.quizapp.exceptionhandlers;

import org.abhinavgpt.quizapp.exceptions.NoQuestionFoundException;
import org.abhinavgpt.quizapp.exceptions.NoQuizFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoQuestionFoundException.class)
    public ResponseEntity<String> handleNoQuestionFoundException(NoQuestionFoundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(NoQuizFoundException.class)
    public ResponseEntity<String> handleNoQuizFoundException(NoQuizFoundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
