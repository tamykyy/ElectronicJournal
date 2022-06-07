package edu.team.electronic_journal.entity;

import javax.persistence.*;

@Entity @Table(name = "teacher_subject")
public class TeacherSubject {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private int id;

    @Column(name = "teacher_id")
    private int teacher_id;

    @Column(name = "subject_id")
    private int subject_id;

    public TeacherSubject() {}

    public TeacherSubject(int teacher_id, int subject_id) {
        this.teacher_id = teacher_id;
        this.subject_id = subject_id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getTeacherId() { return teacher_id; }
    public void setTeacherId(int id) { this.teacher_id = id; }

    public int getSubjectId() { return subject_id; }
    public void setSubjectId(int id) { this.subject_id = id; }

    @Override
    public String toString() {
        return "TeacherSubject{" +
                "id=" + id +
                ", teacher_id='" + teacher_id + '\'' +
                ", subject_id=" + subject_id +
                '}';
    }
}
