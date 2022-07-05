package edu.team.electronic_journal.service.intefaces;

import edu.team.electronic_journal.entity.Grade;

import java.util.List;

public interface GradeService {
    public List<Grade> getAllGrades();

    public Grade getGradeById(int id);

    public void saveGrade(Grade grade);

    public void deleteGrade(int id);
}
