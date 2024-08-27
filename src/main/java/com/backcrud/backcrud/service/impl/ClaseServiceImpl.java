package com.backcrud.backcrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.Clase;
import com.backcrud.backcrud.exeptionHandler.dto.RestResponse;
import com.backcrud.backcrud.repository.ClaseRepository;
import com.backcrud.backcrud.service.ClaseService;

@Service
public class ClaseServiceImpl implements ClaseService{
    String message=("");
    @Autowired
    ClaseRepository claseRepository;

    @Override
    public Optional<Clase> getAlummnoById(Integer id) {
        if  (claseRepository.existsById(id)){
            message = ("La clase se ha encontrado");
            return claseRepository.findById(id);
        }
        message = ("La clase no se ha encontrado");
        return null;
    }

    @Override
    public RestResponse saveOrUpdate(Clase clase) {
        claseRepository.save(clase);
        if (claseRepository.existsById(clase.getId())){
            RestResponse restResponse = RestResponse.builder()
                .message("Guardado Correctamente")
                .build();
            return restResponse;
        }
        RestResponse restResponse = RestResponse.builder()
            .message("Hubo un error en el guardado, pruebalo de nuevo")
            .build();
        return restResponse;
    }

    @Override
    public RestResponse deleteById(Integer id) {
        claseRepository.deleteById(id);
        if (!claseRepository.existsById(id)){
            RestResponse restResponse = RestResponse.builder()
                .message("Se Borro Correctamente")
                .build();
            return restResponse;
        }
        RestResponse restResponse = RestResponse.builder()
            .message("Hubo un error en el borrado, pruebalo de nuevo")
            .build();
        return restResponse;
    }

    @Override
    public List<Clase> getClase() {
        return claseRepository.findAll();
    }
}
