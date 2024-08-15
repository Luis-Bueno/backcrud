package com.backcrud.backcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.backcrud.backcrud.entity.Alumno;

import com.backcrud.backcrud.entity.Alumno;

@Service
public interface AlumnoService {
    public Optional<Alumno> getAlummnoById(Integer id);
    public String saveOrUpdate(Alumno alumno);
    public String deleteById(Integer id);
    public List<Alumno> getAlumno();
}
