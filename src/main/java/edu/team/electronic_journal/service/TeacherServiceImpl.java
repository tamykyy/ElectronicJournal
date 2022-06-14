package edu.team.electronic_journal.service;

import edu.team.electronic_journal.dao.TeacherRepository;
import edu.team.electronic_journal.entity.Teacher;
import edu.team.electronic_journal.service.intefaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(int id) {
        Teacher teacher = null;
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if(optionalTeacher.isPresent()) {
            teacher = optionalTeacher.get();
        }
        return teacher;
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(int id) {
        teacherRepository.deleteById(id);
    }
}
