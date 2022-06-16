package edu.team.electronic_journal.controller;

import edu.team.electronic_journal.entity.Class;
import edu.team.electronic_journal.entity.Student;
import edu.team.electronic_journal.entity.Subject;
import edu.team.electronic_journal.entity.Teacher;
import edu.team.electronic_journal.service.intefaces.ClassService;
import edu.team.electronic_journal.service.intefaces.StudentService;
import edu.team.electronic_journal.service.intefaces.SubjectService;
import edu.team.electronic_journal.service.intefaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping("me/school")
public class SchoolController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    ClassService classService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    StudentService studentService;

    @GetMapping("/teachershehehaha")
    public String showAllTeachersOld(Model model) {

        //

        List<Subject> subjectList = subjectService.getAllSubjects();
        model.addAttribute("subjectList", subjectList);

        //


        return "school/school";
    }


    ////////////////////////////////////////////////





    ////////////////////////////////////////////////




}
