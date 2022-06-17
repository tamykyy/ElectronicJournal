package edu.team.electronic_journal.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "teacher")
public class Teacher extends IsUser {


    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "class_id")
    private Class class_id;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "teacher_subject",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjectsList;


    public void addSubjectToTeacher(Subject subject) {
        if(subjectsList == null) {
            subjectsList = new ArrayList<>();
        }
        subjectsList.add(subject);
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

}
