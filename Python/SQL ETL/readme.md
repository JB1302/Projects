# HR Analytics ETL System 📊🔗

A complete ETL pipeline for HR analytics. Extracts data from Excel, transforms it to JSON, loads it into MySQL, and visualizes it in PowerBI.

## Workflow

- **Extract:** Converts Excel sheets to structured JSON (with versioning).
- **Transform:** Cleans and validates data using Pandas.
- **Load:** Batch inserts into MySQL with transaction safety.
- **Visualize:** Connects PowerBI directly to MySQL for real-time dashboards.

## Technologies

- Python, Pandas, SQLAlchemy, MySQL
- PowerBI
- JSON, Excel

## Key Features

- Modular design (separate conversion and loading)
- Secure credentials handling
- Transactional loads to avoid data corruption
- Ready for scaling (easily add new sheets/tables)

## How to Use

1. Install dependencies from `requirements.txt`.
2. Run the ETL pipeline: `python main.py`.
3. Connect PowerBI to MySQL and explore your dashboards.

---

**Ideal for Data Engineers and BI Analysts looking to automate HR data flows and dashboards.**
