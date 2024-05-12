package org.abhinavgpt.quizapp.controllers;

import org.abhinavgpt.quizapp.dtos.AddQuestionDTO;
import org.abhinavgpt.quizapp.model.Question;
import org.abhinavgpt.quizapp.servies.questionservice.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    IQuestionService questionService;

    @Autowired
    public QuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("")
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    @PostMapping("")
    public Question addQuestion(@RequestBody AddQuestionDTO addQuestionDTO) {
        return questionService.addQuestion(addQuestionDTO);
    }

    @PutMapping("")
    public Question updateQuestion(@RequestBody Question question) {
        return questionService.updateQuestion(question);

    }

    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return "Question deleted successfully";
    }

}
