package com.backcrud.backcrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.ClaseAlumno;
import com.backcrud.backcrud.exeptionhandler.InternalException;
import com.backcrud.backcrud.exeptionhandler.NotFoundException;
import com.backcrud.backcrud.exeptionhandler.OKException;
import com.backcrud.backcrud.exeptionhandler.dto.RestResponse;
import com.backcrud.backcrud.repository.ClaseAlumnoRepository;
import com.backcrud.backcrud.service.ClaseAlumnoService;

@Service
public class ClaseAlumnoServiceImpl implements ClaseAlumnoService {
    String message=("");
    @Autowired
    ClaseAlumnoRepository claseAlumnoRepository;

    @Override
    public Optional<ClaseAlumno> getClaseAlummnoById(Integer id) throws NotFoundException {
        if  (claseAlumnoRepository.existsById(id)){
            message = ("La Relacion se ha encontrado");
            return claseAlumnoRepository.findById(id);
        }
        throw new NotFoundException("La Relacion no se ha encontrado");
    }

    @Override
    public RestResponse saveOrUpdate(ClaseAlumno alumno) throws OKException, InternalException {
        claseAlumnoRepository.save(alumno);
        if (claseAlumnoRepository.existsById(alumno.getId())){
                    throw new OKException("Guardado Correctamente");
            }
                throw new InternalException("Hubo un error en el guardado, pruebalo de nuevo");
        }

    @Override
    public RestResponse deleteById(Integer id) throws OKException, InternalException {
        claseAlumnoRepository.deleteById(id);
        if (!claseAlumnoRepository.existsById(id)){
                throw new OKException("Se Borro Correctamente");
        }
            throw new InternalException("Hubo un error en el borrado, pruebalo de nuevo");
    }

    @Override
    public List<ClaseAlumno> getClaseAlumno() {
        return claseAlumnoRepository.findAll();
    }
}
