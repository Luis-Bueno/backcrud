package com.backcrud.backcrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.backcrud.backcrud.entity.Alumno;
import com.backcrud.backcrud.exeptionhandler.NotFoundException;
import com.backcrud.backcrud.exeptionhandler.OKException;
import com.backcrud.backcrud.repository.AlumnoRepository;
import com.backcrud.backcrud.service.AlumnoService;
import com.backcrud.backcrud.service.impl.AlumnoServiceImpl;
import com.backcrud.backcrud.testdata.TestData;

@SpringBootTest
class BackcrudApplicationTests {

	AlumnoRepository repository;
    AlumnoService service;

	@BeforeEach
    void setUp(){
        repository = Mockito.mock(AlumnoRepository.class);
        service = Mockito.mock(AlumnoServiceImpl.class);
    }

    @Test
    void testGetAlumnoById() throws NotFoundException, OKException {
		
        when(repository.findAll()).thenReturn(TestData.ALUMNOS);
        Optional<Alumno> alumno = service.getAlumnoById(1);
        System.err.println(alumno);

        assertTrue(alumno.isPresent());
        assertEquals(1, alumno.get().getId());
        assertEquals("Pancho Perez", alumno.get().getNombre());
    }

}
