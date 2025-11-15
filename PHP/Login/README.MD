SuperDuperApp – Gestión de Tareas con Login

Aplicación web sencilla en PHP para gestionar tareas con sistema de
registro y login de usuarios, usando MySQL y Bootstrap.
Cada usuario puede crear, listar y eliminar sus propias tareas.

------------------------------------------------------------------------

Funcionalidades

-   Registro de usuarios (nombre, email y contraseña encriptada).
-   Inicio y cierre de sesión usando $_SESSION.
-   CRUD básico de tareas:
    -   Crear tarea (título y descripción).
    -   Listar tareas del usuario logueado.
    -   Eliminar tarea.
-   Interfaz sencilla con Bootstrap 5.
-   Despliegue con Docker y Docker Compose.
-   Administración de la base de datos con phpMyAdmin.

------------------------------------------------------------------------

Tecnologías utilizadas

-   PHP 8.2 (Apache)
-   MySQL 8.0
-   Bootstrap 5
-   Docker y Docker Compose
-   phpMyAdmin

------------------------------------------------------------------------

Requisitos previos

-   Tener instalados:
    -   Docker
    -   Docker Compose

------------------------------------------------------------------------

Cómo ejecutar el proyecto

1.  Clona o descarga el repositorio en tu máquina.

2.  En la raíz del proyecto (donde está docker-compose.yml), ejecuta:

        docker-compose up -d

3.  Accede a la aplicación:

    -   Aplicación web: http://localhost:8080
    -   phpMyAdmin: http://localhost:8081

4.  La base de datos se crea con:

        CREATE TABLE usuarios (
          id INT AUTO_INCREMENT PRIMARY KEY,
          nombre VARCHAR(100) NOT NULL,
          email VARCHAR(150) NOT NULL UNIQUE,
          password_hash VARCHAR(255) NOT NULL,
          creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        );

        CREATE TABLE tareas (
          id INT AUTO_INCREMENT PRIMARY KEY,
          titulo VARCHAR(255) NOT NULL,
          descripcion TEXT,
          id_usuario INT NOT NULL,
          creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
          FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
            ON DELETE CASCADE
        );

    Usuario administrador:

        INSERT INTO usuarios (nombre, email, password_hash)
        VALUES ('Administrador', 'admin@admin.com',
        '$2y$10$68Z1fW6kHL88KTObQ1Hjvu5rdRuoMOh.0kJfd2gwQD7PWHWDHX4xu');

------------------------------------------------------------------------

Estructura lógica

-   index.php → Renderiza login, register o Tasks según sesión.
-   Views/ → Formularios y logout.
-   Controllers/ → Manejo de login/registro y CRUD de tareas.
-   Models/ → Acceso a BD con PDO.
-   Config/database.php → Conexión a MySQL.

------------------------------------------------------------------------

Notas

-   Contraseñas encriptadas con password_hash().
-   Las tareas son por usuario (relación 1 a muchos).
-   Configurable mediante Docker.
