package org.abhinavgpt.quizapp.dtos;

import java.util.List;

public record AddQuizDTO(String name, String description, List<Long> questionIds) {
}
