package com.encora.alumno.model;

import lombok.Data;

@Data
public class AlumnoRequest {
    private String id;
    private String nombre;
    private String apellido;
    private String estado;
    private int edad;

}
