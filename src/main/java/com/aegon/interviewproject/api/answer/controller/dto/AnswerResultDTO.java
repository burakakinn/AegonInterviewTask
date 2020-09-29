package com.aegon.interviewproject.api.answer.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

// DTO for listing survey answers
public class AnswerResultDTO {

    @NotNull
    @NotBlank
    private int submitId; // could be UUID
    @NotNull
    @NotBlank
    @PositiveOrZero
    private int score;
    @NotNull
    @NotBlank
    private String feedback;

    public int getSubmitId() {
        return submitId;
    }

    public void setSubmitId(int submitId) {
        this.submitId = submitId;
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
