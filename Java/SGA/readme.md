# Art Gallery & Artist Management System

A robust Java desktop application for managing artists, galleries, and featured artworks.  
Includes a modern Swing-based CRUD interface, MySQL database integration, and a networked system to fetch a "featured artwork" via sockets.

---

## 🚀 Main Features

- **Artist Management (CRUD):**
  - Register, update, and remove artists with fields for name, style, age, gallery, and rating.
  - View all records in a clean, interactive table.
  - Data stored in MySQL for reliability and scalability.
- **Featured Artwork Fetching (Socket):**
  - Each artist can be assigned a "featured artwork" fetched from a simple TCP socket server.
  - The server returns a random artwork name, with different formatting based on the artist's ID.
- **Modern Swing UI:**
  - Clean, user-friendly interface.
  - Responsive controls and informative popups for user actions.
- **Separation of Concerns:**
  - MVC-like structure (`Vista`, `Controlador`, `Modelo`), making code easier to maintain and extend.

---

## 🛠️ Technologies Used

- Java (Swing, Sockets, JDBC)
- MySQL (galeriadb, table `artistas1b2`)
- MVC Pattern (modular Java classes)
- Basic XML UI form layout (for IntelliJ or similar tools)

---

## 🗂️ Project Structure

/ServidorGaleria/ # TCP socket server that returns featured artworks
/Vista/ # All Swing UI classes
/Modelo/ # Data classes (Artist), socket client, DB access
/Controlador/ # CRUD controller
/Modelo/DB/ # DB connection and credentials

---

## ⚡ How It Works

1. **Database Setup:**  
   - MySQL DB: `galeriadb`
   - Table: `artistas1b2` with fields: `NombreC3D`, `EstiloE4F`, `EdadG5H`, `GaleriaI6J`, `ValoracionK7L`.

2. **Run the Socket Server:**  
   - Launch `servidorGaleria` (runs on port `5700`).
   - Listens for artist IDs and responds with a random artwork.

3. **Run the Desktop App:**  
   - Launch the main Swing app (`main` in `/Vista/`).
   - Add, update, and delete artists via UI.
   - Click “Destacado” to fetch and display a featured artwork for a given artist (via socket).

4. **Socket Logic:**  
   - Client (`ClienteSocket`) connects to server, sends artist ID.
   - Server picks a random artwork and wraps it in `[ ... ]` or `( ... )` depending on ID parity.

---

## 🧑‍💻 Example Usage

- **Add an Artist:**
  1. Enter Name, Style, Age, Gallery, Rating.
  2. Click "Agregar".
- **Update an Artist:**
  1. Select or enter details, modify fields.
  2. Click "Actualizar".
- **Delete an Artist:**
  1. Enter Name.
  2. Click "Eliminar".
- **View Featured Artwork:**
  1. Click "Destacado" or "Obra Des..." for a selected artist.
  2. Dialog will show the featured artwork fetched from the server.

---

## 🗄️ Database Example (MySQL)

CREATE DATABASE galeriadb;
USE galeriadb;

CREATE TABLE artistas1b2 (
    NombreC3D VARCHAR(100) PRIMARY KEY,
    EstiloE4F VARCHAR(100),
    EdadG5H INT,
    GaleriaI6J VARCHAR(100),
    ValoracionK7L DOUBLE
);

## ⚡ Socket Server Example

  # Start the server
  java servidorGaleria
  # Output: "Servidor de galeria escuchando en el puerto 5700"

## 🌟 Why This Project?

    Demonstrates full-stack Java: GUI, DB, and networking.

    Extensible: Add REST APIs, more UI, or analytics with minimal refactor.

    Educational: Great example for learning Java Swing, sockets, and basic database-driven desktop apps.

## 📈 Future Improvements

    Add artist image or portfolio support.

    Integrate RESTful endpoints for web/mobile clients.

    Implement authentication and access control.

    Advanced filtering and analytics for artists and artworks.

All-in-one artist management for art galleries and enthusiasts – ready to use and extend!