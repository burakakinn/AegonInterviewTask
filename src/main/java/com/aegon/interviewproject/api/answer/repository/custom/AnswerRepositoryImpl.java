package com.aegon.interviewproject.api.answer.repository.custom;

import com.aegon.interviewproject.api.answer.repository.custom.AnswerRepositoryCustom;
import com.aegon.interviewproject.api.answer.repository.domain.Answer;
import com.aegon.interviewproject.api.answer.repository.domain.QAnswer;
import com.aegon.interviewproject.api.survey.repository.domain.QSurvey;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerRepositoryImpl extends QuerydslRepositorySupport implements AnswerRepositoryCustom {

    public AnswerRepositoryImpl() {
        super(Answer.class);
    }

    @Override
    public List<Answer> findByTopicId(int topicId) {
        return from(QAnswer.answer).where(QSurvey.survey.id.eq(topicId)).fetch();
    }
}
