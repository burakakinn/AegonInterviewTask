package com.aegon.interviewproject.api.survey.controller.dto;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotBlank;

// DTO for creating survey in user side
public class SurveyDTO {

    @NotNull
    @NotBlank
    private String topic;
    @NotNull
    @NotBlank
    private String question;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
