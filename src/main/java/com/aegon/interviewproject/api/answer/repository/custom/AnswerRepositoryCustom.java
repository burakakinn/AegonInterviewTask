package com.aegon.interviewproject.api.answer.repository.custom;

import com.aegon.interviewproject.api.answer.controller.dto.AnswerResultDTO;
import com.aegon.interviewproject.api.answer.repository.domain.Answer;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface AnswerRepositoryCustom {

    List<Answer> findByTopicId(int topicId);
}
