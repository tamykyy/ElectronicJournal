package edu.team.electronic_journal.entity;

import javax.persistence.*;

@Entity @Table(name = "grade")
public class Grade {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private int id;

    @Column(name = "data")
    private String data;

    @Column(name = "grade")
    private int grade;

    @Column(name = "subject_id")
    private int subject_id;

    @Column(name = "student_id")
    private int student_id;

    public Grade() {}

    public Grade(String data, int grade, int subject_id, int student_id) {
        this.data = data;
        this.grade = grade;
        this.subject_id = subject_id;
        this.student_id = student_id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }

    public int getSubjectId() { return subject_id; }
    public void setSubjectId(int id) { this.subject_id = id; }

    public int getStudentId() { return student_id; }
    public void setStudentId(int id) { this.student_id = id; }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", grade='" + grade + '\'' +
                ", subject_id='" + subject_id + '\'' +
                ", student_id=" + student_id +
                '}';
    }
}
