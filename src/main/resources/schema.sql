CREATE TABLE alumno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    estado VARCHAR(10) NOT NULL CHECK (estado IN ('activo', 'inactivo')),
    edad INT NOT NULL CHECK (edad > 0)
);
