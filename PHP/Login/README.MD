# SuperDuperApp — Task Manager with Login

![PHP](https://img.shields.io/badge/PHP-777BB4?logo=php&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?logo=bootstrap&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=white)

A simple PHP web app for managing tasks with user registration and login. Each user can create, list, and delete their own tasks. The project ships with a Docker + phpMyAdmin setup for local development.

---

## ✅ Features

- User registration (name, email, encrypted password).
- Login/logout with `$_SESSION`.
- Task CRUD for each user:
  - Create task (title + description)
  - List tasks
  - Delete task
- Bootstrap 5 UI for clean styling.
- Docker Compose environment with MySQL + phpMyAdmin.

---

## 🛠️ Tech Stack

- PHP 8.2 (Apache)
- MySQL 8.0
- Bootstrap 5
- Docker + Docker Compose
- phpMyAdmin

---

## ✅ Requirements

- Docker
- Docker Compose

---

## ▶️ How to Run

1. Clone or download this project.
2. From the project root (where `docker-compose.yml` is located), run:

```sh
docker-compose up -d
```

3. Access the app:

- Web app: `http://localhost:8080`
- phpMyAdmin: `http://localhost:8081`

---

## 🗄️ Database Schema

```sql
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

INSERT INTO usuarios (nombre, email, password_hash)
VALUES (
  'Administrador',
  'admin@admin.com',
  '$2y$10$68Z1fW6kHL88KTObQ1Hjvu5rdRuoMOh.0kJfd2gwQD7PWHWDHX4xu'
);
```

---

## 🧭 Project Structure

- `index.php` → Renders login, registration, or tasks based on session.
- `Views/` → Forms and logout.
- `Controllers/` → Auth + task CRUD.
- `Models/` → PDO database access.
- `Config/database.php` → MySQL connection.

---

## 📝 Notes

- Passwords are stored using `password_hash()`.
- Tasks are scoped per user (one-to-many).
- Docker configuration is easy to customize for other environments.
