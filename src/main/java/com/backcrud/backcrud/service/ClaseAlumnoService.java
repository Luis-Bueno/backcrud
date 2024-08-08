package com.backcrud.backcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.ClaseAlumno;

@Service
public interface ClaseAlumnoService {
    public Optional<ClaseAlumno> getClaseAlummnoById(Integer id);
    public String saveOrUpdate(ClaseAlumno claseAlumno);
    public String deleteById(Integer id);
    public List<ClaseAlumno> getClaseAlumno();
}
