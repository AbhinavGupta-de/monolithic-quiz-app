package org.abhinavgpt.quizapp.servies.quizservice;

import org.abhinavgpt.quizapp.dtos.AddQuizDTO;
import org.abhinavgpt.quizapp.exceptions.NoQuizFoundException;
import org.abhinavgpt.quizapp.model.Question;
import org.abhinavgpt.quizapp.model.Quiz;
import org.abhinavgpt.quizapp.model.Response;
import org.abhinavgpt.quizapp.repository.QuizRepository;
import org.abhinavgpt.quizapp.servies.questionservice.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService implements IQuizService {

    QuizRepository quizRepository;
    IQuestionService questionService;

    @Autowired
    public QuizService(QuizRepository quizRepository, IQuestionService questionService) {
        this.quizRepository = quizRepository;
        this.questionService = questionService;
    }

    @Override
    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElseThrow(() -> new NoQuizFoundException("No quiz found with id: " + id));
    }

    @Override
    public Quiz addQuiz(AddQuizDTO addQuizDTO) {
        List<Question> questions = addQuizDTO.questionIds().stream().map(questionService::getQuestionById).toList();
        Quiz quiz = new Quiz(addQuizDTO.name(), addQuizDTO.description(), questions);
        return quizRepository.save(quiz);
    }

    @Override
    public List<Question> getQuestionsByQuizId(Long id) {
        return getQuizById(id).getQuestions();
    }

    @Override
    public Integer getScore(Long quizId, List<Response> responses) {
        Quiz quiz = getQuizById(quizId);
        int score = 0;
        for (Response response : responses) {
            Question question = questionService.getQuestionById(response.getId());
            if (question.getCorrectAnswer().equals(response.getResponse())) {
                score++;
            }
        }
        return score;
    }
}
