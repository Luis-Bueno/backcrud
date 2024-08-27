package com.backcrud.backcrud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backcrud.backcrud.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository <Alumno, Integer>{
}
