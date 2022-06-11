package edu.team.electronic_journal.service.intefaces;

import edu.team.electronic_journal.entity.ClassSubject;

import java.util.List;

public interface ClassSubjectService {
    public List<ClassSubject> getAllClassSubject();

    public ClassSubject getClassSubjectById(int id);

    public void saveClassSubject(ClassSubject class_subject);

    public void deleteClassSubject(int id);
}
