package com.miguel.dojooverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguel.dojooverflow.models.Tag;
import com.miguel.dojooverflow.repositories.TagRepositorie;

@Service
public class TagService extends ServicioBase<Tag>{

    @Autowired TagRepositorie tagRepositorie;

    public TagService(TagRepositorie  repositorioBase) {
        super(repositorioBase);
    }

     public Long findBySubject(String subject) {
        Tag optional = tagRepositorie.findBySubject(subject);
        if (optional != null) {
            return optional.getId();
        } else {
            return null;
        }
    }
    
}
