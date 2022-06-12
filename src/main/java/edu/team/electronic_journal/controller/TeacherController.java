package edu.team.electronic_journal.controller;

import edu.team.electronic_journal.entity.Teacher;
import edu.team.electronic_journal.service.intefaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.* ;

import java.util.List;

@Controller()
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping()
    public String showAllTeacher(Model model) {
        List<Teacher> teacherList = teacherService.getAllTeacher();
        model.addAttribute("teacherList", teacherList);
        return null;
    }

    @GetMapping("/{id}")
    public String showTeacher(Model model, @PathVariable("id") int id) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        return null;
    }

    @GetMapping("/add")
    public String addTeacher(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        model.addAttribute("method", RequestMethod.POST);
        return null;
    }

    @GetMapping("/edit")
    public String changeTeacher(@RequestParam("teacherId") int id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        model.addAttribute("method", RequestMethod.PUT);
        return null;
    }

    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return null;
    }

    @DeleteMapping("/delete")
    public String deleteTeacher(@RequestParam("teacherId") int id) {
        teacherService.deleteTeacher(id);
        return null;
    }
}
