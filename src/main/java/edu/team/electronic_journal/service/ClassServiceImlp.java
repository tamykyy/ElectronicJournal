package edu.team.electronic_journal.service;

import edu.team.electronic_journal.dao.ClassRepository;
import edu.team.electronic_journal.entity.Class;
import edu.team.electronic_journal.service.intefaces.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class ClassServiceImlp implements ClassService{
    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<Class> getAllClass() {
        return classRepository.findAll();
    }

    @Override
    public Class getClassById(int id) {
        Class Class = null;
        Optional<Class> optionalClass = classRepository.findById(id);
        if(optionalClass.isPresent()) {
            Class = optionalClass.get();
        }
        return Class;
    }

    @Override
    public void saveClass(Class Class) {
        classRepository.save(Class);
    }

    @Override
    public void deleteClass(int id) {
        classRepository.deleteById(id);
    }
}
