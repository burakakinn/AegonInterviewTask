package com.aegon.interviewproject.api.answer.repository;

import com.aegon.interviewproject.api.answer.controller.dto.AnswerResultDTO;
import com.aegon.interviewproject.api.answer.controller.mapper.AnswerResultMapper;
import com.aegon.interviewproject.api.answer.repository.custom.AnswerRepositoryCustom;
import com.aegon.interviewproject.api.answer.repository.domain.Answer;
import com.aegon.interviewproject.api.answer.repository.domain.QAnswer;
import com.aegon.interviewproject.api.survey.repository.domain.QSurvey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class AnswerRepositoryImpl extends QuerydslRepositorySupport implements AnswerRepositoryCustom {

    @Autowired
    private AnswerResultMapper answerResultMapper;

    public AnswerRepositoryImpl() {
        super(Answer.class);
    }

    @Override
    public List<AnswerResultDTO> findByTopicId(UUID topicId) {
        List<Answer> answerList = (List<Answer>) from(QAnswer.answer).where(QSurvey.survey.id.eq(topicId)).fetchAll();
        List<AnswerResultDTO> result = new ArrayList<>();
        for(Answer answer : answerList){
            result.add(answerResultMapper.toDTO(answer));
        }
        return result;
    }
}
