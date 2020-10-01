package com.aegon.interviewproject.api.answer.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

// DTO for listing survey answers
public class AnswerResultDTO {

    @NotNull
    private int submitId; // could be UUID
    @NotNull
    @PositiveOrZero
    private int score;
    @NotNull
    @NotBlank
    @NotEmpty
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
