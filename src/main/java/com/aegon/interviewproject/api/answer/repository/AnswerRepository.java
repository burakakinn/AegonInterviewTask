package com.aegon.interviewproject.api.answer.repository;

import com.aegon.interviewproject.api.answer.repository.domain.Answer;
import com.aegon.interviewproject.api.survey.repository.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    List<Answer> findBySurvey(Survey survey);
}
