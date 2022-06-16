package edu.team.electronic_journal.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@MappedSuperclass
public class IsUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Імʼя це обовʼязкове поле")
    @Size(min = 2, max = 20, message = "Імʼя повинно бути від 2 до 20 символів")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "Прізвище це обовʼязкове поле")
    @Size(min = 2, max = 25, message = "Прізвище повинно бути від 2 до 25 символів")
    private String surname;

    @Column(name = "email")
    @NotBlank(message = "Пошта це обовʼязкове поле")
    @Email(message = "Пошта повинна пʼбути валідною")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "Пароль це обовʼязкове поле")
    @Size(min = 3, max = 30, message = "Пароль повинен бути від 3 до 30 символів")
    private String password;

    @Column(name = "phone")
    @Pattern(regexp="(^[0-9]{10})", message = "Номер телефона повинен бути валідним")
    private String phone;

    @Column(name = "role")
    private String role;

    public IsUser() {
    }

    public IsUser(int id, String name, String surname, String email, String password, String phone, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Class getClass_id() {
        return null;
    }


    @Override
    public String toString() {
        return "IsUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
