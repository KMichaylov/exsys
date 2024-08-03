package com.kmichaylov.exsys.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@Table(name = "student_answer")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "studentAnswerId")
public class StudentAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_answer_id")
    private int studentAnswerId;

    @Column(name = "student_answer")
    private String studentAnswer;

    @Column(name = "score")
    private double score;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    @JsonIgnore
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Person person;

    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;


    public StudentAnswer() {
    }

    public StudentAnswer(String studentAnswer, double score, Exam exam, Person person, Answer answer, Question question) {
        this.studentAnswer = studentAnswer;
        this.score = score;
        this.exam = exam;
        this.person = person;
        this.answer = answer;
        this.question = question;
    }


    public int getStudentAnswerId() {
        return studentAnswerId;
    }

    public void setStudentAnswerId(int studentAnswerId) {
        this.studentAnswerId = studentAnswerId;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
        return "StudentAnswer{" +
                "studentAnswerId=" + studentAnswerId +
                ", studentAnswer='" + studentAnswer + '\'' +
                ", score=" + score +
                ", questionId=" + (question != null ? question.getQuestionId() : "null") +
                ", answerId=" + (answer != null ? answer.getAnswerId() : "null") +
                '}';
    }
}
