package com.aegon.interviewproject.api.answer.controller;

import com.aegon.interviewproject.api.answer.controller.dto.AnswerDTO;
import com.aegon.interviewproject.api.answer.controller.mapper.AnswerMapper;
import com.aegon.interviewproject.api.answer.repository.domain.Answer;
import com.aegon.interviewproject.api.answer.service.AnswerService;
import com.aegon.interviewproject.api.survey.controller.mapper.SurveyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService service;

    @Autowired
    private AnswerMapper answerMapper;

    @PostMapping("/add")
    private Answer add(@RequestBody AnswerDTO answerDTO){
        return service.save(answerMapper.toEntity(answerDTO));
    }
}
