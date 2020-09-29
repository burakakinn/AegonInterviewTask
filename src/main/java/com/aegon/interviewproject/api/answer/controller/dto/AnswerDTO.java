package com.aegon.interviewproject.api.answer.controller.dto;

import com.aegon.interviewproject.api.survey.repository.domain.Survey;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

// DTO for getting answer from user
public class AnswerDTO {

    @NotNull
    @NotBlank
    private int topicId; // could be UUID
    @NotNull
    @NotBlank
    @PositiveOrZero
    private int score;
    @NotNull
    @NotBlank
    private String feedback;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
