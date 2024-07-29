package com.kmichaylov.exsys.model;

import com.kmichaylov.exsys.enumeration.ExamType;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "course")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examId;

    @Column(name = "course_id")
    private int courseId;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "duration")
    private String duration;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ExamType type;
    @Column(name = "description")
    private String description;
    @Column(name = "points_to_pass")
    private double pointsToPass;
    @Column(name = "total_points")
    private double totalPoints;

    public Exam() {
    }

    public Exam(int courseId, Date date, String duration, ExamType type, String description, double pointsToPass, double totalPoints) {
        this.courseId = courseId;
        this.date = date;
        this.duration = duration;
        this.type = type;
        this.description = description;
        this.pointsToPass = pointsToPass;
        this.totalPoints = totalPoints;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ExamType getType() {
        return type;
    }

    public void setType(ExamType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPointsToPass() {
        return pointsToPass;
    }

    public void setPointsToPass(double pointsToPass) {
        this.pointsToPass = pointsToPass;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", courseId=" + courseId +
                ", date=" + date +
                ", duration='" + duration + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", pointsToPass=" + pointsToPass +
                ", totalPoints=" + totalPoints +
                '}';
    }
}
