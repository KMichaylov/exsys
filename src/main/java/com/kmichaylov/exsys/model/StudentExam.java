package com.kmichaylov.exsys.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_exam")
public class StudentExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_exam_id")
    private int studentExamId;

    @Column(name = "obtained_points")
    private double obtainedPoints;

    @Column(name = "exam_passed")
    private boolean examPassed;
}
