package com.backcrud.backcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.Clase;

@Service
public interface ClaseService {

    public Optional<Clase> getAlummnoById(Integer id);
    public String saveOrUpdate(Clase clase);
    public String deleteById(Integer id);
    public List<Clase> getClase();
    
}
