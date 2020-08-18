package com.example.demo.controller;


import com.example.demo.model.QuestionModel;
import com.example.demo.model.SurveyModel;
import com.example.demo.services.SurveyService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping("/surveys/{surveyId}/questions")
    public List <QuestionModel> retreiveAllQuestionsOfSurvey(@PathVariable String surveyId) {
      return  surveyService.retrieveQuestions(surveyId);
    }
    @GetMapping("/surveys/{surveyId}/questions/{questionId}")
    public QuestionModel retreiveDetailsOfQuestionOfSurvey(@PathVariable String surveyId,@PathVariable String questionId) {
        return  surveyService.retrieveQuestion(surveyId,questionId);
    }
    @PostMapping("/surveys/{surveyId}/questions")
    public ResponseEntity<Void> addQuestionToSurvey(
            @PathVariable String surveyId, @RequestBody QuestionModel newQuestion) {

        QuestionModel question = surveyService.addQuestion(surveyId, newQuestion);

        if (question == null)
            return ResponseEntity.noContent().build();

        // Success - URI of the new resource in Response Header
        // Status - created
        // URI -> /surveys/{surveyId}/questions/{questionId}
        // question.getQuestionId()
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(question.getId()).toUri();

        // Status
        return ResponseEntity.created(location).build();
    }
}

