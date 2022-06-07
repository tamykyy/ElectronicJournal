package edu.team.electronic_journal.service;

import edu.team.electronic_journal.dao.TeacherSubjectRepository;
import edu.team.electronic_journal.entity.TeacherSubject;
import edu.team.electronic_journal.service.intefaces.TeacherSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherSubjectServiceImpl implements TeacherSubjectService {

    @Autowired
    private TeacherSubjectRepository teacherSubjectRepository;

    @Override
    public List<TeacherSubject> getAllTeacherSubjects() {
        return teacherSubjectRepository.findAll();
    }

    @Override
    public TeacherSubject getTeacherSubjectById(int id) {
        TeacherSubject teacherSubject = null;
        Optional<TeacherSubject> optionalTeacherSubject = teacherSubjectRepository.findById(id);
        if(optionalTeacherSubject.isPresent()) {
            teacherSubject = optionalTeacherSubject.get();
        }
        return teacherSubject;
    }

    @Override
    public void saveTeacherSubject(TeacherSubject teacherSubject) {
        teacherSubjectRepository.save(teacherSubject);
    }

    @Override
    public void deleteTeacherSubject(int id) {
        teacherSubjectRepository.deleteById(id);
    }
}
