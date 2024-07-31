package com.kmichaylov.exsys.model;

import com.kmichaylov.exsys.enumeration.ExamType;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examId;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
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


    @OneToMany
    private List<StudentAnswer> studentAnswers;

    @OneToMany
    private List<Question> questions;

    @OneToMany
    private List<StudentExam> studentExams;

    public Exam() {
    }

    public Exam(Date date, String duration, ExamType type, String description, double pointsToPass, double totalPoints, Course course, List<StudentAnswer> studentAnswers, List<Question> questions, List<StudentExam> studentExams) {
        this.date = date;
        this.duration = duration;
        this.type = type;
        this.description = description;
        this.pointsToPass = pointsToPass;
        this.totalPoints = totalPoints;
        this.course = course;
        this.studentAnswers = studentAnswers;
        this.questions = questions;
        this.studentExams = studentExams;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<StudentAnswer> getStudentAnswers() {
        return studentAnswers;
    }

    public void setStudentAnswers(List<StudentAnswer> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<StudentExam> getStudentExams() {
        return studentExams;
    }

    public void setStudentExams(List<StudentExam> studentExams) {
        this.studentExams = studentExams;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", date=" + date +
                ", duration='" + duration + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", pointsToPass=" + pointsToPass +
                ", totalPoints=" + totalPoints +
                ", course=" + course +
                ", studentAnswers=" + studentAnswers +
                ", questions=" + questions +
                ", studentExams=" + studentExams +
                '}';
    }
}
