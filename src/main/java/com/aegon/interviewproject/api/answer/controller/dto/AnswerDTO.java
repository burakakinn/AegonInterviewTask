package com.aegon.interviewproject.api.answer.controller.dto;

import com.aegon.interviewproject.api.survey.repository.domain.Survey;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class AnswerDTO {

    @NotNull
    @NotBlank
    private UUID topicId;
    @NotNull
    @NotBlank
    private int score;
    @NotNull
    @NotBlank
    private String feedback;

    public UUID getTopicId() {
        return topicId;
    }

    public void setTopicId(UUID topicId) {
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
