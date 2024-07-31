package com.kmichaylov.exsys.dto;

import com.kmichaylov.exsys.enumeration.ExamType;
import com.kmichaylov.exsys.model.Course;
import com.kmichaylov.exsys.model.Question;
import com.kmichaylov.exsys.model.StudentAnswer;
import com.kmichaylov.exsys.model.StudentExam;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class ExamDTO {


    private Course course;

    private Date date;

    private int duration;

    private ExamType type;

    private String description;

    private double pointsToPass;

    private double totalPoints;


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
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
}
