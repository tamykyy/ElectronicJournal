package edu.team.electronic_journal.controller;

import edu.team.electronic_journal.entity.Class;
import edu.team.electronic_journal.entity.Teacher;
import edu.team.electronic_journal.service.intefaces.ClassService;
import edu.team.electronic_journal.service.intefaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.* ;

import java.util.List;

@Controller()
@RequestMapping("me/school")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ClassService classService;

    @GetMapping("/teachers")
    public String showAllTeachers(Model model) {
        List<Teacher> teacherList = teacherService.getAllTeacher();
        model.addAttribute("teacherList", teacherList);

        return "school/teachers";
    }

    @GetMapping("/teacher/{id}")
    public String showTeacher(@PathVariable("id") int id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        return "school/teacher-info";
    }

    @GetMapping("/teacher/add")
    public String addTeacher(Model model) {
        Teacher teacher = new Teacher();
        List<Class> classList = classService.getAllClass();

        model.addAttribute("teacher", teacher);
        model.addAttribute("classList", classList);
        model.addAttribute("method", RequestMethod.POST);
        return "school/teacher-form";
    }

    @GetMapping("teacher/edit/{id}")
    public String changeTeacher(@PathVariable("id") int id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        List<Class> classList = classService.getAllClass();

        model.addAttribute("teacher", teacher);
        model.addAttribute("classList", classList);
        model.addAttribute("method", RequestMethod.PUT);
        return "school/teacher-form";
    }

    @RequestMapping(value = "/teacher/save", method = {RequestMethod.POST, RequestMethod.PUT})
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher,
                              @RequestParam(value = "selectedClass") int class_id) {

        teacher.setRole("ROLE_TEACHER");
        if (class_id != 0) {
            Class aClass = classService.getClassById(class_id);
            teacher.setClass_id(aClass);
        }
        teacherService.saveTeacher(teacher);
        return "redirect:/me/school/teachers";
    }


    @DeleteMapping("teacher/delete/{id}")
    public String deleteTeacher(@PathVariable("id") int id) {
        teacherService.deleteTeacher(id);
        return "redirect:/me/school/teachers";
    }
}
