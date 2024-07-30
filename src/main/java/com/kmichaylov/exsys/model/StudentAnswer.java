package com.kmichaylov.exsys.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_answer")
public class StudentAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_answer_id")
    private int studentAnswerId;

    @Column(name = "student_answer")
    private String studentAnswer;

    @Column(name = "score")
    private double score;
}
