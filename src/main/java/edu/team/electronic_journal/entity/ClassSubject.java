package edu.team.electronic_journal.entity;

import javax.persistence.*;

@Entity @Table(name = "class_subject")
public class ClassSubject {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private int id;

    @Column(name = "class_id")
    private int class_id;

    @Column(name = "subject_id")
    private int subject_id;

    public ClassSubject() {}

    public ClassSubject(int teacher_id, int subject_id) {
        this.class_id = teacher_id;
        this.subject_id = subject_id;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getClassId() { return class_id; }
    public void setTeacherId(int id) { this.class_id = id; }

    public int getSubjectId() { return subject_id; }
    public void setSubjectId(int id) { this.subject_id = id; }

    @Override
    public String toString() {
        return "ClassSubject{" +
                "id=" + id +
                ", teacher_id='" + class_id + '\'' +
                ", subject_id=" + subject_id +
                '}';
    }
}
