package com.encora.alumno.controller;

import com.encora.alumno.model.AlumnoRequest;
import com.encora.alumno.repository.Alumno;
import com.encora.alumno.service.AlumnoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private static final Logger logger = LoggerFactory.getLogger(AlumnoController.class);

    @Autowired
    private AlumnoService service;

    @GetMapping("/activos")
    public Flux<AlumnoRequest> getAllAlumnosActivos() {
        return service.getAllAlumnosActivos();
    }

    @PostMapping
    public Mono<ResponseEntity<Void>> saveAlumno(@Valid @RequestBody AlumnoRequest alumno) {
        return service.saveAlumnoFromRequest(alumno)
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.CREATED)))
                .onErrorResume(DuplicateKeyException.class, e -> {
                    logger.error("Conflicto: {}", e.getMessage());
                    return Mono.just(new ResponseEntity<>(HttpStatus.CONFLICT));
                })
                .onErrorResume(MethodArgumentNotValidException.class, e -> {
                    logger.error("Error de validación: {}", e.getMessage());
                    return Mono.just(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
                })
                .onErrorResume(TransientDataAccessResourceException.class, e -> {
                    logger.error("Error de acceso a datos: {}", e.getMessage());
                    return Mono.just(new ResponseEntity<>(HttpStatus.CONFLICT));
                });
    }
}
