package com.aegon.interviewproject.api.survey.controller;

import com.aegon.interviewproject.api.answer.controller.dto.AnswerResultDTO;
import com.aegon.interviewproject.api.answer.repository.domain.Answer;
import com.aegon.interviewproject.api.survey.controller.dto.SurveyDTO;
import com.aegon.interviewproject.api.survey.controller.dto.SurveyResultDTO;
import com.aegon.interviewproject.api.survey.controller.mapper.SurveyMapper;
import com.aegon.interviewproject.api.survey.controller.mapper.SurveyResultMapper;
import com.aegon.interviewproject.api.survey.repository.domain.Survey;
import com.aegon.interviewproject.api.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private SurveyMapper surveyMapper;

    @Autowired
    private SurveyResultMapper surveyResultMapper;

    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody SurveyDTO surveyDTO){
        try {
            if (surveyService.findByTopic(surveyDTO.getTopic()) != null) {
                throw new Exception();
            }
            Survey survey = surveyMapper.toEntity(surveyDTO);
            survey.setDetractors(0);
            survey.setPromoters(0);
            survey.setPassives(0);
            return ResponseEntity.status(HttpStatus.OK).body(surveyService.save(survey).getId());
        } catch (Exception e) {
            System.err.println("Survey already exists!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(-1);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyDTO> get(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(surveyMapper.toDTO(surveyService.findById(id)));
    }

    @GetMapping("/allResults")
    public ResponseEntity<List<SurveyResultDTO>> getResults(){
        List<Survey> allSurveys = surveyService.getAll();
        List<SurveyResultDTO> allSurveyResultDTOs = new ArrayList<>();
        for(Survey survey : allSurveys){
            allSurveyResultDTOs.add(surveyResultMapper.toDTO(survey));
        }
        return ResponseEntity.status(HttpStatus.OK).body(allSurveyResultDTOs);
    }
}
