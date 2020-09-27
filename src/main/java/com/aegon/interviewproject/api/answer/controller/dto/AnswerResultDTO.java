package com.aegon.interviewproject.api.answer.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class AnswerResultDTO {

    @NotNull
    @NotBlank
    private UUID submitId;
    @NotNull
    @NotBlank
    private int score;
    @NotNull
    @NotBlank
    private String feedback;

    public UUID getSubmitId() {
        return submitId;
    }

    public void setSubmitId(UUID submitId) {
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
