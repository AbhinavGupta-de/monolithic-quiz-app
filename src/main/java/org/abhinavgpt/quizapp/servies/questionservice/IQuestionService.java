package org.abhinavgpt.quizapp.servies.questionservice;

import org.abhinavgpt.quizapp.dtos.AddQuestionDTO;
import org.abhinavgpt.quizapp.model.Question;

import java.util.List;

public interface IQuestionService {

    List<Question> getQuestions();

    Question getQuestionById(Long id);

    Question addQuestion(AddQuestionDTO addQuestionDTO);

    Question updateQuestion(Question question);

    void deleteQuestion(Long id);

    List<Question> getQuestionsByCategory(String category);

    List<Question> getQuestionsByDifficulty(String difficulty);

    List<Question> getRandomQuestionsByCategoryAndDifficulty(String category, String difficulty, int limit);

}
