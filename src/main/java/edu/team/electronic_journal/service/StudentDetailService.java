package edu.team.electronic_journal.service;

import edu.team.electronic_journal.dao.StudentRepository;
import edu.team.electronic_journal.entity.Student;
import edu.team.electronic_journal.security.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentDetailService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Student> student = studentRepository.findStudentByEmail(s);
        if (student.isEmpty()) {
            throw new UsernameNotFoundException("Неправильна пошта!");
        }

        return new StudentDetails(student.get());
    }
}
