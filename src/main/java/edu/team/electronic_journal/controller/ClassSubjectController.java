package edu.team.electronic_journal.controller;

import edu.team.electronic_journal.entity.ClassSubject;
import edu.team.electronic_journal.service.intefaces.ClassSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.* ;

import java.util.List;

@Controller()
@RequestMapping("/classSubjects")
public class ClassSubjectController {
    @Autowired
    private ClassSubjectService classSubjectService;

    @GetMapping()
    public String showAllClassSubjects(Model model) {
        List<ClassSubject> classSubjectList = classSubjectService.getAllClassSubject();
        model.addAttribute("classSubjectList", classSubjectList);
        return null;
    }

    @GetMapping("/{id}")
    public ClassSubject showClassSubject(Model model, @PathVariable("id") int id) {
        ClassSubject classSubject = classSubjectService.getClassSubjectById(id);
        model.addAttribute("classSubject", classSubject);
        return null;
    }

    @GetMapping("/add")
    public String addClassSubject(Model model) {
        ClassSubject classSubject = new ClassSubject();
        model.addAttribute("classSubject", classSubject);
        model.addAttribute("method", RequestMethod.POST);
        return "info-classSubject";
    }

    @GetMapping("/edit")
    public String changeClassSubject(@RequestParam("classSubjectId") int id, Model model) {
        ClassSubject classSubject = classSubjectService.getClassSubjectById(id);
        model.addAttribute("classSubject", classSubject);
        model.addAttribute("method", RequestMethod.PUT);
        return null;
    }

    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
    public String saveClassSubject(@ModelAttribute("classSubject") ClassSubject classSubject) {
        classSubjectService.saveClassSubject(classSubject);
        return null;
    }

    @DeleteMapping("/delete")
    public String deleteClassSubjects(@RequestParam("classSubjectId") int id) {
        classSubjectService.deleteClassSubject(id);
        return null;
    }
}
