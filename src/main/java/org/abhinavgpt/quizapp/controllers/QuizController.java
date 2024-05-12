package org.abhinavgpt.quizapp.controllers;

import org.abhinavgpt.quizapp.dtos.AddQuizDTO;
import org.abhinavgpt.quizapp.model.Question;
import org.abhinavgpt.quizapp.model.Quiz;
import org.abhinavgpt.quizapp.model.Response;
import org.abhinavgpt.quizapp.servies.quizservice.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    IQuizService quizService;

    @Autowired
    public QuizController(IQuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/id")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getQuizById(id));
    }

    @GetMapping("/score/{quizId}")
    public ResponseEntity<Integer> getScore(@PathVariable Long quizId, List<Response> responses) {
        return ResponseEntity.ok(quizService.getScore(quizId, responses));
    }

    @PostMapping("")
    public ResponseEntity<Quiz> addQuiz(@RequestBody AddQuizDTO addQuizDTO) {
        return ResponseEntity.ok(quizService.addQuiz(addQuizDTO));
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<List<Question>> getQuestionsByQuizId(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getQuestionsByQuizId(id));
    }

}