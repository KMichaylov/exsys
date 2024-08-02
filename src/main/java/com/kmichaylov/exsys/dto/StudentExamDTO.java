package com.kmichaylov.exsys.dto;

public class StudentExamDTO {
    private int studentExamId;
    private double obtainedPoints;
    private boolean examPassed;
    private int personId;
    private int examId;

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

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }
}
