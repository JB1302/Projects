# 🌳 TreeCapitator — Spring Boot CRUD for Tree Species

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?logo=thymeleaf&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?logo=bootstrap&logoColor=white)

**TreeCapitator** is a modern CRUD web application for managing a catalog of tree species. It uses a clean Spring Boot architecture with MySQL persistence and a responsive Thymeleaf + Bootstrap UI.

---

## 🗂️ Project Overview

| Feature | Description |
| --- | --- |
| List Trees | View all tree species in a sortable, responsive table. |
| Add Tree | Modal form for new tree entries with validation. |
| Edit Tree | Update existing records in-place. |
| Delete Tree | Confirmation-based deletion workflow. |
| Image Support | Each tree entry supports a remote image URL. |
| MySQL Persistence | Data stored and managed using JPA + MySQL. |

---

## 🚀 Features

- **Layered architecture** (controller → service → repository).
- **Reusable Thymeleaf templates** for clean UI structure.
- **Bootstrap 5 styling** and FontAwesome icons.
- **Modal-based forms** for a smooth user experience.
- **SQL bootstrap script** for fast setup.

---

## 📦 Technologies Used

- **Backend:** Java 17+, Spring Boot, Spring Data JPA, MySQL
- **Frontend:** Thymeleaf, Bootstrap 5, FontAwesome
- **Build/Config:** Maven, `application.properties`

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/Steven/TreeCapitator/TreeCapitator/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── domain/
│   │   └── repository/
│   └── resources/
│       ├── templates/
│       ├── static/
│       └── application.properties
```

---

## ⚡ Getting Started

1. **Clone the repo**
    ```sh
    git clone https://github.com/yourusername/treecapitator.git
    cd treecapitator
    ```

2. **Initialize MySQL**

    ```sql
    DROP SCHEMA IF EXISTS practica;
    DROP USER IF EXISTS usuario_practica;

    CREATE SCHEMA practica;
    CREATE USER 'usuario_practica'@'%' IDENTIFIED BY 'la clave';
    GRANT ALL PRIVILEGES ON practica.* TO 'usuario_practica'@'%';
    FLUSH PRIVILEGES;
    USE practica;

    CREATE TABLE arbol (
      id_especie INT NOT NULL AUTO_INCREMENT,
      edad INT NOT NULL,
      nombre_comun1 VARCHAR(30) NOT NULL,
      nombre_comun2 VARCHAR(30),
      nombre_cientifico1 VARCHAR(30) NOT NULL,
      nombre_cientifico2 VARCHAR(30) NOT NULL,
      ruta_imagen VARCHAR(1024),
      PRIMARY KEY(id_especie)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
    ```

3. **Configure `application.properties`**

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/practica
    spring.datasource.username=usuario_practica
    spring.datasource.password=la clave
    spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
    server.port=80
    ```

4. **Run the app**
    ```sh
    ./mvnw spring-boot:run
    ```

---

**A clean Spring Boot CRUD reference that’s ideal for portfolios and learning.**
