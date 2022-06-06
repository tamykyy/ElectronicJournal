package edu.team.electronic_journal.controller;

import edu.team.electronic_journal.entity.Student;
import edu.team.electronic_journal.service.intefaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.* ;


import java.util.List;

@Controller()
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public String showAllStudents(Model model) {
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("studentList", studentList);
        return "all-students";
    }

    @GetMapping("/{id}")
    public String showStudent(Model model, @PathVariable("id") int id) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "one-student";
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("method", RequestMethod.POST);
        return "info-student";
    }

    @GetMapping("/edit")
    public String changeStudent(@RequestParam("studentId") int id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("method", RequestMethod.PUT);
        return "info-student";
    }

    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @DeleteMapping("/delete")
    public String deleteStudents(@RequestParam("studentId") int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
