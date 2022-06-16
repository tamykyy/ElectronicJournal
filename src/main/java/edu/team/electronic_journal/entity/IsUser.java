package edu.team.electronic_journal.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@MappedSuperclass
public class IsUser implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
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
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "Password should not be empty")
    @Size(min = 3, max = 30, message = "Password should be between 3 and 30 characters")
    private String password;

    @Column(name = "phone")
    @Pattern(regexp="(^[0-9]{10})", message = "Phone should be valid")
    private String phone;

    @Column(name = "role")
    private String role;

    public IsUser() {
    }

    public IsUser(String name, String surname, String email, String password, String phone, String role) {
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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
