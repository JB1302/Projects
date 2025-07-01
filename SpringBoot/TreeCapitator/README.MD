# 🌳 TreeCapitator – Spring Boot CRUD for Tree Species

**TreeCapitator** is a modern CRUD web application for managing a catalog of tree species.  
Built with **Spring Boot**, **MySQL**, **Spring Data JPA**, and a responsive frontend using **Thymeleaf** and **Bootstrap**.

---

## 🗂️ Project Overview

| Feature            | Description                                                           |
|--------------------|-----------------------------------------------------------------------|
| List Trees         | View all registered tree species in a sortable, responsive table.     |
| Add Tree           | Modal form for adding new trees with input validation.                |
| Edit Tree          | Edit existing records directly from the table (modal-based form).     |
| Delete Tree        | Remove records securely with confirmation.                            |
| Image Support      | Each tree entry supports a remote image URL.                          |
| MySQL Persistence  | Data stored and managed using MySQL + JPA (Hibernate).                |
| Modern UI          | Responsive design with Bootstrap 5 and FontAwesome icons.             |

---

## 🚀 Features

- **Clean layered architecture**: Decoupled controller, service, and repository.
- **Thymeleaf templates**: Dynamic and reusable HTML components.
- **Bootstrap UI**: Mobile-first, visually appealing, and easy to use.
- **Fast feedback**: Modal-based forms—no full page reloads required.
- **Full SQL example**: Ready-to-use script for DB, user, and table initialization.
- **Easy configuration**: All database and app settings via `application.properties`.

---

## 📦 Technologies Used

- **Backend**:  
  - Java 17+  
  - Spring Boot  
  - Spring Data JPA  
  - MySQL
- **Frontend**:  
  - Thymeleaf  
  - Bootstrap 5  
  - FontAwesome
- **Build/Config**:  
  - Maven  
  - application.properties

---

## 📁 Project Structure

src/
├── main/
│ ├── java/com/Steven/TreeCapitator/TreeCapitator/
│ │ ├── controller/ # Web controllers (ArbolController)
│ │ ├── service/ # Business logic (ArbolService)
│ │ ├── domain/ # JPA entities (Arbol)
│ │ └── repository/ # JPA repositories (ArbolRepository)
│ └── resources/
│ ├── templates/ # Thymeleaf views & fragments
│ ├── static/ # CSS, JS, images
│ └── application.properties


---

## ⚡ Getting Started

1. **Clone the repo**  
    ```sh
    git clone https://github.com/yourusername/treecapitator.git
    cd treecapitator
    ```

2. **Initialize the MySQL Database**

    Use this SQL script (adjust username/password as needed):

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

    _Add sample data as desired (see source for examples)._

3. **Update `application.properties`**

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/practica
    spring.datasource.username=usuario_practica
    spring.datasource.password=la clave
    spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
    server.port=80
    ```

4. **Build and Run**

    ```sh
    ./mvnw spring-boot:run
    ```
    Visit [http://localhost/](http://localhost/) in your browser.

---

## 👀 How It Works

- **Main Page:**  
  View all tree species in a styled table, including age, common/scientific names, and image.
- **Add/Edit/Delete:**  
  Use modal forms for creating, updating, and deleting trees. All data persists in MySQL.
- **Modern Look:**  
  The UI is fully responsive (Bootstrap), supports images, and uses fragments for DRY code.
- **Separation of Concerns:**  
  Clear MVC pattern with dedicated folders for domain, business logic, repository, and views.

---

## 📝 License

Open source for personal, educational, or professional use.  
Feel free to fork, adapt, and extend!

---

**Robust, clean, and production-ready—perfect as a Spring Boot CRUD reference or for real-world portfolio projects.**

---

*Want a REST API, Docker instructions, or demo screenshots? Just ask!*
