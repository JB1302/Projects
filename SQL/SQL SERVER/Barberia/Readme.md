# BarberiaEstiloFino Database

This project implements a simple SQL Server database for managing a barber shop's appointments, clients, and barbers.

## Overview

The database contains three main tables:
- **Clientes:** Stores customer information.
- **Barberos:** Stores barber information.
- **Citas:** Stores appointments (links clients and barbers).

Stored procedures are included for inserting and listing records in each table.

## Table Structure

### 1. Clientes
| Field      | Type           | Details                   |
|------------|----------------|--------------------------|
| ClienteID  | INT            | Primary Key, Identity     |
| Nombre     | VARCHAR(30)    | Required                  |
| Telefono   | INT            | Optional                  |
| Email      | VARCHAR(30)    | Optional                  |

### 2. Barberos
| Field        | Type           | Details                 |
|--------------|----------------|------------------------|
| BarberoID    | INT            | Primary Key, Identity   |
| Nombre       | VARCHAR(30)    | Required                |
| Especialidad | VARCHAR(10)    | Optional                |

### 3. Citas
| Field      | Type         | Details                                     |
|------------|--------------|---------------------------------------------|
| CitaID     | INT          | Primary Key, Identity                       |
| ClienteID  | INT          | Foreign Key -> Clientes(ClienteID)          |
| BarberoID  | INT          | Foreign Key -> Barberos(BarberoID)          |
| FechaHora  | DATETIME     | Required                                    |
| Notas      | VARCHAR(50)  | Optional                                    |

## Stored Procedures

For each table:
- `SP_Insertar[Table]`: Insert a new record.
- `SP_Listar[Table]`: List all records.

**Example:**
- `SP_InsertarCliente @Nombre, @Telefono, @Email`
- `SP_ListarClientes`

## How to Use

1. **Create the database and tables:**  
   Execute the SQL script provided in `BarberiaEstiloFino.sql`.

2. **Insert sample data:**  
   Use the provided `INSERT` statements for demo records.

3. **Run stored procedures:**  
   Call the stored procedures to insert new records or list existing ones.

## Example

```sql
-- Insert a new client
EXEC SP_InsertarCliente 'John Doe', 12345678, 'john@example.com';

-- List all barbers
EXEC SP_ListarBarberos;

-- Insert a new appointment
EXEC SP_InsertarCita 1, 2, '2025-07-22 15:30:00', 'Haircut';
