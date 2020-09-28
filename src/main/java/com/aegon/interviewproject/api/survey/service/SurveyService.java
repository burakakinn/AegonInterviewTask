package com.aegon.interviewproject.api.survey.service;

import com.aegon.interviewproject.api.survey.controller.dto.SurveyDTO;
import com.aegon.interviewproject.api.survey.controller.mapper.SurveyMapper;
import com.aegon.interviewproject.api.survey.repository.SurveyRepository;
import com.aegon.interviewproject.api.survey.repository.domain.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository repository;

    @Autowired
    private SurveyMapper surveyMapper;

    public Survey save(Survey survey) {
        return repository.save(survey);
    }

    public Survey findById(int id){
        return repository.findById(id).orElse(null);
    }

    public Survey update(Survey survey){
        Survey existingSurvey = repository.findById(survey.getId()).orElse(null);
        existingSurvey.setPromoters(survey.getPromoters());
        existingSurvey.setDetractors(survey.getDetractors());
        existingSurvey.setPassives(survey.getPassives());
        existingSurvey.setScore(survey.getScore());
        existingSurvey.setQuestion(survey.getQuestion());
        existingSurvey.setTopic(survey.getTopic());
        return repository.save(existingSurvey);
    }
}
