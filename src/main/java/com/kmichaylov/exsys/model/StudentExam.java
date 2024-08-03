package com.kmichaylov.exsys.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student_exam")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "studentExamId")
public class StudentExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_exam_id")
    private int studentExamId;

    @Column(name = "obtained_points")
    private double obtainedPoints;

    @Column(name = "exam_passed")
    private boolean examPassed;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;


    public StudentExam() {
    }

    public StudentExam(double obtainedPoints, boolean examPassed, Person person, Exam exam) {
        this.obtainedPoints = obtainedPoints;
        this.examPassed = examPassed;
        this.person = person;
        this.exam = exam;
    }

    public int getStudentExamId() {
        return studentExamId;
    }

    public void setStudentExamId(int studentExamId) {
        this.studentExamId = studentExamId;
    }

    public double getObtainedPoints() {
        return obtainedPoints;
    }

    public void setObtainedPoints(double obtainedPoints) {
        this.obtainedPoints = obtainedPoints;
    }

    public boolean isExamPassed() {
        return examPassed;
    }

    public void setExamPassed(boolean examPassed) {
        this.examPassed = examPassed;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @Override
    public String toString() {
        return "StudentExam{" +
                "studentExamId=" + studentExamId +
                ", obtainedPoints=" + obtainedPoints +
                ", examPassed=" + examPassed +
                ", person=" + person +
                ", exam=" + exam +
                '}';
    }
}
