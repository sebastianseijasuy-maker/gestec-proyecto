USE gestec;


INSERT INTO persona
(documento, nombre, apellido, telefono)
VALUES
    ('43373355', 'Sebastian', 'Seijas', '091007177'),
    ('41243244', 'Agustin', 'Morales', '098675456'),
    ('11111111', 'Ana', 'Martinez', '098789564'),
    ('22222222', 'Carlos', 'Perez', '');

INSERT INTO persona_habilitada
(id_persona, tipo_persona, baja_logica)
SELECT
    id_persona,
    'Docente',
    FALSE
FROM persona
WHERE documento = '11111111';

INSERT INTO persona_habilitada
(id_persona, tipo_persona, baja_logica)
SELECT
    id_persona,
    'Funcionario',
    FALSE
FROM persona
WHERE documento = '22222222';

INSERT INTO recurso_tecnologico
(codigo_inv, nombre, categoria, condicion,
 disponibilidad, baja_logica)
VALUES
    ('001', 'notebook electra', 'notebook',
     'Operativo', TRUE, FALSE),

    ('002', 'mouse hp', 'perifericos',
     'Operativo', TRUE, FALSE),

    ('003', 'hdmi 3m', 'accesorios',
     'Operativo', TRUE, FALSE),

    ('004', 'notebook electra', 'notebook',
     'Operativo', TRUE, FALSE),

    ('005', 'notebook electra', 'notebook',
     'Operativo', TRUE, FALSE),

    ('006', 'notebook sirio', 'notebook',
     'Operativo', TRUE, FALSE),

    ('007', 'notebook sirio', 'notebook',
     'Operativo', TRUE, FALSE),

    ('008', 'mouse Logitech', 'perifericos',
     'Operativo', TRUE, FALSE);

SELECT * FROM persona;

SELECT
    p.documento,
    p.nombre,
    p.apellido,
    ph.tipo_persona,
    ph.baja_logica
FROM persona_habilitada ph
INNER JOIN persona p
    ON ph.id_persona = p.id_persona;

SELECT * FROM recurso_tecnologico;