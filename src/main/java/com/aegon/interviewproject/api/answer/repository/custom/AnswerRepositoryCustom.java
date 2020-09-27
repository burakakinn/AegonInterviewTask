package com.aegon.interviewproject.api.answer.repository.custom;

import com.aegon.interviewproject.api.answer.controller.dto.AnswerResultDTO;
import com.aegon.interviewproject.api.answer.repository.domain.Answer;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface AnswerRepositoryCustom {

    List<Answer> findByTopicId(UUID topicId);
}
