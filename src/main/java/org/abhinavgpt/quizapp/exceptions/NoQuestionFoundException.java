package org.abhinavgpt.quizapp.exceptions;

public class NoQuestionFoundException extends RuntimeException {
    public NoQuestionFoundException(String message) {
        super(message);
    }
}
