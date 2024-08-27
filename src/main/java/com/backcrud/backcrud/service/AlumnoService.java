package com.backcrud.backcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.Alumno;
import com.backcrud.backcrud.exeptionHandler.dto.RestResponse;

@Service
public interface AlumnoService {
    public Optional<Alumno> getAlummnoById(Integer id);
    public RestResponse saveOrUpdate(Alumno alumno);
    public RestResponse deleteById(Integer id);
    public List<Alumno> getAlumno();
}
