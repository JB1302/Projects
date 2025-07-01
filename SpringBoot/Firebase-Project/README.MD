# 🛒 Product Manager – Spring Boot CRUD Demo

A modern, full-stack CRUD web application for managing products, built with **Spring Boot**, **MySQL**, **Spring Data JPA**, and a responsive frontend using **Thymeleaf**, **Bootstrap**, and **Firebase Storage** for image uploads.

---

## 🗂️ Project Overview

| Feature              | Description                                                           |
|----------------------|-----------------------------------------------------------------------|
| List Products        | View all products in a styled, sortable table                         |
| Add Product          | Create new product with details, quantity, expiry, and image upload   |
| Edit Product         | Update product info with form validation (modal/edit view)            |
| Delete Product       | Remove a product with confirmation modal                              |
| Image Support        | Upload and display product images using Firebase Storage              |
| Multi-language UI    | All UI texts are externalized for easy localization                   |
| SQL Bootstrap        | Ready-to-use scripts for DB, table, user, and sample data             |

---

## 🚀 Features

- **Layered Architecture**: Clean separation of controller, service, and repository
- **Thymeleaf Views**: Modular HTML fragments, multi-language messages, and DRY templates
- **Bootstrap UI**: Responsive, mobile-first design and FontAwesome icons
- **Firebase Storage**: Easy product image upload and retrieval
- **Message Source**: All texts are defined in an external file for easy translation
- **SQL Included**: Scripts for MySQL DB/user/table setup and sample records

---

## 📦 Technologies Used

- **Backend:**  
  - Java 17+  
  - Spring Boot  
  - Spring Data JPA  
  - MySQL  
  - Firebase Storage SDK (for images)
- **Frontend:**  
  - Thymeleaf  
  - Bootstrap 5  
  - FontAwesome
- **Internationalization:**  
  - messages.properties
- **Build/Config:**  
  - Maven  
  - application.properties

---

## 📁 Project Structure

src/
├── main/
│ ├── java/com/caso1/
│ │ ├── controller/ # Web controllers (ProductoController)
│ │ ├── service/ # Business logic (ProductoService, FirebaseStorageService)
│ │ ├── domain/ # JPA entities (Producto)
│ │ └── repository/ # JPA repositories (ProductoRepository)
│ └── resources/
│ ├── templates/ # Thymeleaf views & HTML fragments
│ │ └── producto/
│ ├── static/ # CSS, JS, images
│ ├── messages.properties # UI texts/messages
│ └── application.properties


---

## ⚡ Getting Started

1. **Clone the repository**  
    ```sh
    git clone https://github.com/yourusername/product-manager-springboot.git
    cd product-manager-springboot
    ```

2. **Setup MySQL Database**  
   Use the following script to create the schema, user, table, and insert demo data:

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

3. **Configure the application**  
   Edit `src/main/resources/application.properties`:
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
    Access the app at [http://localhost/producto/listado](http://localhost/producto/listado).

---

## 👀 How It Works

- **Product List:**  
  View all products, including details, expiration, quantity, and image.  
  Supports "edit" and "delete" actions with confirmation.

- **Add/Edit Product:**  
  Submit new products or update existing ones.  
  Upload images, which are stored in Firebase Storage.

- **Delete Product:**  
  Remove products securely using a confirmation modal.

- **Internationalization:**  
  All texts/messages are defined in `messages.properties` for easy translation or updates.

---

## 🌍 Localization Example

All UI strings are defined in `/src/main/resources/messages.properties`:

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