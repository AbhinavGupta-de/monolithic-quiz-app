package org.abhinavgpt.quizapp.servies.quizservice;

import org.abhinavgpt.quizapp.dtos.AddQuizDTO;
import org.abhinavgpt.quizapp.model.Question;
import org.abhinavgpt.quizapp.model.Quiz;
import org.abhinavgpt.quizapp.model.Response;

import java.util.List;

public interface IQuizService {

    Quiz getQuizById(Long id);

    Quiz addQuiz(AddQuizDTO addQuizDTO);

    List<Question> getQuestionsByQuizId(Long id);

    Integer getScore(Long quizId, List<Response> responses);

}
