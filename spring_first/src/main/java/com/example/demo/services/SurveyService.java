package com.example.demo.services;

import com.example.demo.model.QuestionModel;
import com.example.demo.model.SurveyModel;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SurveyService {
    private static List<SurveyModel> surveys = new ArrayList<>();
    static {
        QuestionModel question1 = new QuestionModel("Question1",
                "Largest Country in the World", "Russia", Arrays.asList(
                "India", "Russia", "United States", "China"));
        QuestionModel question2 = new QuestionModel("Question2",
                "Most Populus Country in the World", "China", Arrays.asList(
                "India", "Russia", "United States", "China"));
        QuestionModel question3 = new QuestionModel("Question3",
                "Highest GDP in the World", "United States", Arrays.asList(
                "India", "Russia", "United States", "China"));
        QuestionModel question4 = new QuestionModel("Question4",
                "Second largest english speaking country", "India", Arrays
                .asList("India", "Russia", "United States", "China"));

        List<QuestionModel> questions = new ArrayList<>(Arrays.asList(question1,
                question2, question3, question4));

        SurveyModel survey = new SurveyModel("Survey1", "My Favorite Survey",
                "Description of the Survey", questions);

        surveys.add(survey);
    }

    public List<SurveyModel> retrieveAllSurveys() {
        return surveys;
    }

    public SurveyModel retrieveSurvey(String surveyId) {
        for (SurveyModel survey : surveys) {
            if (survey.getId().equals(surveyId)) {
                return survey;
            }
        }
        return null;
    }

    public List<QuestionModel> retrieveQuestions(String surveyId) {
        SurveyModel survey = retrieveSurvey(surveyId);

        if (survey == null) {
            return null;
        }

        return survey.getQuestions();
    }

    public QuestionModel retrieveQuestion(String surveyId, String questionId) {
        SurveyModel survey = retrieveSurvey(surveyId);

        if (survey == null) {
            return null;
        }

        for (QuestionModel question : survey.getQuestions()) {
            if (question.getId().equals(questionId)) {
                return question;
            }
        }

        return null;
    }

    private SecureRandom random = new SecureRandom();

    public QuestionModel addQuestion(String surveyId, QuestionModel question) {
        SurveyModel survey = retrieveSurvey(surveyId);

        if (survey == null) {
            return null;
        }

        String randomId = new BigInteger(130, random).toString(32);
        question.setId(randomId);

        survey.getQuestions().add(question);

        return question;
    }
}
