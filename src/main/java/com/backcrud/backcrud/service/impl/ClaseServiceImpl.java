package com.backcrud.backcrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.Clase;
import com.backcrud.backcrud.exeptionhandler.ConflictException;
import com.backcrud.backcrud.exeptionhandler.InternalException;
import com.backcrud.backcrud.exeptionhandler.NotFoundException;
import com.backcrud.backcrud.exeptionhandler.OKException;
import com.backcrud.backcrud.exeptionhandler.dto.RestResponse;
import com.backcrud.backcrud.repository.ClaseAlumnoRepository;
import com.backcrud.backcrud.repository.ClaseRepository;
import com.backcrud.backcrud.service.ClaseService;

@Service
public class ClaseServiceImpl implements ClaseService{
    String message=("");
    @Autowired
    ClaseRepository claseRepository;
    @Autowired
    ClaseAlumnoRepository claseAlumnoRepository;

    @Override
    public Optional<Clase> getAlummnoById(Integer id) throws NotFoundException {
        if  (claseRepository.existsById(id)){
            message = ("La clase se ha encontrado");
            return claseRepository.findById(id);
        }
        throw new NotFoundException("La clase no se ha encontrado");
    }

    @Override
    public RestResponse saveOrUpdate(Clase clase) throws OKException, InternalException {
        claseRepository.save(clase);
        if (claseRepository.existsById(clase.getId())){
                throw new OKException("Guardado Correctamente");
        }
            throw new InternalException("Hubo un error en el guardado, pruebalo de nuevo");
    }

    @Override
    public RestResponse deleteById(Integer id) throws ConflictException, OKException, InternalException {
        if (claseAlumnoRepository.existsByClaseId(id).isPresent()) {
            throw new ConflictException("Primero necesita eliminar las relaciones de ClaseAlumno");
        }
        claseRepository.deleteById(id);
        if (!claseRepository.existsById(id)) {
            throw new OKException("El Alumno se Borro exitosamente!");
        } else {
            throw new InternalException("Hubo un Error al borrar, Intentalo de nuevo");
        }
    }

    @Override
    public List<Clase> getClase() {
        return claseRepository.findAll();
    }
}
