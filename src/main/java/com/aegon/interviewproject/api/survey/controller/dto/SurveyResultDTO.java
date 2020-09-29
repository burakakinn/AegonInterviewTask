package com.aegon.interviewproject.api.survey.controller.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// DTO for listing survey topics with NPM score
public class SurveyResultDTO {
    private int topicId;
    private String topicName;
    private int npmScore;

    @NotNull
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @NotNull
    @NotBlank
    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @NotNull
    @Min(-100)
    @Max(100)
    public int getNpmScore() {
        return npmScore;
    }

    public void setNpmScore(int npmScore) {
        this.npmScore = npmScore;
    }
}
