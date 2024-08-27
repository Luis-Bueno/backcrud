package com.backcrud.backcrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.Alumno;
import com.backcrud.backcrud.exeptionhandler.ConflictException;
import com.backcrud.backcrud.exeptionhandler.InternalException;
import com.backcrud.backcrud.exeptionhandler.NotFoundException;
import com.backcrud.backcrud.exeptionhandler.OKException;
import com.backcrud.backcrud.exeptionhandler.dto.RestResponse;
import com.backcrud.backcrud.repository.AlumnoRepository;
import com.backcrud.backcrud.repository.ClaseAlumnoRepository;
import com.backcrud.backcrud.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository;
    @Autowired
    ClaseAlumnoRepository claseAlumnoRepository;
    String message;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository){
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public Optional<Alumno> getAlumnoById(Integer id) throws NotFoundException, OKException {
        if (alumnoRepository.existsById(id)) {
            message = ("El Alummno se ha encontrado");
            return alumnoRepository.findById(id);
        } else {
            throw new NotFoundException("El Alumno no se ha encontrado");
        }
    }

    @Override
    public RestResponse saveOrUpdate(Alumno alumno) throws InternalException, OKException {
        alumnoRepository.save(alumno);
        if (alumnoRepository.existsById(alumno.getId())) {
            throw new OKException("Guardado Correctamente");
        }
        throw new InternalException("Hubo un error en el guardado, pruebalo de nuevo");
    }

    @Override
    public RestResponse deleteById(Integer id) throws ConflictException, OKException, InternalException {

        if (claseAlumnoRepository.existsByAlumnoId(id).isPresent()) {
            throw new ConflictException("Primero necesita eliminar las relaciones de ClaseAlumno");
        }
        alumnoRepository.deleteById(id);
        if (!alumnoRepository.existsById(id)) {
            throw new OKException("El Alumno se Borro exitosamente!");
        } else {
            throw new InternalException("Hubo un Error al borrar, Intentalo de nuevo");
        }
    }

    @Override
    public List<Alumno> getAlumno() {
        return alumnoRepository.findAll();
    }

}
