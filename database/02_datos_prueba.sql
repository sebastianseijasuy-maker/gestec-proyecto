use gestec;

INSERT INTO persona (documento, nombre, apellido, telefono)
VALUES 	
	('41231235', 'Sebastian', 'Seijas', '091007177'),
	('41243244', 'Agustin', 'Morales', '098675456'),
	('34345677', 'Ana', 'Martinez', '098789564'),
    ('52643245', 'Carlos', 'Perez','');
    
INSERT INTO usuario (id_persona, nombre_usuario, password_hash)
VALUES
	(1, 'sseba', 'clave de prueba'),
    (2, 'agustinm', 'clave de prueba');
       
INSERT INTO persona_habilitada (id_persona, tipo_persona, baja_logica)
VALUES
	(3, 'Docente', 0),
    (4, 'Funcionario', 0);
    
INSERT INTO recurso_tecnologico(codigo_inv, nombre, categoria, condicion, disponibilidad, baja_logica)
VALUES 
	('001', 'notebook electra', 'notebook', 'operativo', 1, 0),
    ('002', 'mouse hp', 'perifericos', 'operativo', 1, 0),
    ('003', 'hdmi 3m', 'accesorios', 'operativo', 1, 0);
    
    
INSERT INTO recurso_tecnologico
(codigo_inv, nombre, categoria, condicion, disponibilidad, baja_logica)
VALUES
('004', 'notebook electra', 'notebook', 'Operativo', TRUE, FALSE),
('005', 'notebook electra', 'notebook', 'Operativo', TRUE, FALSE),
('006', 'notebook sirio', 'notebook', 'Operativo', TRUE, FALSE), 
('007', 'notebook sirio', 'notebook', 'Operativo', TRUE, FALSE),
('008', 'mouse Logitech', 'perifericos', 'Operativo', TRUE, FALSE);


