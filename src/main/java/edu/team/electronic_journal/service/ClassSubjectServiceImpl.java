package edu.team.electronic_journal.service;

import edu.team.electronic_journal.dao.ClassSubjectRepository;
import edu.team.electronic_journal.entity.ClassSubject;
import edu.team.electronic_journal.service.intefaces.ClassSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class ClassSubjectServiceImpl implements ClassSubjectService {
    @Autowired
    private ClassSubjectRepository classSubjectRepository;

    @Override
    public List<ClassSubject> getAllClassSubject() {
        return classSubjectRepository.findAll();
    }

    @Override
    public ClassSubject getClassSubjectById(int id) {
        ClassSubject classSubject = null;
        Optional<ClassSubject> optionalClassSubject = classSubjectRepository.findById(id);
        if(optionalClassSubject.isPresent()) {
            classSubject = optionalClassSubject.get();
        }
        return classSubject;
    }

    @Override
    public void saveClassSubject(ClassSubject classSubject) {
        classSubjectRepository.save(classSubject);
    }

    @Override
    public void deleteClassSubject(int id) {
        classSubjectRepository.deleteById(id);
    }
}
