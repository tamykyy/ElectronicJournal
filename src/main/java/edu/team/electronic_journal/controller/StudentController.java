package edu.team.electronic_journal.controller;

import edu.team.electronic_journal.entity.Class;
import edu.team.electronic_journal.entity.Student;
import edu.team.electronic_journal.service.intefaces.ClassService;
import edu.team.electronic_journal.service.intefaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller()
@RequestMapping("/me/school")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassService classService;

    @GetMapping("/students")
    public String showAllStudents(Model model) {
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("studentList", studentList);
        return "school/students/students";
    }

    @GetMapping("/student/{id}")
    public String showStudent(Model model, @PathVariable("id") int id) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "school/students/student-info";
    }

    @GetMapping("/student/add")
    public String addStudent(Model model) {
        Student student = new Student();
        List<Class> classList = classService.getAllClass();

        model.addAttribute("student", student);
        model.addAttribute("classList", classList);
        model.addAttribute("method", RequestMethod.POST);
        return "school/students/student-form";
    }

    @GetMapping("student/edit/{id}")
    public String changeStudent(@PathVariable("id") int id, Model model) {
        Student student = studentService.getStudentById(id);
        List<Class> classList = classService.getAllClass();

        model.addAttribute("student", student);
        model.addAttribute("classList", classList);
        model.addAttribute("method", RequestMethod.PUT);
        return "school/students/student-form";
    }

    @RequestMapping(value = "student/save",method = {RequestMethod.POST, RequestMethod.PUT})
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
                              @RequestParam(value = "selectedClass") int class_id) {

        if (bindingResult.hasErrors())
            return "school/students/student-form";

        student.setRole("ROLE_STUDENT");
        if (class_id != 0) {
            Class aClass = classService.getClassById(class_id);
            student.setClass_id(aClass);
        }
        studentService.saveStudent(student);
        return "redirect:/me/school/students";
    }


    @DeleteMapping(value = "/delete")
    public String deleteStudents(@RequestParam("studentId") int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
