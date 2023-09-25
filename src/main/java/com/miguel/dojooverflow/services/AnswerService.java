package com.miguel.dojooverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguel.dojooverflow.models.Answer;
import com.miguel.dojooverflow.repositories.AnswerRepositorio;

@Service
public class AnswerService extends ServicioBase<Answer>{

    @Autowired AnswerRepositorio answerRepositorio;

    public AnswerService(AnswerRepositorio repositorioBase) {
        super(repositorioBase);
    }
    
}
