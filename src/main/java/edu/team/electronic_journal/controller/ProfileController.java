package edu.team.electronic_journal.controller;

import edu.team.electronic_journal.entity.IsUser;
import edu.team.electronic_journal.security.IsUserDetails;
import edu.team.electronic_journal.service.intefaces.StudentService;
import edu.team.electronic_journal.service.intefaces.TeacherService;
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

    @GetMapping("")
    public String goToProfileChapter(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        IsUserDetails userDetails = (IsUserDetails) authentication.getPrincipal();

        model.addAttribute("userInfo", userDetails.getUser());

        return "profile";
    }

    @GetMapping("profile/edit")
    public String changeUserInfo(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        IsUserDetails userDetails = (IsUserDetails) authentication.getPrincipal();

        model.addAttribute("userInfo", userDetails.getUser());

        return "changeform";
    }

    @PutMapping("profile/edit/save-user")
    public String saveUser(@ModelAttribute(name = "userInfo") IsUser user) {
        System.out.println(user.getClass());

//        if (user.getClass() == Teacher.class){
//            Teacher teacher;
//            teacherService.saveTeacher( (Teacher) user);
//        } else {
//            Student student = (edu.team.electronic_journal.entity.Student) user;
//            System.out.println(student);
////            studentService.saveStudent(student);
//        }

        return "redirect:/me";
    }




}
