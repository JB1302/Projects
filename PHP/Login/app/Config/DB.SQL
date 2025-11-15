/*
USE appdb;

-- Tabla de usuarios
CREATE TABLE usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  email VARCHAR(150) NOT NULL UNIQUE,
  password_hash VARCHAR(255) NOT NULL,
  creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de tareas
CREATE TABLE tareas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(255) NOT NULL,
  descripcion TEXT,
  id_usuario INT NOT NULL,
  creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
    ON DELETE CASCADE
);

--Admin -> Pass = 1
INSERT INTO usuarios (nombre, email, password_hash)
VALUES ('Administrador', 'admin@admin.com',
'$2y$10$68Z1fW6kHL88KTObQ1Hjvu5rdRuoMOh.0kJfd2gwQD7PWHWDHX4xu');


INSERT INTO tareas (titulo, descripcion, id_usuario) VALUES
('Revisar usuarios del sistema', 'El administrador debe validar que las cuentas registradas estén correctas.', 1),
('Realizar copia de seguridad', 'Generar el backup diario completo.', 1);
/*