package com.backcrud.backcrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.ClaseAlumno;
import com.backcrud.backcrud.exeptionHandler.dto.RestResponse;
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
            message = ("La Relacion se ha encontrado");
            return claseAlumnoRepository.findById(id);
        }
        message = ("La Relacion no se ha encontrado");
        return null;
    }

    @Override
    public RestResponse saveOrUpdate(ClaseAlumno alumno) {
        claseAlumnoRepository.save(alumno);
        if (claseAlumnoRepository.existsById(alumno.getId())){
                RestResponse restResponse = RestResponse.builder()
                    .message("Guardado Correctamente")
                    .build();
                return restResponse;
            }
            RestResponse restResponse = RestResponse.builder()
                .message("Hubo un error en el guardado, pruebalo de nuevo")
                .build();
            return restResponse;
        }

    @Override
    public RestResponse deleteById(Integer id) {
        claseAlumnoRepository.deleteById(id);
        if (!claseAlumnoRepository.existsById(id)){
            RestResponse restResponse = RestResponse.builder()
                .message("Se Borro Correctamente")
                .build();
            return restResponse;
        }
        RestResponse restResponse = RestResponse.builder()
            .message("Hubo un error en el borrado, pruebalo de nuevo")
            .build();
        return restResponse;
    }

    @Override
    public List<ClaseAlumno> getClaseAlumno() {
        return claseAlumnoRepository.findAll();
    }
}
