package com.aegon.interviewproject.api.survey.repository;

import com.aegon.interviewproject.api.survey.repository.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {

    Survey findByTopic(String name);
}
