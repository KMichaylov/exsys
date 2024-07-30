package com.kmichaylov.exsys.model;

import com.kmichaylov.exsys.enumeration.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", updatable = false, nullable = false)
    private Integer personId;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    private List<StudentAnswer> studentAnswers;

    @OneToMany
    private List<StudentExam> studentExams;

    public Person() {
    }

    public Person(String fullName, String email, String password, Role role, List<StudentAnswer> studentAnswers, List<StudentExam> studentExams) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.studentAnswers = studentAnswers;
        this.studentExams = studentExams;
    }


    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<StudentAnswer> getStudentAnswers() {
        return studentAnswers;
    }

    public void setStudentAnswers(List<StudentAnswer> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }

    public List<StudentExam> getStudentExams() {
        return studentExams;
    }

    public void setStudentExams(List<StudentExam> studentExams) {
        this.studentExams = studentExams;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", studentAnswers=" + studentAnswers +
                ", studentExams=" + studentExams +
                '}';
    }
}
