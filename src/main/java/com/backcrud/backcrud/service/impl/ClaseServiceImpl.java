package com.backcrud.backcrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.Clase;
import com.backcrud.backcrud.repository.ClaseRepository;
import com.backcrud.backcrud.service.ClaseService;

@Service
public class ClaseServiceImpl implements ClaseService{
    String message=("");
    @Autowired
    ClaseRepository claseRepository;

    @Override
    public Optional<Clase> getAlummnoById(Integer id) {
        if  (claseRepository.existsById(id)){
            message = ("El Alummno se ha encontrado");
            return claseRepository.findById(id);
        }
        message = ("El Alummno no se ha encontrado");
        return null;
    }

    @Override
    public String saveOrUpdate(Clase clase) {
        claseRepository.save(clase);
        if (claseRepository.existsById(clase.getId())){
            return ("Clase Guardado Correctamente");
        }
        return ("Hubo un error en el guardado, pruebalo de nuevo");
    }

    @Override
    public String deleteById(Integer id) {
        claseRepository.deleteById(id);
        if (!claseRepository.existsById(id)){
            return ("Clase Se Borro Correctamente");
        }
        return ("Hubo un error en el borrado, pruebalo de nuevo");
    }

    @Override
    public List<Clase> getClase() {
        return claseRepository.findAll();
    }
}
