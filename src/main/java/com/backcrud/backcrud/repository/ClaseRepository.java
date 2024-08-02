package com.backcrud.backcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backcrud.backcrud.entity.Clase;

public interface ClaseRepository extends JpaRepository <Clase, Integer> {
    
}
