package com.kmichaylov.exsys.dto;

import com.kmichaylov.exsys.enumeration.QuestionType;
import com.kmichaylov.exsys.model.Question;

public class QuestionDTO {
    private int questionId;
    private String questionBody;
    private QuestionType questionType;
    private Question parentQuestionId;
    private double points;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionBody() {
        return questionBody;
    }

    public void setQuestionBody(String questionBody) {
        this.questionBody = questionBody;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Question getParentQuestionId() {
        return parentQuestionId;
    }

    public void setParentQuestionId(Question parentQuestionId) {
        this.parentQuestionId = parentQuestionId;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}
