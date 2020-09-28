package com.aegon.interviewproject.api.answer.repository;

import com.aegon.interviewproject.api.answer.repository.custom.AnswerRepositoryCustom;
import com.aegon.interviewproject.api.answer.repository.domain.Answer;
import com.aegon.interviewproject.api.survey.repository.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>, QuerydslPredicateExecutor<Answer>, AnswerRepositoryCustom {

    List<Answer> findBySurvey(Survey survey);
}
