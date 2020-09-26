package com.aegon.interviewproject.api.survey.controller.mapper;

import com.aegon.interviewproject.api.survey.controller.dto.SurveyDTO;
import com.aegon.interviewproject.api.survey.repository.domain.Survey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class SurveyMapper {

    public abstract Survey toEntity(SurveyDTO surveyDTO);

    public abstract SurveyDTO toDTO(Survey survey);

}
