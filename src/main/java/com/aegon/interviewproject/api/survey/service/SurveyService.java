package com.aegon.interviewproject.api.survey.service;

import com.aegon.interviewproject.api.survey.repository.SurveyRepository;
import com.aegon.interviewproject.api.survey.repository.domain.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository repository;

    public Survey save(Survey survey) {
        return repository.save(survey);
    }

    public Survey findById(UUID id){
        return repository.findById(id).orElse(null);
    }
}
