package edu.team.electronic_journal.entity;

import javax.persistence.*;

@Entity @Table(name = "subject")
public class Subject {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Subject() {}

    public Subject(String name) {
        this.name = name;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
