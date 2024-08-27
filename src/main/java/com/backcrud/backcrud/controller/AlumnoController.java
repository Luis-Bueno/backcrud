package com.backcrud.backcrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backcrud.backcrud.entity.Alumno;
import com.backcrud.backcrud.exeptionHandler.dto.RestResponse;
import com.backcrud.backcrud.service.AlumnoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping ("/api/alumno")
@CrossOrigin(origins = {"http://localhost:4200"})
@RequiredArgsConstructor
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> getAlumnos() {
        return alumnoService.getAlumno();
    }

    @GetMapping("/{id}")
    public Optional<Alumno> getById(@PathVariable("id") Integer id){
        return alumnoService.getAlummnoById(id);
    }

    @PostMapping
    public RestResponse saveOrUpdate(@RequestBody Alumno alumno){
        return(alumnoService.saveOrUpdate(alumno));
    }
    
    @DeleteMapping("{id}")
    public RestResponse delete(@PathVariable("id") Integer id){
        return(alumnoService.deleteById(id));
    }
    
}
