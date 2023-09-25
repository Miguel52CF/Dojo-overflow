package com.miguel.dojooverflow.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miguel.dojooverflow.models.Answer;
import com.miguel.dojooverflow.models.Question;
import com.miguel.dojooverflow.models.Tag;
import com.miguel.dojooverflow.services.QuestionService;
import com.miguel.dojooverflow.services.TagService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    TagService tagService;

    @GetMapping("/new")
    public String New(@ModelAttribute(value = "pregunta") Question pregunta) {
        return "NewQuestion.jsp";
    }

    @PostMapping("/new")
    public String Create(@Valid @ModelAttribute(value = "pregunta") Question pregunta, BindingResult results,
            @RequestParam(value = "etiquetas") String tags) {
        if (results.hasErrors()) {
            return "NewQuestion.jsp";
        } else {
            Set<Tag> tagsQ = new HashSet<>();
            pregunta.setTags(tagsQ);
            questionService.save(pregunta);
            GuardarTags(tags,pregunta.getId());
            return "redirect:/";
        }
    }

    private Long findTagId(String tags) {
        Long tagId = tagService.findBySubject(tags);
        if (tagId == null) {
            Tag newTag = new Tag();
            newTag.setSubject(tags.trim());
            tagService.save(newTag);
            tagId = newTag.getId();
        }
        return tagId;
    }

    private void GuardarTags(String tags, Long questionId) {
        String[] tagsSeparados = separarTags(tags); 
        for (String tag : tagsSeparados) {
            juntarPreguntaYTag(findTagId(tag),questionId);
        }
    }
    
    private void juntarPreguntaYTag(Long tagId, Long questionId) {
        Tag tag = tagService.findById(tagId);
        Question question = questionService.findById(questionId); 
        Set<Tag> tags = question.getTags();
        tags.add(tag);
        questionService.save(question);
    }

    private static String[] separarTags(String palabra) {
        String[] parts = palabra.split(",");
        return parts;
    }

    @GetMapping("{id}")
    public String Show(Model model, @PathVariable("id") Long id,
            @ModelAttribute(value = "responder") Answer answer) {
        Question question = questionService.findById(id);
        model.addAttribute("pregunta", question);
        return "showQuestion.jsp";
    }

}
