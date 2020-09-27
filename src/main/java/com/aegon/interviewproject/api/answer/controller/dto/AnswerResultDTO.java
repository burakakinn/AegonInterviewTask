package com.aegon.interviewproject.api.answer.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class AnswerResultDTO {

    @NotNull
    @NotBlank
    private UUID submitID;
    @NotNull
    @NotBlank
    private int score;
    @NotNull
    @NotBlank
    private String feedback;

    public UUID getSubmitID() {
        return submitID;
    }

    public void setSubmitID(UUID submitID) {
        this.submitID = submitID;
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
