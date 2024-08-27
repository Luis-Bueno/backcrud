package com.backcrud.backcrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backcrud.backcrud.entity.ClaseAlumno;
import com.backcrud.backcrud.exeptionhandler.InternalException;
import com.backcrud.backcrud.exeptionhandler.NotFoundException;
import com.backcrud.backcrud.exeptionhandler.OKException;
import com.backcrud.backcrud.exeptionhandler.dto.RestResponse;
import com.backcrud.backcrud.service.ClaseAlumnoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("/api/clasealumno")
@CrossOrigin(origins = {"http://localhost:4200"})

@RequiredArgsConstructor
public class ClaseAlumnoController {
    
    @Autowired
    ClaseAlumnoService clasealumnoService;

    @GetMapping
    public List<ClaseAlumno> getClaseAlumnos() {
        return clasealumnoService.getClaseAlumno();
    }

    @GetMapping("/{id}")
    public Optional<ClaseAlumno> getById(@PathVariable("id") Integer id) throws NotFoundException{
        return clasealumnoService.getClaseAlummnoById(id);
    }

    @PostMapping
    public RestResponse saveOrUpdate(@RequestBody ClaseAlumno clasealumno) throws OKException, InternalException{
        clasealumnoService.saveOrUpdate(clasealumno);
        return(clasealumnoService.saveOrUpdate(clasealumno));
    }
    
    @DeleteMapping("{id}")
    public RestResponse delete(@PathVariable("id") Integer id) throws OKException, InternalException{
        clasealumnoService.deleteById(id);
        return(clasealumnoService.deleteById(id));
    }

}
