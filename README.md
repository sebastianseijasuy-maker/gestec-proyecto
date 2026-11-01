# GesTec – Sistema de Gestión de Recursos Tecnológicos

GesTec es un sistema de escritorio desarrollado en Java, destinado a la gestión de recursos tecnológicos en instituciones educativas. Permite administrar el inventario, las personas habilitadas, los préstamos y devoluciones, las incidencias, los mantenimientos y los usuarios responsables de la gestión.

## Integrantes

- Agustín Morales
- Sebastián Seijas

## Requisitos del entorno

- Java JDK 22
- Apache NetBeans 21
- Maven (verificar según la configuración del proyecto)
- MySQL Server
- MySQL Workbench
- JDBC (MySQL Connector/J)

## Preparación de la base de datos

1. Iniciar MySQL Server.
2. Abrir MySQL Workbench.
3. Ejecutar el script `01_crear_bd.sql`, ubicado en la carpeta `database`, para crear la base de datos `gestec` y sus tablas.
4. Ejecutar el script `02_datos_prueba.sql` para incorporar los datos ficticios necesarios para las pruebas.
5. Verificar que la base de datos se haya creado correctamente.

## Configuración de la conexión

La comunicación entre la aplicación y MySQL se realiza mediante JDBC.

Antes de ejecutar GesTec, verificar en la clase `ConexionBD` los siguientes parámetros:

- URL de conexión a la base de datos `gestec`.
- Usuario de MySQL.
- Contraseña de MySQL.

Estos valores deberán ajustarse a la configuración local del equipo donde se ejecute la aplicación.

## Ejecución del sistema

1. Clonar o descargar el repositorio.
2. Abrir Apache NetBeans.
3. Abrir el proyecto ubicado en la carpeta `gestec`.
4. Verificar que se encuentre configurado el JDK y disponible el controlador JDBC.
5. Iniciar MySQL Server y comprobar la conexión con la base de datos.
6. Ejecutar la aplicación desde NetBeans.
7. Ingresar las credenciales de un usuario autorizado en la pantalla de inicio de sesión.
8. Acceder a las funcionalidades desde la pantalla principal de GesTec.

## Funcionalidades implementadas

### Gestión de recursos tecnológicos

- Registrar nuevos recursos.
- Consultar recursos por nombre.
- Modificar información de recursos.
- Realizar bajas lógicas.
- Consultar su condición y disponibilidad.

La consulta de recursos presenta una implementación parcial respecto del requisito original, debido a que no incorpora el historial de modificaciones.

### Gestión de personas habilitadas

- Registrar personas.
- Consultar personas por documento.
- Modificar sus datos.
- Realizar bajas lógicas.

### Gestión de préstamos y devoluciones

- Registrar préstamos a personas habilitadas.
- Seleccionar recursos disponibles.
- Establecer fechas previstas de devolución.
- Consultar préstamos registrados.
- Registrar devoluciones.
- Identificar préstamos vencidos.

### Gestión de incidencias y mantenimientos

- Registrar incidencias asociadas a recursos tecnológicos.
- Registrar mantenimientos.
- Consultar información de mantenimientos registrados.

### Gestión de usuarios

- Autenticación mediante credenciales.
- Cierre de sesión.
- Registro de usuarios POITE.

## Recorrido funcional: registro de préstamo

Para comprobar una de las principales funcionalidades del sistema:

1. Iniciar sesión con un usuario autorizado.
2. Seleccionar la opción `Préstamo` desde la pantalla principal.
3. Ingresar a `Registrar préstamo`.
4. Buscar una persona habilitada mediante su documento.
5. Buscar y seleccionar un recurso tecnológico disponible.
6. Ingresar una fecha prevista de devolución válida.
7. Confirmar el registro.
8. Verificar que el préstamo se haya registrado y que se haya actualizado la disponibilidad del recurso.

## Pruebas realizadas

Se ejecutaron 17 casos de prueba vinculados con los requisitos funcionales implementados.

Las verificaciones comprendieron la gestión de recursos tecnológicos, personas habilitadas, préstamos, devoluciones, incidencias, mantenimientos, autenticación, cierre de sesión y registro de usuarios.

Los 17 casos finalizaron satisfactoriamente.

Durante las pruebas se detectó una incompatibilidad entre las opciones de tipo de incidencia de la interfaz y una restricción de la base de datos. El problema fue corregido y la prueba correspondiente se ejecutó nuevamente con resultado satisfactorio.

Los resultados detallados se encuentran documentados en el plan de pruebas de la entrega final.

## Alcance y limitaciones

Permanecen pendientes las funcionalidades correspondientes a reservas, retiro y reincorporación de recursos y generación de reportes.

Las funcionalidades de gestión de kits fueron retiradas del alcance de esta entrega.

## Estructura general

GesTec se organiza mediante una arquitectura en capas:

- **Presentación:** interfaces gráficas desarrolladas con Java Swing.
- **Negocio:** entidades del dominio, servicios, clases de gestión y validaciones de las operaciones.
- **Persistencia:** clases DAO responsables del acceso a los datos mediante JDBC.
- **Base de datos:** MySQL, donde se almacenan los registros y se aplican las restricciones de integridad.

La documentación y los artefactos de diseño se encuentran en la carpeta `docs`, mientras que los scripts de base de datos se encuentran en `database`.

## Control de versiones

El desarrollo se administra
