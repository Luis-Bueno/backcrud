package com.backcrud.backcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.Clase;
import com.backcrud.backcrud.exeptionhandler.ConflictException;
import com.backcrud.backcrud.exeptionhandler.InternalException;
import com.backcrud.backcrud.exeptionhandler.NotFoundException;
import com.backcrud.backcrud.exeptionhandler.OKException;
import com.backcrud.backcrud.exeptionhandler.dto.RestResponse;

@Service
public interface ClaseService {

    public Optional<Clase> getAlummnoById(Integer id) throws NotFoundException;
    public RestResponse saveOrUpdate(Clase clase) throws OKException, InternalException;
    public RestResponse deleteById(Integer id) throws ConflictException, OKException, InternalException;
    public List<Clase> getClase();
    
}
