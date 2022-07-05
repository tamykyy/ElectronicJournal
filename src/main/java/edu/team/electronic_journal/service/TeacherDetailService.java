package edu.team.electronic_journal.service;

import edu.team.electronic_journal.dao.TeacherRepository;
import edu.team.electronic_journal.entity.Teacher;
import edu.team.electronic_journal.security.TeacherDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherDetailService implements UserDetailsService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Teacher> teacher = teacherRepository.findTeacherByEmail(s);
        if (teacher.isEmpty()) {
            throw new UsernameNotFoundException("Неправильна пошта!");
        }

        return new TeacherDetails(teacher.get());
    }


}
