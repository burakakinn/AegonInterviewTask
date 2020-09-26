package com.aegon.interviewproject.api.survey.repository.domain;

import com.aegon.interviewproject.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "topic")
public class Survey extends BaseEntity {

    private String topic;
    private String question;

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
}
