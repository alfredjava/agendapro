package com.encora.alumno.service;

import com.encora.alumno.model.Alumno;
import com.encora.alumno.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository repository;

    public Flux<Alumno> getAllAlumnosActivos() {
        return repository.findAllByEstado("activo");
    }

    public Mono<Alumno> saveAlumno(Alumno alumno) {
        // Check if the ID is null, if so, the database will generate it
        if (alumno.getId() != null) {
            return repository.existsById(alumno.getId())
                    .flatMap(exists -> {
                        if (exists) {
                            return Mono.error(new DuplicateKeyException("El ID ya existe"));
                        } else {
                            return repository.save(alumno);
                        }
                    });
        } else {
            return repository.save(alumno);
        }
    }
}
