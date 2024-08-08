package com.backcrud.backcrud.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.backcrud.backcrud.entity.Alumno;
import com.backcrud.backcrud.repository.AlumnoRepository;

public class AlumnoServiceImplTest {

    @Mock
    private AlumnoRepository alumnoRepository;

    @InjectMocks
    private AlumnoServiceImpl alumnoServiceImpl;

    private Alumno alumno;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(alumnoRepository);

        alumno = new Alumno();
        alumno.setId(1);
        alumno.setNombre(new String("Humberto"));

    }

    @Test
    void testDeleteById() {

    }

    @Test
    void testGetAlummnoById() {

    }

    @Test
    void testGetAlumno() {
        when(alumnoRepository.findAll()).thenReturn(Arrays.asList(alumno));
        assertNotNull(alumnoServiceImpl.getAlumno());
    }

    @Test
    void testSaveOrUpdate() {

    }
}
