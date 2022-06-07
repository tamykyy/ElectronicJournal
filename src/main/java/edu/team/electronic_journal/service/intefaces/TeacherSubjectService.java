package edu.team.electronic_journal.service.intefaces;

import edu.team.electronic_journal.entity.TeacherSubject;

import java.util.List;
import java.util.Optional;

public interface TeacherSubjectService {
    public List<TeacherSubject> getAllTeacherSubjects();

    public Grade getTeacherSubjectById(int id);

    public void saveTeacherSubject(TeacherSubject teacher_subject);

    public void deleteTeacherSubject(int id);
}
