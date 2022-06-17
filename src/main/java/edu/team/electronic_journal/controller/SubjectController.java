package edu.team.electronic_journal.controller;

import edu.team.electronic_journal.entity.*;
import edu.team.electronic_journal.entity.Class;
import edu.team.electronic_journal.security.AuthenticatedUser;
import edu.team.electronic_journal.service.intefaces.ClassService;
import edu.team.electronic_journal.service.intefaces.SubjectService;
import edu.team.electronic_journal.service.intefaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller()
@RequestMapping("/me")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ClassService classService;

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @GetMapping("/subjects")
    public String showAllMySubjects(Model model) {
        IsUser user = authenticatedUser.getAuthenticatedUser();
        Class aClass = user.getClass_id();
        List<Subject> subjectList = aClass.getSubjectsList();
        model.addAttribute("subjectList", subjectList);
        return "subjects/my-subjects";
    }

    @GetMapping("/school/subjects")
    public String showAllSubjects(Model model) {
        List<Subject> subjectList = subjectService.getAllSubjects();
        model.addAttribute("subjectList", subjectList);
        return "school/subjects/subjects";
    }

    @GetMapping("/school/subject/{id}")
    public String showSubject(Model model, @PathVariable("id") int id) {
        Subject subject = subjectService.getSubjectById(id);
        System.out.println(subject.getTeachersList());
        model.addAttribute("subject", subject);
        return "school/subjects/subject-info";
    }

    @GetMapping("/school/subject/add")
    public String addSubject(Model model) {
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        model.addAttribute("method", RequestMethod.POST);
        return "school/subjects/subject-form";
    }

    @GetMapping("/school/subject/edit/{id}")
    public String changeSubject(@PathVariable("id") int id, Model model) {
        Subject subject = subjectService.getSubjectById(id);
        model.addAttribute("subject", subject);
        model.addAttribute("method", RequestMethod.PUT);
        return "school/subjects/subject-form";
    }

    @RequestMapping(value = "/school/subject/save", method = {RequestMethod.POST, RequestMethod.PUT})
    public String saveSubject(@Valid @ModelAttribute("subject") Subject subject, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "school/subjects/subject-form";
        subjectService.saveSubject(subject);
        return "redirect:/me/school/subjects";
    }

    @GetMapping("/school/subject/{id}/add-teacher")
    public String addTeacherToSubject(@PathVariable(name = "id") int id, Model model) {

        Subject subject = subjectService.getSubjectById(id);
        List<Teacher> teacherList = teacherService.getAllTeacher();

        model.addAttribute("subject", subject);
        model.addAttribute("teacherList", teacherList);
        return "school/subjects/subject-add-teachers-form";
    }

    @PutMapping("/school/subject/{id}/save")
    public String saveTeacherToSubject(@PathVariable(name = "id") int id, @RequestParam(name = "selectedTeacher") int stId) {

        Subject subject = subjectService.getSubjectById(id);
        Teacher teacher = teacherService.getTeacherById(stId);
        subject.addTeacherToSubject(teacher);

        subjectService.saveSubject(subject);
        return "redirect:/me/school/classes";
    }

    @GetMapping("/school/subject/{id}/add-class")
    public String addClassToSubject(@PathVariable(name = "id") int id, Model model) {

        Subject subject = subjectService.getSubjectById(id);
        List<Class> classList = classService.getAllClass();

        model.addAttribute("subject", subject);
        model.addAttribute("classList", classList);
        return "school/subjects/subject-add-class-form";
    }

    @PutMapping("/school/subject/{id}/add-class/save")
    public String saveClassToSubject(@PathVariable(name = "id") int id, @RequestParam(name = "selectedClass") int stId) {

        Subject subject = subjectService.getSubjectById(id);
        Class aClass = classService.getClassById(stId);
        subject.addClassToSubject(aClass);

        subjectService.saveSubject(subject);
        return "redirect:/me/school/classes";
    }

    @DeleteMapping("/school/subject/delete/{id}")
    public String deleteClass(@PathVariable("id") int id) {
        subjectService.deleteSubject(id);
        return "redirect:/me/school/subjects";
    }
}
