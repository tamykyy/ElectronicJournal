package edu.team.electronic_journal.controller;

import edu.team.electronic_journal.entity.Grade;
import edu.team.electronic_journal.service.intefaces.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.* ;

import java.util.List;

@Controller()
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping()
    public String showAllGrades(Model model) {
        List<Grade> gradeList = gradeService.getAllGrades();
        model.addAttribute("gradeList", gradeList);
        return "all-grades";
    }

    @GetMapping("/{id}")
    public Grade showGrade(Model model, @PathVariable("id") int id) {
        Grade grade = gradeService.getGradeById(id);
        model.addAttribute("grade", grade);
        return "one-grade";
    }

    @GetMapping("/add")
    public String addGrade(Model model) {
        Grade grade = new Grade();
        model.addAttribute("grade", grade);
        model.addAttribute("method", RequestMethod.POST);
        return "info-grade";
    }

    @GetMapping("/edit")
    public String changeGrade(@RequestParam("gradeId") int id, Model model) {
        Grade grade = gradeService.getGradeById(id);
        model.addAttribute("grade", grade);
        model.addAttribute("method", RequestMethod.PUT);
        return "info-grade";
    }

    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
    public String saveGrade(@ModelAttribute("grade") Grade grade) {
        gradeService.saveGrade(grade);
        return "redirect:/grades";
    }

    @DeleteMapping("/delete")
    public String deleteGrades(@RequestParam("gradeId") int id) {
        gradeService.deleteGrade(id);
        return "redirect:/grades";
    }
}
