package com.aegon.interviewproject.api.answer.controller;

import com.aegon.interviewproject.api.answer.controller.dto.AnswerDTO;
import com.aegon.interviewproject.api.answer.controller.dto.AnswerResultDTO;
import com.aegon.interviewproject.api.answer.controller.mapper.AnswerMapper;
import com.aegon.interviewproject.api.answer.repository.domain.Answer;
import com.aegon.interviewproject.api.answer.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private AnswerMapper answerMapper;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    private Answer add(@RequestBody AnswerDTO answerDTO){
        return answerService.save(answerMapper.toEntity(answerDTO));
    }

    @GetMapping("/list/{topicId}")
    @ResponseStatus(HttpStatus.OK)
    private List<AnswerResultDTO> list(@PathVariable UUID topicId){
        return answerService.findByTopicId(topicId);
    }
}
