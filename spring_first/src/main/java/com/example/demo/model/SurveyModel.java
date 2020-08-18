package com.example.demo.model;

import java.util.List;

public class SurveyModel {
    private String id;
    private String title;
    private String description;
    private List <QuestionModel> questions;

    public SurveyModel(){

    }
    public SurveyModel(String id, String title, String description, List<QuestionModel> questions) {
       super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.questions = questions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<QuestionModel> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionModel> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "SurveyModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", questions=" + questions +
                '}';
    }
}
