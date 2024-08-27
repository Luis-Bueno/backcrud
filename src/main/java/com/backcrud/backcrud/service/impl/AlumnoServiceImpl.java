package com.backcrud.backcrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backcrud.backcrud.dto.UserDTO;
import com.backcrud.backcrud.entity.Alumno;
import com.backcrud.backcrud.exeptionHandler.dto.RestResponse;
import com.backcrud.backcrud.repository.AlumnoRepository;
import com.backcrud.backcrud.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository;
    String message; 
    

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
    public RestResponse saveOrUpdate(Alumno alumno) {
        alumnoRepository.save(alumno);
        if (alumnoRepository.existsById(alumno.getId())){
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
        alumnoRepository.deleteById(id);
        if (!alumnoRepository.existsById(id)){
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
    public List<Alumno> getAlumno() {
        return alumnoRepository.findAll();
    }
    
}
