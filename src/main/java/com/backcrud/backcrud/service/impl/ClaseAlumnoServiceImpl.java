package com.backcrud.backcrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.ClaseAlumno;
import com.backcrud.backcrud.repository.ClaseAlumnoRepository;
import com.backcrud.backcrud.service.ClaseAlumnoService;

@Service
public class ClaseAlumnoServiceImpl implements ClaseAlumnoService {
    String message=("");
    @Autowired
    ClaseAlumnoRepository claseAlumnoRepository;

    @Override
    public Optional<ClaseAlumno> getClaseAlummnoById(Integer id) {
        if  (claseAlumnoRepository.existsById(id)){
            message = ("El Alummno se ha encontrado");
            return claseAlumnoRepository.findById(id);
        }
        message = ("El Alummno no se ha encontrado");
        return null;
    }

    @Override
    public String saveOrUpdate(ClaseAlumno alumno) {
        claseAlumnoRepository.save(alumno);
        if (claseAlumnoRepository.existsById(alumno.getId())){
            return ("ClaseAlumno Guardado Correctamente");
        }
        return ("Hubo un error en el guardado, pruebalo de nuevo");
    }

    @Override
    public String deleteById(Integer id) {
        claseAlumnoRepository.deleteById(id);
        if (!claseAlumnoRepository.existsById(id)){
            return ("ClaseAlumno Se Borro Correctamente");
        }
        return ("Hubo un error en el borrado, pruebalo de nuevo");
    }

    @Override
    public List<ClaseAlumno> getClaseAlumno() {
        return claseAlumnoRepository.findAll();
    }
}
