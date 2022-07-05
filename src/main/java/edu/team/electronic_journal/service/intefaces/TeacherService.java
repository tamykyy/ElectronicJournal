package edu.team.electronic_journal.service.intefaces;

import edu.team.electronic_journal.entity.Teacher;

import java.util.List;

public interface TeacherService {
    public List<Teacher> getAllTeacher();

    public Teacher getTeacherById(int id);

    public void saveTeacher(Teacher teacher);

    public void deleteTeacher(int id);
}
