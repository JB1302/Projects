# 🛒 Product Manager — Spring Boot CRUD Demo

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)
![Firebase](https://img.shields.io/badge/Firebase-FFCA28?logo=firebase&logoColor=black)
![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?logo=bootstrap&logoColor=white)

A modern, full-stack CRUD web application for managing products, built with **Spring Boot**, **MySQL**, **Spring Data JPA**, and a responsive UI using **Thymeleaf**, **Bootstrap**, and **Firebase Storage** for image uploads.

---

## 🗂️ Project Overview

| Feature | Description |
| --- | --- |
| List Products | View all products in a styled, sortable table. |
| Add Product | Create products with details, quantity, expiry, and image upload. |
| Edit Product | Update product info with validation. |
| Delete Product | Remove a product with confirmation modal. |
| Image Support | Upload and display product images via Firebase Storage. |
| Multi-language UI | Text labels centralized for easy localization. |
| SQL Bootstrap | Ready-to-use scripts for DB, user, and demo data. |

---

## 🚀 Features

- **Layered Architecture**: clean controller, service, and repository layers.
- **Thymeleaf Views**: modular HTML fragments and message bundles.
- **Bootstrap UI**: responsive layout and FontAwesome icons.
- **Firebase Storage**: image upload and retrieval per product.
- **SQL Included**: MySQL schema + seed data provided.

---

## 📦 Technologies Used

- **Backend:** Java 17+, Spring Boot, Spring Data JPA, MySQL
- **Frontend:** Thymeleaf, Bootstrap 5, FontAwesome
- **Storage:** Firebase Storage SDK
- **Build/Config:** Maven, `application.properties`

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/caso1/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── domain/
│   │   └── repository/
│   └── resources/
│       ├── templates/
│       │   └── producto/
│       ├── static/
│       ├── messages.properties
│       └── application.properties
```

---

## ⚡ Getting Started

1. **Clone the repository**
    ```sh
    git clone https://github.com/yourusername/product-manager-springboot.git
    cd product-manager-springboot
    ```

2. **Setup MySQL Database**
    ```sql
    DROP SCHEMA IF EXISTS esquemaBD01;
    DROP USER IF EXISTS estudiante01;
    CREATE SCHEMA esquemaBD01;
    CREATE USER 'estudiante01'@'%' IDENTIFIED BY '118540180';
    GRANT ALL PRIVILEGES ON esquemaBD01.* TO 'estudiante01'@'%';
    FLUSH PRIVILEGES;
    USE esquemaBD01;

    CREATE TABLE producto(
      id_producto INT NOT NULL AUTO_INCREMENT,
      detalle VARCHAR(30) NOT NULL,
      fecha_vence VARCHAR(10) NOT NULL,
      cantidad INT NOT NULL,
      imagen_producto VARCHAR(1024),
      PRIMARY KEY(id_producto)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

    INSERT INTO producto (detalle, fecha_vence, cantidad, imagen_producto) VALUES
    ('Leche Entera', '2025-12-31', 20, 'https://ik.imagekit.io/autoenlinea/imgjpg/tr:f-webp/018804_1.jpg'),
    ('Arroz Blanco', '2026-02-28', 100, 'https://ik.imagekit.io/autoenlinea/imgjpg/tr:f-webp/873500_1.jpg'),
    ('Aceite Vegetal', '2025-11-15', 50, 'https://walmartcr.vtexassets.com/arquivos/ids/923391/66910_01.jpg?v=638827668194730000'),
    ('Galleta Integral', '2025-09-20', 75, 'https://walmartcr.vtexassets.com/arquivos/ids/566123/Galleta-Integral-Pozuelo-Ajonjoli-Tosh-Libre-De-Az-car-252g-1-29039.jpg?v=638458983255730000');
    ```

3. **Configure the application** (`src/main/resources/application.properties`)
    ```properties
    spring.application.name=caso01
    server.port=80
    spring.datasource.url=jdbc:mysql://localhost:3306/esquemaBD01
    spring.datasource.username=estudiante01
    spring.datasource.password=118540180
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
    spring.jpa.properties.hibernate.format_sql=true
    logging.level.org.hibernate.SQL=DEBUG
    logging.level.org.type.descriptor.sql.BasicBinder=TRACE
    ```

4. **Run the Application**
    ```sh
    ./mvnw spring-boot:run
    ```

---

## 🌍 Localization Example

All UI strings are centralized in `messages.properties` for easy translation:

```
producto.listado=Product List
producto.detalle=Description
producto.fecha_vence=Expiration Date
producto.cantidad=Quantity
producto.imagen=Image
accion.acciones=Actions
accion.eliminar=Delete
accion.actualizar=Edit
accion.regresar=Back
accion.guardar=Save
lista.vacia=No products registered
accion.confirmar=Confirm Deletion
accion.confirmar.texto1=Are you sure you want to delete the product
mensaje.eliminado=Product deleted successfully.
mensaje.actualizado=Product updated successfully.
```

---

**A production-style CRUD app with image uploads—perfect for a Spring Boot portfolio.**
