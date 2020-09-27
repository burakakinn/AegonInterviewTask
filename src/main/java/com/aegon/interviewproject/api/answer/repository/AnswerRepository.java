package com.aegon.interviewproject.api.answer.repository;

import com.aegon.interviewproject.api.answer.repository.domain.Answer;
import com.aegon.interviewproject.api.survey.repository.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AnswerRepository extends JpaRepository<Answer, UUID> {

    List<Answer> findBySurvey(Survey survey);
}
