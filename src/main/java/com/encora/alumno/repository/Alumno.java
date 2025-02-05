package com.encora.alumno.repository;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("alumno")
@Data
public class Alumno {
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private String estado;
    private int edad;

    // Getters and Setters
}
