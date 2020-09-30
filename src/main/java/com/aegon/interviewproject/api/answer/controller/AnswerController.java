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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    private ResponseEntity<Integer> add(@RequestBody AnswerDTO answerDTO){
        Answer answer = answerService.save(answerMapper.toEntity(answerDTO));
        // ========================= NPM LOGIC ===========================
        Survey survey = surveyService.findById(answer.getSurvey().getId());
        if(answer.getScore() <= 6){
            survey.setDetractors(survey.getDetractors()+1);
        } else if(answer.getScore() >= 9){
            survey.setPromoters(survey.getPromoters()+1);
        } else {
            survey.setPassives(survey.getPassives()+1);
        }
        double promoters = (double) survey.getPromoters();
        double detractors = (double) survey.getDetractors();
        double passives = (double) survey.getPassives();
        survey.setScore(((promoters-detractors)/(promoters+detractors+passives))*100);
        surveyService.update(survey);
        // ======================= NPM LOGIC END ==========================
        return ResponseEntity.status(HttpStatus.OK).body(answer.getId());
    }

    // using querydsl
    @GetMapping("/list/{topicId}")
    private ResponseEntity<List<AnswerResultDTO>> list(@PathVariable int topicId){
        Survey survey = surveyService.findById(topicId);
        List<Answer> answerList = answerService.findByTopicId(survey.getId());
        List<AnswerResultDTO> answerResultDTOList = new ArrayList<>();
        for(Answer answer : answerList){
            answerResultDTOList.add(answerResultMapper.toDTO(answer));
        }
        return ResponseEntity.status(HttpStatus.OK).body(answerResultDTOList);
    }

    // using spring boot naming method
    @GetMapping("/list2/{topicId}")
    private ResponseEntity<List<AnswerResultDTO>> list2(@PathVariable int topicId){
        Survey survey = surveyService.findById(topicId);
        List<Answer> answerList = answerService.findBySurvey(survey);
        List<AnswerResultDTO> answerResultDTOList = new ArrayList<>();
        for(Answer answer : answerList){
            answerResultDTOList.add(answerResultMapper.toDTO(answer));
        }
        return ResponseEntity.status(HttpStatus.OK).body(answerResultDTOList);
    }


    @GetMapping("/listAll")
    private ResponseEntity<List<AnswerResultDTO>> listAll(){
        List<Answer> answerList = answerService.findAll();
        List<AnswerResultDTO> answerResultDTOList = new ArrayList<>();
        for(Answer answer : answerList){
            answerResultDTOList.add(answerResultMapper.toDTO(answer));
        }
        return ResponseEntity.status(HttpStatus.OK).body(answerResultDTOList);
    }
}
