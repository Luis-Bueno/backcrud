package com.backcrud.backcrud.controller;

import static org.mockito.Mockito.atLeast;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.backcrud.backcrud.entity.Alumno;
import com.backcrud.backcrud.service.AlumnoService;

public class AlumnoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlumnoService alumnoService;

    private Alumno alumno;

    @BeforeEach
    void setUp(){
        alumno = Alumno.builder()
            .id(1)
            .nombre("Luis Bueno")
            .build();
    }

    @Test
    void testDelete() {

    }

    @Test
    void testGetAlumnos() {

    }

    @Test
    void testGetById() {

    }

    @Test
    void testSaveOrUpdate() {
        Alumno postAlumno = Alumno.builder()
            .nombre("Juan Torres")
            .build();
        Mockito.when(alumnoService.saveOrUpdate(postAlumno).getMessage());

    }
}
