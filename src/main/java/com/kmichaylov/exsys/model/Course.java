package com.kmichaylov.exsys.model;

import jakarta.persistence.*;
import org.hibernate.mapping.Join;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_year", length = 4)
    private String courseYear;

    @OneToMany
    private List<Exam> exams;

    public Course() {
    }

    public Course(String courseName, String courseYear, List<Exam> exams) {
        this.courseName = courseName;
        this.courseYear = courseYear;
        this.exams = exams;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseYear='" + courseYear + '\'' +
                ", exams=" + exams +
                '}';
    }
}
