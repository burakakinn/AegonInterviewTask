package com.aegon.interviewproject.api.answer.service;

import com.aegon.interviewproject.api.answer.repository.AnswerRepository;
import com.aegon.interviewproject.api.answer.repository.domain.Answer;
import com.aegon.interviewproject.api.survey.repository.SurveyRepository;
import com.aegon.interviewproject.api.survey.repository.domain.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository repository;

    public Answer save(Answer answer) {
        return repository.save(answer);
    }
}
