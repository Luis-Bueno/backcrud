package com.backcrud.backcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.ClaseAlumno;
import com.backcrud.backcrud.exeptionHandler.dto.RestResponse;

@Service
public interface ClaseAlumnoService {
    public Optional<ClaseAlumno> getClaseAlummnoById(Integer id);
    public RestResponse saveOrUpdate(ClaseAlumno claseAlumno);
    public RestResponse deleteById(Integer id);
    public List<ClaseAlumno> getClaseAlumno();
}
