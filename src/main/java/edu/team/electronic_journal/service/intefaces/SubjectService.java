package edu.team.electronic_journal.service.intefaces;

import edu.team.electronic_journal.entity.Subject;

import java.util.List;

public interface SubjectService {
    public List<Subject> getAllSubjects();

    public Subject getSubjectById(int id);

    public void saveSubject(Subject subject);

    public void deleteSubject(int id);
}
