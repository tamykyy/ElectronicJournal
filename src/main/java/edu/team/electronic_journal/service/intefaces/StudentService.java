package edu.team.electronic_journal.service.intefaces;

import edu.team.electronic_journal.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> getAllStudents();

    public Student getStudentById(int id);

    public void saveStudent(Student student);

    public void deleteStudent(int id);
}
