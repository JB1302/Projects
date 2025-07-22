CREATE DATABASE BarberiaEstiloFino;
GO

USE BarberiaEstiloFino;
GO

CREATE TABLE Clientes(
    ClienteID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    Nombre VARCHAR(30) NOT NULL,
    Telefono INT,
    Email VARCHAR(30)
);
GO

CREATE TABLE Barberos(
    BarberoID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    Nombre VARCHAR(30) NOT NULL,
    Especialidad VARCHAR(10)
);
GO

CREATE TABLE Citas(
    CitaID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    ClienteID INT,
    BarberoID INT,
    FechaHora DATETIME NOT NULL,
    Notas VARCHAR(50),
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID),
    FOREIGN KEY (BarberoID) REFERENCES Barberos(BarberoID)
);
GO

INSERT INTO Barberos (Nombre, Especialidad) VALUES
('Juan José', 'Degradados'),
('Jose Eduardo', NULL),
('Juancho', 'Barbas'),
('Eduardo Enrique', 'Degradados'),
('Mikol Mendez', NULL);
GO

INSERT INTO Clientes (Nombre, Telefono, Email) VALUES
('Andres', NULL, NULL),
('Andy', '64301602', 'And23@gmail.com'),
('Juanjo', '64501807', 'juanjo@gmail.com'),
('Trend Martinez', '74306629', 'BigTrend@gmail.com'),
('Junk', NULL, 'Juank@gmail.com'),
('Mary', '65386803', NULL),
('Homer', '94351619', 'Homer1234@gmail.com');
GO

INSERT INTO Citas (ClienteID, BarberoID, FechaHora, Notas) VALUES
(1, 3, '2025-07-21 00:00:00.000', 'Corte Sencillo'),
(2, 1, '2025-07-21 00:00:00.000', 'Barba'),
(3, 3, '2025-07-21 00:00:00.000', 'Degradado'),
(4, 4, '2025-07-21 00:00:00.000', NULL),
(5, 5, '2025-07-21 00:00:00.000', 'Corte Sencillo');
GO

-- Insertar Cliente
CREATE PROCEDURE SP_InsertarCliente
    @Nombre VARCHAR(30),
    @Telefono INT = NULL,
    @Email VARCHAR(30) = NULL
AS
BEGIN
    INSERT INTO Clientes(Nombre, Telefono, Email)
    VALUES (@Nombre, @Telefono, @Email);
END
GO

-- Listar Clientes
CREATE PROCEDURE SP_ListarClientes
AS
BEGIN
    SELECT * FROM Clientes;
END
GO

-- Insertar Barbero
CREATE PROCEDURE SP_InsertarBarbero
    @Nombre VARCHAR(30),
    @Especialidad VARCHAR(10) = NULL
AS
BEGIN
    INSERT INTO Barberos(Nombre, Especialidad)
    VALUES (@Nombre, @Especialidad);
END
GO

-- Listar Barberos
CREATE PROCEDURE SP_ListarBarberos
AS
BEGIN
    SELECT * FROM Barberos;
END
GO

-- Insertar Cita
CREATE PROCEDURE SP_InsertarCita
    @ClienteID INT,
    @BarberoID INT,
    @FechaHora DATETIME,
    @Notas VARCHAR(50) = NULL
AS
BEGIN
    INSERT INTO Citas(ClienteID, BarberoID, FechaHora, Notas)
    VALUES (@ClienteID, @BarberoID, @FechaHora, @Notas);
END
GO

-- Listar Citas
CREATE PROCEDURE SP_ListarCitas
AS
BEGIN
    SELECT * FROM Citas;
END
GO
