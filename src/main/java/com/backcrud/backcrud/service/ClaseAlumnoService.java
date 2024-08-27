package com.backcrud.backcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.ClaseAlumno;
import com.backcrud.backcrud.exeptionhandler.InternalException;
import com.backcrud.backcrud.exeptionhandler.NotFoundException;
import com.backcrud.backcrud.exeptionhandler.OKException;
import com.backcrud.backcrud.exeptionhandler.dto.RestResponse;

@Service
public interface ClaseAlumnoService {
    public Optional<ClaseAlumno> getClaseAlummnoById(Integer id) throws NotFoundException;
    public RestResponse saveOrUpdate(ClaseAlumno claseAlumno) throws OKException, InternalException;
    public RestResponse deleteById(Integer id) throws OKException, InternalException;
    public List<ClaseAlumno> getClaseAlumno();
}
