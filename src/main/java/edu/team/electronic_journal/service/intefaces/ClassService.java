package edu.team.electronic_journal.service.intefaces;

import edu.team.electronic_journal.entity.Class;

import java.util.List;

public interface ClassService {
    public List<Class> getAllClass();

    public Class getClassById(int id);

    public void saveClass(Class Class);

    public void deleteClass(int id);
}
