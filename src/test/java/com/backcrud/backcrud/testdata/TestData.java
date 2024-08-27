package com.backcrud.backcrud.testdata;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.backcrud.backcrud.entity.Alumno;
import com.backcrud.backcrud.entity.Clase;

public class TestData {        
    
    public static final List<Alumno> ALUMNOS = Arrays.asList(
        new Alumno(1, "Pancho Perez"),
        new Alumno(2, "Luis Bueno"));

    public static final Optional<Alumno> ALUMNO_001 = Optional.of((new Alumno(1, "Pancho Perez")));
    public static final Optional<Alumno> ALUMNO_002 = Optional.of(new Alumno(2, "Luis Bueno"));
    public static final Clase Clase_001 = (new Clase(2, "Quimica"));
    public static final Clase Clase_002 = (new Clase(2, "Mecanica"));

}
