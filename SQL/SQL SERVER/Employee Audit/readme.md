# db_tarea_04 – SQL Server Demo: Employees & Auditing

This project demonstrates the creation and management of an employee database using SQL Server, including audit tracking and a filtered view for high salaries.

---

## Contents

- **Database Creation & Cleanup:**  
  The script ensures any previous database version is deleted before creating a fresh one, guaranteeing a clean environment.

- **Main Employee Table:**  
  The table structure stores basic employee information such as ID, names, address, job position, salary, start date, and optional end date (for employees who left).

- **Data Insertion:**  
  Example employees are added to showcase both active and inactive cases.

- **Stored Procedures:**  
  - Inserting new employees.
  - Listing active employees (those without an end date).
  - Updating the end date to indicate when an employee leaves.

- **Audit Trigger:**  
  Any update to employee records (such as marking them as inactive) is automatically logged in an audit table. The log includes the SQL user, action type, timestamp, and both old and new data for traceability.

- **High Salary View:**  
  A database view filters and displays only employees with a salary above one million, making it easy to identify high earners.

---

## Usage

1. Run the script in SQL Server Management Studio or a compatible tool.
2. Review the structure, stored procedures, and view.
3. Test with your own queries and data modifications.
4. Check the audit table for changes after updates.

---

## Notes

- The audit trigger only tracks updates, not inserts or deletions.
- This demo is for learning, practice, and testing purposes.
- All employee data included is sample and fictional.

