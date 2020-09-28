package com.aegon.interviewproject.api.survey.controller;

import com.aegon.interviewproject.api.survey.controller.dto.SurveyDTO;
import com.aegon.interviewproject.api.survey.controller.mapper.SurveyMapper;
import com.aegon.interviewproject.api.survey.repository.domain.Survey;
import com.aegon.interviewproject.api.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private SurveyMapper surveyMapper;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Survey add(@RequestBody SurveyDTO surveyDTO){
        return surveyService.save(surveyMapper.toEntity(surveyDTO));
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
