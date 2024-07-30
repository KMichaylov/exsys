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
}
