package com.kmichaylov.exsys.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kmichaylov.exsys.enumeration.QuestionType;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "question")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "questionId")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int questionId;

    @Column(name = "question_body")
    private String questionBody;

    @Column(name = "question_type")
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "parent_question_id")
    private Question parentQuestion;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    @OneToOne(mappedBy = "question")
    @JoinColumn(name = "question_id")
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
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
                ", parentQuestionId=" + (parentQuestion != null ? parentQuestion.getQuestionId() : "null") +
                '}';
    }
}
