package com.backcrud.backcrud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backcrud.backcrud.entity.ClaseAlumno;

@Repository
public interface ClaseAlumnoRepository extends JpaRepository <ClaseAlumno, Integer> {

    @Query("SELECT c FROM ClaseAlumno c WHERE c.alumno.id=:id")
    Optional<ClaseAlumno> existsByAlumnoId(@Param(value = "id") Integer id);

    @Query("SELECT c FROM ClaseAlumno c WHERE c.clase.id=:id")
    Optional<ClaseAlumno> existsByClaseId(@Param(value = "id") Integer id);

}
