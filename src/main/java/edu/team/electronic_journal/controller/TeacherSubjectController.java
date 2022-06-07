package edu.team.electronic_journal.controller;

import edu.team.electronic_journal.entity.Grade;
import edu.team.electronic_journal.entity.TeacherSubject;
import edu.team.electronic_journal.service.intefaces.TeacherSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.* ;

import java.util.List;

@Controller()
@RequestMapping("/teacherSubjects")
public class TeacherSubjectController {

    @Autowired
    private TeacherSubjectService teacherSubjectService;

    @GetMapping()
    public String showAllTeacherSubjects(Model model) {
        List<TeacherSubject> teacherSubjectList = teacherSubjectService.getAllTeacherSubjects();
        model.addAttribute("teacherSubjectList", teacherSubjectList);
        return null;
    }

    @GetMapping("/{id}")
    public TeacherSubject showTeacherSubject(Model model, @PathVariable("id") int id) {
        TeacherSubject teacherSubject = teacherSubjectService.getTeacherSubjectById(id);
        model.addAttribute("teacherSubject", teacherSubject);
        return null;
    }

    @GetMapping("/add")
    public String addTeacherSubject(Model model) {
        TeacherSubject teacherSubject = new TeacherSubject();
        model.addAttribute("teacherSubject", teacherSubject);
        model.addAttribute("method", RequestMethod.POST);
        return "info-teacherSubject";
    }

    @GetMapping("/edit")
    public String changeTeacherSubject(@RequestParam("teacherSubjectId") int id, Model model) {
        TeacherSubject teacherSubject = teacherSubjectService.getTeacherSubjectById(id);
        model.addAttribute("teacherSubject", teacherSubject);
        model.addAttribute("method", RequestMethod.PUT);
        return "info-teacherSubject";
    }

    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
    public String saveTeacherSubject(@ModelAttribute("teacherSubject") TeacherSubject teacherSubject) {
        teacherSubjectService.saveTeacherSubject(teacherSubject);
        return "redirect:/teacherSubjects";
    }

    @DeleteMapping("/delete")
    public String deleteTeacherSubjects(@RequestParam("teacherSubjectId") int id) {
        teacherSubjectService.deleteTeacherSubject(id);
        return "redirect:/teacherSubjects";
    }
}
