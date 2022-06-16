package edu.team.electronic_journal.security;

import edu.team.electronic_journal.entity.IsUser;
import edu.team.electronic_journal.entity.Student;
import edu.team.electronic_journal.service.intefaces.StudentService;
import edu.team.electronic_journal.service.intefaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatedUser {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    public IsUser getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        IsUserDetails userDetails = (IsUserDetails) authentication.getPrincipal();

        IsUser user = userDetails.getUser();
        if (user instanceof Student) {
            user = studentService.getStudentById(user.getId());
        } else {
            user = teacherService.getTeacherById(user.getId());
        }
        return user;
    }

}
