package com.aegon.interviewproject.api.answer.controller;

import com.aegon.interviewproject.api.answer.controller.dto.AnswerDTO;
import com.aegon.interviewproject.api.answer.controller.dto.AnswerResultDTO;
import com.aegon.interviewproject.api.answer.controller.mapper.AnswerMapper;
import com.aegon.interviewproject.api.answer.controller.mapper.AnswerResultMapper;
import com.aegon.interviewproject.api.answer.repository.domain.Answer;
import com.aegon.interviewproject.api.answer.service.AnswerService;
import com.aegon.interviewproject.api.survey.repository.domain.Survey;
import com.aegon.interviewproject.api.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private AnswerResultMapper answerResultMapper;

    @Autowired
    private SurveyService surveyService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    private Answer add(@RequestBody AnswerDTO answerDTO){
        return answerService.save(answerMapper.toEntity(answerDTO));
    }

    // using querydsl
    @GetMapping("/list/{topicId}")
    @ResponseStatus(HttpStatus.OK)
    private List<Answer> list(@PathVariable int topicId){
        return answerService.findByTopicId(topicId);
    }

    @GetMapping("/list2/{topicId}")
    @ResponseStatus(HttpStatus.OK)
    private List<AnswerResultDTO> list2(@PathVariable int topicId){
        Survey survey = surveyService.findById(topicId);
        List<Answer> answerList = answerService.findBySurvey(survey);
        List<AnswerResultDTO> result = new ArrayList<>();
        for(Answer answer : answerList){
            result.add(answerResultMapper.toDTO(answer));
        }
        return result;
    }
}
