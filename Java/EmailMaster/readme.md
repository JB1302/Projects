# Employee Credential & Update Automation System

A robust Java console application for secure employee credential management, including data retrieval, automatic email and password generation, and database updates. Designed for real-world HR, IT, or onboarding processes where automation and security are critical.

---

## 🚀 Main Features

- **Employee Data Retrieval:**  
  Fetches employee information from a MySQL database using prepared statements.
- **Automated Email & Password Generation:**  
  Generates unique, secure email addresses and passwords for each employee.
- **Personalized Email Template:**  
  Creates a ready-to-send onboarding email message including credentials.
- **Database Update:**  
  Updates email and password fields for the employee directly in MySQL using safe, parameterized queries.
- **Console Reporting:**  
  Shows the new credentials and confirms updates in the console.

---

## 🛠️ Technologies Used

- Java (OOP, Exception Handling)
- JDBC (MySQL)
- Modular design: Clear separation of concerns (data access, business logic, presentation)
- Security: Uses prepared statements to prevent SQL Injection

---

## 📝 Project Structure

/Empleados/
MostrarDatos.java # Retrieves and displays employee info
/Logic/
EmailHandler.java # Handles retrieval and generation of names, emails, and passwords
EmailTemplate.java # Builds the onboarding email message
/Server/
ServerGateway.java # Manages DB connection
ServerInteractions.java # Handles database updates
main.java # Main program logic


---

## ⚡ How It Works

1. **User enters an employee ID.**
2. The program:
   - Retrieves the employee’s name, surname, and department.
   - Generates a secure password and a corporate email.
   - Builds a personalized onboarding email template.
   - Updates the database (email and password fields).
   - Displays updated data for verification.

3. **Example Console Flow:**

Enter ID to search:
[user types ID]

--- Generate Template ---
[shows email + password template]

--- Update Data ---
[confirms DB update]

--- Show Information ---
[shows updated employee info]


---

## 🧑‍💻 Sample Usage

// Fetch data
mostrarDatos.mostrarDatos(IdToFind);

// Generate email and password
String email = emailHandler.correo(IdToFind);
String password = emailHandler.generatePassword();

// Update database
serverInteractions.actualizarInformación("correo", email, IdToFind);
serverInteractions.actualizarInformación("contraseña", password, IdToFind);

// Generate onboarding email
System.out.println(emailTemplate.EmailTemplate(IdToFind, password));

 ## Requirements

    Java 8+

    MySQL database (with an 'empleados' table containing id, nombre, apellido, correo, departamento, contraseña)

    JDBC connector

## 🌟 Why Use This Project?

    Security First: Prepared statements, no hardcoded passwords, exception-safe code.

    Extensible: Clean OOP structure, easily integrates with more complex onboarding systems.

    Real-World Ready: Automates a critical HR process, saving manual effort and reducing human error.

## 📈 Possible Improvements

    Encrypt stored passwords (e.g., with BCrypt).

    Add CLI or GUI for batch onboarding.

    Email sending integration (SMTP).

    Add logs or notifications for updates.