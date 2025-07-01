# Auto Repair Shop Management System

A full-featured desktop application for managing users, vehicles, repairs, appointments, inventory, notifications, and invoicing in a car repair shop.  
Built with Java Swing, this project follows a modular, scalable architecture and modern UI patterns.

---

## 🚀 Main Features

- **User authentication & registration:**  
  Login screen and secure user registration (Client, Mechanic, Admin roles)
- **Modular navigation:**  
  Vertical menu for quick access to Users, Vehicles, Repairs, Appointments, Inventory, Notifications, and Invoicing modules
- **User management:**  
  Register, update, search, display, and delete users
- **Vehicle management:**  
  Register and manage vehicles assigned to users
- **Repair orders & appointments:**  
  Full CRUD for repair orders, scheduling, and work assignments
- **Inventory control:**  
  Register parts, update stock, compare inventory, and advanced search
- **Automated notifications** for pending orders and important events
- **Invoicing and financial control**
- **Modern, friendly UI:**  
  Clean layout with intuitive controls and helpful feedback
- **Layered, object-oriented architecture:**  
  UI, Controllers, and Models separated for clarity and scalability

---

## 🗂️ Project Structure

/Backend/
/controller/
/model/
/service/

/Frontend/
/CoreApp/
VentanaPrincipal.java # Main window, navigation & view switching
/Functions/ # Panels for each module
/Login/ # Login and registration screens
/Register/

Main.java # Application entry point


---

## 🛠️ Technologies & Dependencies

- Java 8+  
- Java Swing (UI)
- JDBC (for relational database access)
- MySQL (default, or compatible RDBMS)
- Maven/Gradle (optional for dependency management)

---

## 🏁 Getting Started

1. **Clone this repository**
2. **Install Java (8+) on your machine**
3. **Set up the database connection** (configure credentials in `/Backend/model/`)
4. **Run the application:**
   java Main Or, launch Main from your favorite IDE.

---

## 🧑‍💻 Key Modules
Login & Registration

    User login with validation and role-based access (Client, Mechanic, Admin)

    New user registration with form validation and error handling

Main Window & Navigation

    Vertical menu bar for navigating between modules

    Central panel changes based on selected module

Users

    Create, update, delete, search, and view users

    All operations handled via backend controllers

Vehicles

    Register and manage vehicles assigned to users

Repairs

    Create and manage repair orders

    Assign work, track status and history

Appointments

    Schedule and manage repair appointments

Inventory

    Add new parts, update quantities, search and compare inventory

    Visualize and edit stock in real-time

Notifications

    Automated reminders for pending orders and key events

Invoicing

    Generate, view, and manage invoices and billing records

## 🌟 Why Use This Project?

    Scalable & maintainable:
    Each module is independent and reusable

    User-friendly:
    Intuitive design suitable for non-technical users

    Solid foundation:
    Ready to integrate with web APIs or migrate to a Spring Boot backend in the future

## 🚧 TODO / Ideas

    Advanced form validation

    Secure password hashing

    Better session/role management

    Export to PDF/Excel

    REST API integration (Spring Boot suggested for scaling backend)

    Automated testing