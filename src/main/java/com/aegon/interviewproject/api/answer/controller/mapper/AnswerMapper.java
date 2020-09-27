package com.aegon.interviewproject.api.answer.controller.mapper;

import com.aegon.interviewproject.api.answer.controller.dto.AnswerDTO;
import com.aegon.interviewproject.api.answer.repository.domain.Answer;
import com.aegon.interviewproject.api.survey.controller.dto.SurveyDTO;
import com.aegon.interviewproject.api.survey.repository.domain.Survey;
import com.aegon.interviewproject.api.survey.service.SurveyService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class AnswerMapper {

    @Autowired
    private SurveyService surveyService;

    @Mapping(target = "survey", source = "topicId", qualifiedByName = "idToSurvey")
    public abstract Answer toEntity(AnswerDTO answerDTO);

    @Mapping(target = "topicId", source = "survey", qualifiedByName = "surveyToId")
    public abstract AnswerDTO toDTO(Answer answer);

    @Named("idToSurvey")
    Survey idToSurvey(UUID id){ // method should be default, not public or private
        return surveyService.findById(id);
    }

    @Named("surveyToId")
    UUID surveyToId(Survey survey){
        return survey.getId();
    }
}
