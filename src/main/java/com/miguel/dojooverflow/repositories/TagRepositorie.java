package com.miguel.dojooverflow.repositories;

import com.miguel.dojooverflow.models.Tag;

public interface TagRepositorie extends RepositorioBase<Tag>{
    Tag findBySubject (String subject);
}
