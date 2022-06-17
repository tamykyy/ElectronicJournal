package edu.team.electronic_journal.entity;

import javax.persistence.*;

@Entity @Table(name = "student")
public class Student extends IsUser {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "class_id")
    private Class class_id;

    public Student() {
    }

    public Class getClass_id() {
        return class_id;
    }

    public void setClass_id(Class class_id) {
        this.class_id = class_id;
    }
}
