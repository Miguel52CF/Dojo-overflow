package com.miguel.dojooverflow.services;

import org.springframework.stereotype.Service;

import com.miguel.dojooverflow.models.Question;
import com.miguel.dojooverflow.repositories.QuestionRepositorio;

@Service
public class QuestionService extends ServicioBase<Question>{

    public QuestionService(QuestionRepositorio repositorioBase) {
        super(repositorioBase);
    }
    
}
