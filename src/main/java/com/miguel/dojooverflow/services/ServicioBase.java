package com.miguel.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miguel.dojooverflow.repositories.RepositorioBase;

@Service
public abstract class ServicioBase<T> {
    
    RepositorioBase<T> repositorioBase;

    public ServicioBase(RepositorioBase<T> repositorioBase) {
        this.repositorioBase = repositorioBase;
    }

    public List<T> findAll() {
        return repositorioBase.findAll();
    }

    public T save(T object) {
        return repositorioBase.save(object);
    }

    public T findById(Long id) {
        Optional<T> optional = repositorioBase.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

}
