package edu.team.electronic_journal.service;

import edu.team.electronic_journal.dao.GradeRepository;
import edu.team.electronic_journal.entity.Grade;
import edu.team.electronic_journal.service.intefaces.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public Grade getGradeById(int id) {
        Grade grade = null;
        Optional<Grade> optionalGrade = gradeRepository.findById(id);
        if(optionalGrade.isPresent()) {
            grade = optionalGrade.get();
        }
        return grade;
    }

    @Override
    public void saveGrade(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(int id) {
        gradeRepository.deleteById(id);
    }
}
