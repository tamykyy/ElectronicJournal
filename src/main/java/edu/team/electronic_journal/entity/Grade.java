package edu.team.electronic_journal.entity;

import javax.persistence.*;

@Entity @Table(name = "grade")
public class Grade {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "grade")
    private int grade;

    @Column(name = "subject_id")
    private int subject_id;

    @Column(name = "student_id")
    private int student_id;

    public Grade() {}

    public Grade(String date, int grade, int subject_id, int student_id) {
        this.date = date;
        this.grade = grade;
        this.subject_id = subject_id;
        this.student_id = student_id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDate() { return date; }
    public void setDate(String data) { this.date = date; }

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
                ", data='" + date + '\'' +
                ", grade='" + grade + '\'' +
                ", subject_id='" + subject_id + '\'' +
                ", student_id=" + student_id +
                '}';
    }
}
