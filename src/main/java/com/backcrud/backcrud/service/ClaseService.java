package com.backcrud.backcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.Clase;
import com.backcrud.backcrud.exeptionHandler.dto.RestResponse;

@Service
public interface ClaseService {

    public Optional<Clase> getAlummnoById(Integer id);
    public RestResponse saveOrUpdate(Clase clase);
    public RestResponse deleteById(Integer id);
    public List<Clase> getClase();
    
}
