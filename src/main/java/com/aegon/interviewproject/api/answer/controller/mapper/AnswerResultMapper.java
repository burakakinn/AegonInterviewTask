package com.aegon.interviewproject.api.answer.controller.mapper;

import com.aegon.interviewproject.api.answer.controller.dto.AnswerResultDTO;
import com.aegon.interviewproject.api.answer.repository.domain.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class AnswerResultMapper {

    @Mapping(target = "submitId", source = "id")
    public abstract AnswerResultDTO toDTO(Answer answer);

}
