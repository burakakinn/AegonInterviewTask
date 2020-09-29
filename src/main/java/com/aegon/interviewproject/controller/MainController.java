package com.aegon.interviewproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {

    @GetMapping("/index")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/createSurvey")
    public String surveyCreatePage(){
        return "createSurvey";
    }

    @GetMapping("/surveyAnswers")
    public String surveyAnswersPage(){
        return "surveyAnswers";
    }

    @GetMapping("/surveyTopics")
    public String surveyTopicsPage(){
        return "surveyTopics";
    }

    @GetMapping("/submitSurvey")
    public String submitSurveyPage(){
        return "submitSurvey";
    }

}

