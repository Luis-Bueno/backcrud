package com.backcrud.backcrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
}
