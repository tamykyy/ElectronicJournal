package edu.team.electronic_journal.controller;

import edu.team.electronic_journal.entity.Class;
import edu.team.electronic_journal.entity.IsUser;
import edu.team.electronic_journal.entity.Student;
import edu.team.electronic_journal.entity.Teacher;
import edu.team.electronic_journal.security.AuthenticatedUser;
import edu.team.electronic_journal.security.IsUserDetails;
import edu.team.electronic_journal.service.intefaces.ClassService;
import edu.team.electronic_journal.service.intefaces.StudentService;
import edu.team.electronic_journal.service.intefaces.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/me")
public class ProfileController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ClassService classService;

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @GetMapping("")
    public String goToProfileChapter(Model model) {

        IsUser user = authenticatedUser.getAuthenticatedUser();
        model.addAttribute("userInfo", user);
        return "profile/profile";
    }

    @GetMapping("profile/edit")
    public String changeUserInfo(Model model) {

        IsUser user = authenticatedUser.getAuthenticatedUser();
        model.addAttribute("userInfo", user);
        model.addAttribute("userChildClass", user.getClass().toString());
        model.addAttribute("class_id", user.getClass_id().getId());

        return "profile/profile-change-form";
    }

    @PutMapping("profile/edit/save-user")
    public String saveUser(@ModelAttribute("userInfo") IsUser user,
                           @ModelAttribute("userChildClass") String s,
                           @ModelAttribute("class_id") int class_id) {

        if (s.endsWith(Student.class.toString())) {
            Student student = new Student();
            BeanUtils.copyProperties(user, student);
            student.setClass_id(classService.getClassById(class_id));
            studentService.saveStudent(student);
        } else {
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(user, teacher);
            teacher.setClass_id(classService.getClassById(class_id));
            teacherService.saveTeacher(teacher);
        }
        return "redirect:/me";
    }

}
