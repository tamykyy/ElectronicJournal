package edu.team.electronic_journal.service.intefaces;

import edu.team.electronic_journal.entity.TeacherSubject;

import java.util.List;

public interface TeacherSubjectService {
    public List<TeacherSubject> getAllTeacherSubjects();

    public TeacherSubject getTeacherSubjectById(int id);

    public void saveTeacherSubject(TeacherSubject teacher_subject);

    public void deleteTeacherSubject(int id);
}
