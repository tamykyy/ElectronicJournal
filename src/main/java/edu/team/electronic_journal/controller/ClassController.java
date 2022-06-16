package edu.team.electronic_journal.controller;

import edu.team.electronic_journal.entity.Class;
import edu.team.electronic_journal.entity.IsUser;
import edu.team.electronic_journal.entity.Student;
import edu.team.electronic_journal.security.AuthenticatedUser;
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
@RequestMapping("me")
public class ClassController {

    @Autowired
    private ClassService classService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @GetMapping("/class")
    public String goToMyClass(Model model) {
        IsUser user = authenticatedUser.getAuthenticatedUser();

        model.addAttribute("classExist", false);

        if (user.getClass_id() != null) {
            Class class_id = classService.getClassById(user.getClass_id().getId());
            model.addAttribute("classExist", true);
            model.addAttribute("class", class_id);
            model.addAttribute("studentList", class_id.getStudentsList());
        }

        return "class/my-class";
    }

    @GetMapping("/school/classes")
    public String showAllClass(Model model) {
        List<Class> classList = classService.getAllClass();
        model.addAttribute("classList", classList);
        return "school/classes/classes";
    }

    @GetMapping("/school/class/{id}")
    public String showClass(@PathVariable("id") int id, Model model) {
        Class aClass = classService.getClassById(id);
        model.addAttribute("class", aClass);
        return "school/classes/class-info";
    }


    @GetMapping("/school/class/add")
    public String addClass(Model model) {
        Class Class = new Class();
        model.addAttribute("class", Class);
        model.addAttribute("method", RequestMethod.POST);
        return "school/classes/class-form";
    }

    @GetMapping("/school/class/edit/{id}")
    public String changeClass(@PathVariable("id") int id, Model model) {
        Class Class = classService.getClassById(id);
        model.addAttribute("class", Class);
        model.addAttribute("method", RequestMethod.PUT);
        return "school/classes/class-form";
    }

    @RequestMapping(value = "/school/class/save", method = {RequestMethod.POST, RequestMethod.PUT})
    public String saveClass(@Valid @ModelAttribute("class") Class Class, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "school/class-form";
        classService.saveClass(Class);
        return "redirect:/me/school/classes";
    }

    @GetMapping("/school/class/{id}/add-student")
    public String addStudentToClass(@PathVariable(name = "id") int id, Model model) {

        Class aClass = classService.getClassById(id);
        List<Student> studentList = studentService.getAllStudents();

        model.addAttribute("class", aClass);
        model.addAttribute("studentList", studentList);
        return "school/classes/class-add-student-form";
    }

    @PutMapping("/school/class/{id}/save")
    public String saveStudentToClass(@PathVariable(name = "id") int id, @RequestParam(name = "selectedStudent") int stId) {

        Class aClass = classService.getClassById(id);
        Student student = studentService.getStudentById(stId);
        aClass.addStudentToClass(student);

        classService.saveClass(aClass);
        return "redirect:/me/school/classes";
    }

    @DeleteMapping("/delete")
    public String deleteClass(@RequestParam("classId") int id) {
        classService.deleteClass(id);
        return "redirect:/me/school/classes";
    }

}
