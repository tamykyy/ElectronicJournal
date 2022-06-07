package edu.team.electronic_journal.service;

import edu.team.electronic_journal.dao.SubjectRepository;
import edu.team.electronic_journal.entity.Subject;
import edu.team.electronic_journal.service.intefaces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Subject;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubjectById(int id) {
        Subject subject = null;
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if(optionalSubject.isPresent()) {
            subject = optionalSubject.get();
        }
        return subject;
    }

    @Override
    public void saveSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(int id) {
        subjectRepository.deleteById(id);
    }
}
