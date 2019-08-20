package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.awt.ModalExclude;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    todorepository todoRepository;

    @RequestMapping("/")
    public String listtodo(Model model){
        model.addAttribute("todo", todoRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String todoForm(Model model){
        model.addAttribute("todo", new todo());
        return "todoform";
    }
    @PostMapping("/process")
    public String processForm(@Valid todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todoform";
        }
        todoRepository.save(todo);
        return "redirect:/";
    }
}
