CREATE DATABASE IF NOT EXISTS gestec;
use gestec;

CREATE TABLE persona (
	id_persona INT PRIMARY KEY AUTO_INCREMENT,
	documento VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    telefono VARCHAR(20) NULL
);

CREATE TABLE usuario (
	id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    id_persona INT NOT NULL UNIQUE,
    nombre_usuario VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona)
    );
    
CREATE TABLE persona_habilitada (
    id_persona_hab INT PRIMARY KEY AUTO_INCREMENT,
    id_persona INT NOT NULL UNIQUE,
    tipo_persona VARCHAR(30) NOT NULL CHECK (tipo_persona IN('Estudiante', 'Docente', 'Funcionario')),
    baja_logica BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona)
    );
    
CREATE TABLE recurso_tecnologico (
	id_recurso INT PRIMARY KEY AUTO_INCREMENT,
    codigo_inv VARCHAR(50) NOT NULL UNIQUE,
	nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    condicion VARCHAR(50) NOT NULL DEFAULT 'operativo',
    disponibilidad BOOLEAN NOT NULL DEFAULT TRUE,
	baja_logica BOOLEAN NOT NULL DEFAULT FALSE
    );
        
CREATE TABLE prestamo (
	id_prestamo INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT NOT NULL,
    id_persona_hab INT NOT NULL,
    fecha_entrega DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_prev_dev DATETIME NOT NULL,
    fecha_devolucion_real DATETIME NULL,
    estado_prestamo VARCHAR(30) NOT NULL DEFAULT'Activo' CHECK (estado_prestamo IN('Activo', 'Devuelto', 'Vencido')),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_persona_hab) REFERENCES persona_habilitada(id_persona_hab)
        
);
        
CREATE TABLE prestamo_recurso (
	id_prestamo INT NOT NULL,
    id_recurso INT NOT NULL,
    PRIMARY KEY (id_prestamo, id_recurso),
    FOREIGN KEY (id_prestamo) REFERENCES prestamo(id_prestamo),
    FOREIGN KEY (id_recurso) REFERENCES recurso_tecnologico(id_recurso)
);
    
CREATE TABLE reserva (
	id_reserva INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT NOT NULL,
    id_persona_hab INT NOT NULL,
    fecha_reserva DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_prev_uso DATETIME NOT NULL,
    estado_reserva VARCHAR(30) NOT NULL DEFAULT 'Confirmada' CHECK(estado_reserva IN('Confirmada', 'Utilizada', 'Cancelada')),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_persona_hab) REFERENCES persona_habilitada(id_persona_hab)
    );
    
CREATE TABLE reserva_recurso (
	id_recurso INT NOT NULL,
    id_reserva INT NOT NULL,
    PRIMARY KEY (id_reserva, id_recurso),
    FOREIGN KEY (id_recurso) REFERENCES recurso_tecnologico(id_recurso),
    FOREIGN key (id_reserva) REFERENCES reserva(id_reserva)
    );

CREATE TABLE incidencia (
    id_incidencia INT PRIMARY KEY AUTO_INCREMENT,
    tipo_incidencia VARCHAR(50) NOT NULL CHECK (tipo_incidencia IN('Daño', 'Perdida', 'Falla')),
    descripcion TEXT NOT NULL,
    id_recurso INT NOT NULL,
    FOREIGN KEY (id_recurso) REFERENCES recurso_tecnologico(id_recurso)
    );
    
CREATE TABLE mantenimiento (
	id_mantenimiento INT PRIMARY KEY AUTO_INCREMENT,
    fecha_inicio DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    detalle_tecnico TEXT NOT NULL,
    id_recurso INT NOT NULL,
    foreign key (id_recurso) references recurso_tecnologico(id_recurso)
    );