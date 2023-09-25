package com.miguel.dojooverflow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miguel.dojooverflow.models.Answer;
import com.miguel.dojooverflow.models.Question;
import com.miguel.dojooverflow.services.AnswerService;
import com.miguel.dojooverflow.services.QuestionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @PostMapping("/new")
    public String Create(@Valid @ModelAttribute(value = "responder") Answer answer, BindingResult results,
            @RequestParam(value = "preguntaId") Long preguntaId) {
        if (results.hasErrors()) {
            return "showQuestion.jsp";
        } else {
            Question question = questionService.findById(preguntaId);
            answer.setQuestion(question);
            answerService.save(answer);
            return "redirect:/";
        }
    }

}
