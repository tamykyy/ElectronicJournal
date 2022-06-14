package edu.team.electronic_journal.controller;

import edu.team.electronic_journal.entity.Class;
import edu.team.electronic_journal.service.intefaces.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.* ;

import java.util.List;

@Controller()
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping()
    public String showAllClass(Model model) {
        List<Class> classList = classService.getAllClass();
        model.addAttribute("classList", classList);
        return null;
    }

    @GetMapping("/{id}")
    public Class showClass(Model model, @PathVariable("id") int id) {
        Class Class = classService.getClassById(id);
        model.addAttribute("class", Class);
        return null;

    }

    @GetMapping("/add")
    public String addClass(Model model) {
        Class Class = new Class();
        model.addAttribute("class", Class);
        model.addAttribute("method", RequestMethod.POST);
        return null;
    }

    @GetMapping("/edit")
    public String changeClass(@RequestParam("classId") int id, Model model) {
        Class Class = classService.getClassById(id);
        model.addAttribute("class", Class);
        model.addAttribute("method", RequestMethod.PUT);
        return null;
    }

    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
    public String saveClass(@ModelAttribute("class") Class Class) {
        classService.saveClass(Class);
        return null;
    }

    @DeleteMapping("/delete")
    public String deleteClass(@RequestParam("classId") int id) {
        classService.deleteClass(id);
        return null;
    }

}
