package com.backcrud.backcrud.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@Table (name = "ctl_clasealumno")
public class ClaseAlumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne( fetch = FetchType.EAGER, optional = false )
    @JoinColumn( name = "clase_id", nullable = false )
    @OnDelete( action = OnDeleteAction.CASCADE )
    private Clase clase;

    @ManyToOne( fetch = FetchType.EAGER, optional = false )
    @JoinColumn( name = "alumno_id", nullable = false )
    @OnDelete( action = OnDeleteAction.CASCADE )
    private Alumno alumno;
    
}
