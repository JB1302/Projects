# Spring Boot User Management API

A modern backend API for user registration and management, built with Spring Boot, JPA, and MySQL.  
Implements clean layered architecture, secure data handling, and follows best practices for scalable backend development.

---

## 🚀 Main Features

- **RESTful API:** Exposes endpoints for user creation and retrieval.
- **Spring Data JPA:** Persistent storage using MySQL, with `CrudRepository` for basic CRUD operations.
- **DTO Pattern:** Clean separation between entity, data transfer, and API models.
- **Layered Architecture:** Controllers, services, repositories, and entities each with their own clear responsibility.
- **Input Validation Ready:** Designed to easily add validation and business logic.
- **Password Handling:** Passwords are stored in an `encryptedPassword` field (example value used; ready for real encryption).

---

## 🛠️ Technologies Used

- Java 17+ (or compatible)
- Spring Boot
- Spring Data JPA
- MySQL
- Maven (or Gradle)

---

## 🗂️ Project Structure

src/main/java/net/testing/backendTests/
├── BackendTestsApplication.java # Main application entry point
├── controllers/ # REST API endpoints
│ └── UserController.java
├── entities/ # JPA entity classes
│ └── userEntity.java
├── models/ # API request/response models
│ ├── requests/UserDetailRequestModel.java
│ └── responses/UserRest.java
├── services/ # Service interfaces and implementations
│ ├── UserService.java
│ └── UserServiceInterface.java
├── shared/dto/ # Data Transfer Objects (DTOs)
│ └── UserDto.java
├── UserRepository.java # JPA Repository for users


---

## ⚡ How It Works

1. **User Registration**
    - `POST /users`  
      Accepts user data (first name, last name, email, password) as JSON.
    - Service layer copies request data to DTO and then to entity.
    - User entity is saved in the database.
    - Returns a response with created user info (userId, firstname, lastname, email).

2. **Get User Example**
    - `GET /users`  
      Returns a placeholder response (can be extended for real user fetching).

---

## 🧑‍💻 Example Request

**POST** `/users`
{
  "firstname": "John",
  "lastname": "Doe",
  "email": "john.doe@email.com",
  "password": "MySecret123!"
}

## Response

{
  "userId": "TESTIDPUBLICO",
  "firstname": "John",
  "lastname": "Doe",
  "email": "john.doe@email.com"
}

---

## 🗄️ Database Setup

    Database: fullstack_spring_react

    Table: users (auto-created via JPA if not present)

Sample Configuration (application.properties):

spring.application.name=backendTests
spring.datasource.username=root
spring.datasource.password=
spring.datasource.url=jdbc:mysql://localhost:3306/fullstack_spring_react?serverTimezone=America/Costa_Rica
spring.jpa.hibernate.ddl-auto=update

---

## 🌟 Why This Project?

    Production-Ready Skeleton: Easily extend for authentication, validation, and more complex business logic.

    Demonstrates Core Skills: REST APIs, Spring Boot, DTO pattern, clean architecture, database integration.

    Great for Learning and Interviews: Perfect template for full-stack app backends and technical demonstrations.

---

## 📈 Future Improvements

    Implement real password encryption (e.g., BCrypt).

    Add validation (with @Valid and custom annotations).

    Expand REST API for update, delete, and get-by-id endpoints.

    Add JWT authentication for secure user management.

    Containerize with Docker.

    Clean, scalable, and professional – a solid base for any backend project!

---