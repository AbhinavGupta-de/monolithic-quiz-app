package org.abhinavgpt.quizapp.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @GetMapping("")
    public String getQuestions() {
        return "Questions";
    }

    @GetMapping("/{id}")
    public String getQuestionById() {
        return "Question by id";
    }

    @PostMapping("")
    public String addQuestion() {
        return "Add question";
    }

    @PostMapping("/{id}")
    public String updateQuestion() {
        return "Update question";
    }

    @DeleteMapping("/{id}")
    public String deleteQuestion() {
        return "Delete question";
    }

}
