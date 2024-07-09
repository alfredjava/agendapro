package com.encora.alumno.model;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AlumnoRequest {
    private String id;
    @Pattern(regexp = "^[A-Za-z]{1,200}$", message = "El nombre solo debe contener letras y tener una longitud máxima de 200 caracteres")
    private String nombre;
    @Pattern(regexp = "^[A-Za-z]{1,200}$", message = "El apellido solo debe contener letras y tener una longitud máxima de 200 caracteres")
    private String apellido;
    @Pattern(regexp = "^(activo|inactivo)$", message = "El estado debe ser 'activo' o 'inactivo'")
    private String estado;
    @Pattern(regexp = "^([6-9]|[1-5][0-9]|65)$", message = "La edad debe ser un número entre 6 y 65")
    private String edad;

}
