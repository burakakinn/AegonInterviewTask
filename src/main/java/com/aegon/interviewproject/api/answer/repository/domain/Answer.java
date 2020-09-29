package com.aegon.interviewproject.api.answer.repository.domain;

import com.aegon.interviewproject.api.survey.repository.domain.Survey;
import com.aegon.interviewproject.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "answer")
public class Answer extends BaseEntity {

    private Survey survey;
    private int score;
    private String feedback;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id",nullable = false) 
    @JsonIgnore // for rest api to work with querydsl
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Column(nullable = false)
    @PositiveOrZero
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Column(nullable = false)
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
