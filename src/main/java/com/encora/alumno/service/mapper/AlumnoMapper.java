package com.encora.alumno.service.mapper;

import com.encora.alumno.model.AlumnoRequest;
import com.encora.alumno.repository.Alumno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlumnoMapper {

    AlumnoMapper INSTANCE = Mappers.getMapper(AlumnoMapper.class);

    @Mapping(target = "id", ignore = true) // Ignora el id ya que se genera automáticamente o se establece en otro lugar
    Alumno mapToAlumno(AlumnoRequest alumnoRequest);


    // Método para mapear de Alumno a AlumnoRequest
    AlumnoRequest mapToAlumnoRequest(Alumno alumno);
}
