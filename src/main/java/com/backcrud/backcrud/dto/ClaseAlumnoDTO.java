package com.backcrud.backcrud.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClaseAlumnoDTO implements Serializable{
    int clase_id;
    int alumno_id;
}
