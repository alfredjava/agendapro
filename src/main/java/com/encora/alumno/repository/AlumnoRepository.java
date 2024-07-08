package com.encora.alumno.repository;

import com.encora.alumno.model.Alumno;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface AlumnoRepository extends ReactiveCrudRepository<Alumno, Long> {
    Flux<Alumno> findAllByEstado(String estado);
}
