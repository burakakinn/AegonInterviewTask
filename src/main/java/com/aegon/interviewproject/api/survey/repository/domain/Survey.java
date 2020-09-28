package com.aegon.interviewproject.api.survey.repository.domain;

import com.aegon.interviewproject.common.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "survey")
public class Survey extends BaseEntity {

    private String topic;
    private String question;
    private int promoters;
    private int detractors;
    private int passives;
    private double score;

    @Column(nullable = false, unique = true)
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Column(nullable = false)
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Column(nullable = false)
    @PositiveOrZero
    public int getPromoters() {
        return promoters;
    }

    public void setPromoters(int promoters) {
        this.promoters = promoters;
    }

    @Column(nullable = false)
    @PositiveOrZero
    public int getDetractors() {
        return detractors;
    }

    public void setDetractors(int detractors) {
        this.detractors = detractors;
    }

    @Column
    @Min(-100)
    @Max(100)
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Column(nullable = false)
    @PositiveOrZero
    public int getPassives() {
        return passives;
    }

    public void setPassives(int passives) {
        this.passives = passives;
    }
}
