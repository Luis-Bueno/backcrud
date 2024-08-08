package com.backcrud.backcrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.Alumno;
import com.backcrud.backcrud.repository.AlumnoRepository;
import com.backcrud.backcrud.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    String message=("");
    @Autowired
    AlumnoRepository alumnoRepository;

    @Override
    public Optional<Alumno> getAlummnoById(Integer id) {
        if  (alumnoRepository.existsById(id)){
            message = ("El Alummno se ha encontrado");
            return alumnoRepository.findById(id);
        }
        message = ("El Alummno no se ha encontrado");
        return null;
    }

    @Override
    public String saveOrUpdate(Alumno alumno) {
        alumnoRepository.save(alumno);
        if (alumnoRepository.existsById(alumno.getId())){
            return ("Alumno Guardado Correctamente");
        }
        return ("Hubo un error en el guardado, pruebalo de nuevo");
    }

    @Override
    public String deleteById(Integer id) {
        alumnoRepository.deleteById(id);
        if (!alumnoRepository.existsById(id)){
            return ("Alumno Se Borro Correctamente");
        }
        return ("Hubo un error en el borrado, pruebalo de nuevo");
    }

    @Override
    public List<Alumno> getAlumno() {
        return alumnoRepository.findAll();
    }
    
}
