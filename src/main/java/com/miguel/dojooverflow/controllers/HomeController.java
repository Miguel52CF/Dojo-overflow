package com.miguel.dojooverflow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miguel.dojooverflow.models.Question;
import com.miguel.dojooverflow.services.QuestionService;

@Controller
public class HomeController {
    
    @Autowired QuestionService questionService;

    @RequestMapping("/")
    public String home(Model model){
        List<Question> questions = questionService.findAll();
        model.addAttribute("questions", questions);
        return "index.jsp";
    }

}
