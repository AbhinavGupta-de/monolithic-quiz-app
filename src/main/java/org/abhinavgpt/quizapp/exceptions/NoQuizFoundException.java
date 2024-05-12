package org.abhinavgpt.quizapp.exceptions;

public class NoQuizFoundException extends RuntimeException{
    public NoQuizFoundException(String message) {
        super(message);
    }
}
