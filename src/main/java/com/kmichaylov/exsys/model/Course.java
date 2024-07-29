package com.kmichaylov.exsys.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "exam")
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_year", length = 4)
    private String courseYear;

    @OneToMany(mappedBy = "course")
    private List<Exam> exams;

    public Course() {
    }

    public Course(String courseName, String courseYear) {
        this.courseName = courseName;
        this.courseYear = courseYear;
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

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
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


    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseYear='" + courseYear + '\'' +
                '}';
    }
}
