package edu.team.electronic_journal.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "teacher")
public class Teacher implements IsUser{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Name should not be empty")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20 characters")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "Surname should not be empty")
    @Size(min = 2, max = 25, message = "Surname should be between 2 and 25 characters")
    private String surname;

    @Column(name = "email")
    @NotBlank(message = "Email should not be empty")
    @Emai(message = "Email should be valid")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "Password should not be empty")
    @Size(min = 3, max = 30, message = "Password should be between 3 and 30 characters")
    private String password;

    @Column(name = "phone")
    @Pattern(regexp="(^[0-9]{10})", message = "Phone should be valid")
    private String phone;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "class_id")
    private Class class_id;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(
            name = "teacher_subject",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjectsList;

    @Column(name = "role")
    private String role;

    public Teacher() {
    }

    public Teacher(String name, String surname, String email, String password, String phone, String role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public void addSubjectToTeacher(Subject subject) {
        if(subjectsList == null) {
            subjectsList = new ArrayList<>();
        }
        subjectsList.add(subject);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Class getClass_id() {
        return class_id;
    }

    public void setClass_id(Class class_id) {
        this.class_id = class_id;
    }

    public List<Subject> getSubjectsList() {
        return subjectsList;
    }

    public void setSubjectsList(List<Subject> subjectsList) {
        this.subjectsList = subjectsList;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
