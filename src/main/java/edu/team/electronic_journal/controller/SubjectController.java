package edu.team.electronic_journal.controller;

import edu.team.electronic_journal.entity.Subject;
import edu.team.electronic_journal.service.intefaces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.* ;

import java.util.List;

@Controller()
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping()
    public String showAllSubjects(Model model) {
        List<Subject> subjectList = subjectService.getAllSubjects();
        model.addAttribute("subjectList", subjectList);
        return null;
    }

    @GetMapping("/{id}")
    public Subject showSubject(Model model, @PathVariable("id") int id) {
        Subject subject = subjectService.getSubjectById(id);
        model.addAttribute("subject", subject);
        return null;
    }

    @GetMapping("/add")
    public String addSubject(Model model) {
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        model.addAttribute("method", RequestMethod.POST);
        return null;
    }

    @GetMapping("/edit")
    public String changeSubject(@RequestParam("subjectId") int id, Model model) {
        Subject subject = subjectService.getSubjectById(id);
        model.addAttribute("subject", subject);
        model.addAttribute("method", RequestMethod.PUT);
        return null;
    }

    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
    public String saveSubject(@ModelAttribute("subject") Subject subject) {
        subjectService.saveSubject(subject);
        return null;
    }

    @DeleteMapping("/delete")
    public String deleteSubjects(@RequestParam("subjectId") int id) {
        subjectService.deleteSubject(id);
        return null;
    }
}
