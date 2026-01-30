# Gas Station Database — SQL Server

![SQL Server](https://img.shields.io/badge/SQL%20Server-CC2927?logo=microsoftsqlserver&logoColor=white)
![T--SQL](https://img.shields.io/badge/T--SQL-475569?logo=code&logoColor=white)
![Database](https://img.shields.io/badge/Database-0F172A?logo=databricks&logoColor=white)

A SQL Server database project that models a gas station business. It includes tables, stored procedures, and auditing logic to support sales, inventory, and employee operations.

---

## 🧱 Tables

- `empleados`
- `combustible`
- `ventas`
- `auditoria`

---

## ⚙️ Core Functionality

- **Audit triggers** for sales inserts and updates.
- **Views** to classify stock levels.
- **Stock status function** for quick inventory checks.
- **Stored procedures** for:
  - Registering a sale
  - Listing low stock
  - Viewing sales by date

---

## ▶️ How to Run

1. Execute `gasolinera.sql` in SQL Server Management Studio (SSMS).
2. Use the stored procedures to insert and query sales data.

---

## 📌 Notes

This database is structured for learning and demonstration purposes. It can be extended with pricing history, supplier tables, and reporting dashboards.
