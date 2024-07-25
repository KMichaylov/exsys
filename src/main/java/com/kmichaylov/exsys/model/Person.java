package com.kmichaylov.exsys.model;

import com.kmichaylov.exsys.enumeration.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "person_id")
    private String personId;
    @Column(name = "full_name")
    @NotBlank(message = "Full name is mandatory")
    private String fullName;
    @Column(name = "email")
    @NotBlank(message = "Email is mandatory")
    private String email;
    @Column(name = "password")
    @NotBlank(message = "Password is mandatory")
    private String password;
    @Column(name = "role")
    @NotBlank(message = "Role is mandatory")
    private Role role;

    public Person() {

    }

    public Person(String fullName, String email, String password, Role role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
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

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId='" + personId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }


}
