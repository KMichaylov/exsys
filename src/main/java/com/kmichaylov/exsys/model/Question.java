package com.kmichaylov.exsys.model;

import com.kmichaylov.exsys.enumeration.QuestionType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int questionId;

    @Column(name = "question_body")
    private String questionBody;

    @Column(name = "question_type")
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "parent_question_id")
    private Question parentQuestion;

    @OneToMany
    private List<Answer> answers;

    @OneToOne
    private StudentAnswer studentAnswers;

    @Column(name = "points")
    private double points;

    public Question() {
    }

    public Question(String questionBody, QuestionType questionType, double points) {
        this.questionBody = questionBody;
        this.questionType = questionType;
        this.points = points;
    }

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

    public Question getParentQuestion() {
        return parentQuestion;
    }

    public void setParentQuestion(Question parentQuestion) {
        this.parentQuestion = parentQuestion;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", questionBody='" + questionBody + '\'' +
                ", questionType=" + questionType +
                ", points=" + points +
                '}';
    }


}
