package com.aegon.interviewproject.api.survey.controller.mapper;

import com.aegon.interviewproject.api.survey.controller.dto.SurveyDTO;
import com.aegon.interviewproject.api.survey.controller.dto.SurveyResultDTO;
import com.aegon.interviewproject.api.survey.repository.domain.Survey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class SurveyResultMapper {

    @Mapping(target = "topicId", source = "id")
    @Mapping(target = "topicName", source = "topic")
    @Mapping(target = "npmScore", source = "score",qualifiedByName = "doubleToInteger")
    public abstract SurveyResultDTO toDTO(Survey survey);

    @Named("doubleToInteger")
    Integer doubleToInteger(double score){ // method should be default, not public or private
        return (int)score;
    }
}
