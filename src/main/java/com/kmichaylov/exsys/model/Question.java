package com.kmichaylov.exsys.model;

import com.kmichaylov.exsys.enumeration.QuestionType;
import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int questionId;

    @Column(name = "question_body")
    private String questionBody;

    @Column(name = "questionType")
    private QuestionType questionType;

    @Column(name = "points")
    private double points;
}
