package com.backcrud.backcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.Alumno;
import com.backcrud.backcrud.exeptionhandler.ConflictException;
import com.backcrud.backcrud.exeptionhandler.InternalException;
import com.backcrud.backcrud.exeptionhandler.NotFoundException;
import com.backcrud.backcrud.exeptionhandler.OKException;
import com.backcrud.backcrud.exeptionhandler.dto.RestResponse;

@Service
public interface AlumnoService {
    public Optional<Alumno> getAlumnoById(Integer id) throws NotFoundException, OKException;
    public RestResponse saveOrUpdate(Alumno alumno) throws InternalException, OKException;
    public RestResponse deleteById(Integer id) throws ConflictException, OKException, InternalException;
    public List<Alumno> getAlumno();
}
