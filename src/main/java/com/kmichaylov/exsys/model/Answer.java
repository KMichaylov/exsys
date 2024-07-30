package com.kmichaylov.exsys.model;

import jakarta.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private int answerId;

    @Column(name = "sample_answer")
    private String sampleAnswer;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer() {
    }

    public Answer(String sampleAnswer, boolean isCorrect, Answer answer, Question question) {
        this.sampleAnswer = sampleAnswer;
        this.isCorrect = isCorrect;
        this.answer = answer;
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

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
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
                ", answer=" + answer +
                ", question=" + question +
                '}';
    }
}
