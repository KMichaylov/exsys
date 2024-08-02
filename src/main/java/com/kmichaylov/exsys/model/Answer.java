package com.kmichaylov.exsys.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "answer")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "answerId")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private int answerId;

    @Column(name = "sample_answer")
    private String sampleAnswer;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToOne(mappedBy = "answer")
    private StudentAnswer studentAnswer;

    public Answer() {
    }

    public Answer(String sampleAnswer, boolean isCorrect, Question question) {
        this.sampleAnswer = sampleAnswer;
        this.isCorrect = isCorrect;
        this.question = question;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getSampleAnswer() {
        return sampleAnswer;
    }

    public void setSampleAnswer(String sampleAnswer) {
        this.sampleAnswer = sampleAnswer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }


    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", sampleAnswer='" + sampleAnswer + '\'' +
                ", isCorrect=" + isCorrect +
                ", questionId=" + (question != null ? question.getQuestionId() : "null") +
                '}';
    }
}
