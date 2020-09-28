package com.aegon.interviewproject.api.survey.controller;

import com.aegon.interviewproject.api.survey.controller.dto.SurveyDTO;
import com.aegon.interviewproject.api.survey.controller.mapper.SurveyMapper;
import com.aegon.interviewproject.api.survey.repository.domain.Survey;
import com.aegon.interviewproject.api.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private SurveyMapper surveyMapper;

//    @Autowired
//    private NetPromoterScoreService netPromoterScoreService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Survey add(@RequestBody SurveyDTO surveyDTO){
        Survey survey = surveyMapper.toEntity(surveyDTO);
        survey.setDetractors(0);
        survey.setPromoters(0);
        survey.setPassives(0);
        return surveyService.save(survey);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SurveyDTO get(@PathVariable int id){
        return surveyMapper.toDTO(surveyService.findById(id));
    }

//    @GetMapping("/getScore")
//    @ResponseStatus(HttpStatus.OK)
//    public SurveyScore getScore(){
//
//    }
}
