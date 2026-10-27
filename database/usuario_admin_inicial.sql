-- GESTEC - Usuario administrador inicial
-- Ejecutar una sola vez sobre la base gestec.
-- Credenciales temporales: admin / admin

USE gestec;

START TRANSACTION;

INSERT INTO persona (documento, nombre, apellido, telefono)
VALUES ('GESTEC-ADMIN', 'Administrador', 'GESTEC', NULL);

INSERT INTO usuario (id_persona, nombre_usuario, password_hash)
SELECT id_persona, 'admin', 'PBKDF2-SHA256$600000$UyudAa0Z5ShAX7KQYK7/Gg==$ILq3LhrjHsUhX5BUa5G7ZcL7+pVJ0InxneepMQVURKk='
FROM persona
WHERE documento = 'GESTEC-ADMIN';

COMMIT;