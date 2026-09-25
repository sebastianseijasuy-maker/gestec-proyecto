# GesTec – Sistema de Gestión de Recursos Tecnológicos

GesTec es un sistema destinado a la gestión de recursos tecnológicos en
instituciones educativas, permitiendo administrar los recursos y las
operaciones asociadas a su préstamo.

## Integrantes

- Agustín Morales
- Sebastián Seijas

## Requisitos del entorno

- Java JDK 22
- Apache NetBeans 21
- Maven
- MySQL Server
- MySQL Workbench
- JDBC (MySQL Connector/J)

## Preparación de la base de datos

1. Iniciar MySQL Server.
2. Abrir MySQL Workbench.
3. Ejecutar los scripts SQL incluidos en la carpeta `database`.
4. Los scripts permiten crear la base de datos `gestec`, sus tablas,
   relaciones y datos ficticios necesarios para realizar las pruebas.

## Configuración de la conexión

La conexión con la base de datos se realiza mediante JDBC.

Antes de ejecutar la aplicación, verificar en la clase `ConexionBD`
los datos correspondientes a:

- URL de conexión.
- Usuario de MySQL.
- Contraseña de MySQL.

Estos valores deberán ajustarse de acuerdo con la configuración local
de MySQL del equipo donde se ejecute la aplicación.

## Ejecución

1. Abrir Apache NetBeans.
2. Abrir el proyecto ubicado en la carpeta `gestec`.
3. Verificar que MySQL Server se encuentre en ejecución.
4. Verificar la configuración de la conexión a la base de datos.
5. Ejecutar la aplicación desde NetBeans.
6. Se mostrará la pantalla principal de GesTec.

## Recorrido funcional implementado

El recorrido funcional seleccionado corresponde al registro de un préstamo.

Para reproducirlo:

1. Ingresar a la opción `Préstamo` desde la pantalla principal.
2. Buscar una persona habilitada mediante su documento.
3. Buscar y seleccionar un recurso tecnológico disponible.
4. Ingresar la fecha prevista de devolución.
5. Registrar el préstamo.
6. El sistema almacena el préstamo en la base de datos y actualiza
   la disponibilidad del recurso.

## CRUD de recursos tecnológicos

Desde la opción `Recursos` se encuentra implementado el CRUD de
Recurso Tecnológico, que permite:

- Registrar un nuevo recurso.
- Consultar recursos por nombre.
- Modificar los datos de un recurso.
- Realizar la baja lógica de un recurso.

Las operaciones se realizan mediante la interfaz gráfica y persisten
los cambios en la base de datos.

## Pruebas

Se realizaron casos de prueba sobre las funcionalidades implementadas,
incluyendo el alta, consulta, modificación y baja lógica de recursos
tecnológicos.

Los resultados de las pruebas y su vinculación con los requisitos
se encuentran documentados en la documentación correspondiente a
la tercera entrega.

## Estructura general

El sistema está organizado mediante una arquitectura en capas:

- Presentación: interfaces gráficas desarrolladas con Java Swing.
- Negocio: clases que representan las entidades del dominio.
- Persistencia: clases DAO responsables del acceso a los datos mediante JDBC.
- Base de datos: MySQL Server.

La documentación y los artefactos de diseño se encuentran en la
carpeta `docs`, mientras que los scripts de base de datos se encuentran
en la carpeta `database`.
