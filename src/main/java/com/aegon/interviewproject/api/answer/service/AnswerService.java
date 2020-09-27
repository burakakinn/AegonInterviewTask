package com.aegon.interviewproject.api.answer.service;

import com.aegon.interviewproject.api.answer.controller.dto.AnswerResultDTO;
import com.aegon.interviewproject.api.answer.repository.AnswerRepository;
import com.aegon.interviewproject.api.answer.repository.AnswerRepositoryImpl;
import com.aegon.interviewproject.api.answer.repository.domain.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private AnswerRepositoryImpl answerRepositoryImpl;


    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    public List<AnswerResultDTO> findByTopicId(UUID topicId){
        return answerRepositoryImpl.findByTopicId(topicId);
    }
}
