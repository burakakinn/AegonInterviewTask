package com.aegon.interviewproject.api.answer.repository.custom;

import com.aegon.interviewproject.api.answer.controller.dto.AnswerResultDTO;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface AnswerRepositoryCustom {

    List<AnswerResultDTO> findByTopicId(UUID topicId);
}
