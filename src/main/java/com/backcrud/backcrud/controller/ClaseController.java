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

import com.backcrud.backcrud.entity.Clase;
import com.backcrud.backcrud.service.ClaseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("/api/clase")
@CrossOrigin(origins = {"http://localhost:4200"})
@RequiredArgsConstructor
public class ClaseController {
    
    @Autowired
    ClaseService claseService;

    @GetMapping
    public List<Clase> getClases() {
        return claseService.getClase();
    }

    @GetMapping("/{id}")
    public Optional<Clase> getById(@PathVariable("id") Integer id){
        return claseService.getAlummnoById(id);
    }

    @PostMapping
    public String saveOrUpdate(@RequestBody Clase clase){
        claseService.saveOrUpdate(clase);
        return(claseService.saveOrUpdate(clase));
    }
    
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Integer id){
        claseService.deleteById(id);
        return(claseService.deleteById(id));
    }

}
