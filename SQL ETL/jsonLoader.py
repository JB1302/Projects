import pandas as pd
from sqlalchemy import create_engine, text
import json
from sqlalchemy.exc import SQLAlchemyError

from credentials import credentialsDB
from datetime import datetime
import os

hoy = datetime.now()
fecha_str = hoy.strftime('%Y-%m-%d_%H-%M')


class JsonSQLUpload:
    def subirJson(self):
        # Definir credenciales
        usuario = credentialsDB.SQLuser
        password = credentialsDB.SQLPassword
        host = '127.0.0.1'
        baseDeDatos = 'hr'

        # Leer el JSON
        folder_path = 'JSON Dumps'  # Asegúrate de que esta sea la carpeta correcta
        json_file = os.path.join(folder_path, f'JSON_{fecha_str}.json')

        with open(json_file, 'r') as f:
            json_data = json.load(f)

        # Constructor para accesos de SQL
        constructorAcceso = f"mysql+mysqlconnector://{usuario}:{password}@{host}/{baseDeDatos}"
        # Conectar a SQL
        engine = create_engine(constructorAcceso)

        # Columnas numéricas
        numeric_cols = [
            'Age', 'DailyRate', 'DistanceFromHome', 'Education', 'EmployeeCount', 'EmployeeNumber',
            'EnvironmentSatisfaction', 'HourlyRate', 'JobInvolvement', 'JobLevel', 'MonthlyIncome',
            'MonthlyRate', 'NumCompaniesWorked', 'PercentSalaryHike', 'PerformanceRating', 'StandardHours',
            'StockOptionLevel', 'TotalWorkingYears', 'TrainingTimesLastYear', 'WorkLifeBalance',
            'YearsAtCompany', 'YearsInCurrentRole', 'YearsSinceLastPromotion', 'YearsWithCurrManager',
            'JobSatisfaction', 'RelationshipSatisfaction'
        ]

        # Función de limpieza de datos
        def clean_value(col, val):
            if pd.isnull(val):
                return None

            # Se espera un "Yes" o "No"
            if col == "Attrition":
                return "Yes" if str(val).strip().lower() in ["yes", "y"] else "No"
            elif col == "Over18":
                return "Y"  # Se asume que todos son mayores de 18
            elif col == "OverTime":
                return "Yes" if str(val).strip().lower() in ["yes", "y"] else "No"
            else:
                return val

        # Procesar cada hoja en el JSON
        for sheet_name, data in json_data.items():
            df = pd.DataFrame(data)
            print(f"Procesando hoja: {sheet_name}")
            print(df.head())

            # Convertir columnas numéricas
            for col in numeric_cols:
                if col in df.columns:
                    df[col] = pd.to_numeric(df[col], errors='coerce')

            # Aplicar limpieza a columnas específicas
            for col in ["Attrition", "Over18", "OverTime"]:
                if col in df.columns:
                    df[col] = df[col].apply(lambda x: clean_value(col, x))

            # Usar una transacción para insertar datos
            try:
                with engine.begin() as connection:
                    for index, row in df.iterrows():
                        columnas = ', '.join(f"{col}" for col in df.columns)
                        placeholders = ', '.join(f":{col}" for col in df.columns)
                        clausulaActualizacion = ', '.join(f"{col} = VALUES({col})" for col in df.columns)

                        insert_sql = f"""
                            INSERT INTO empleados ({columnas})
                            VALUES ({placeholders})
                            ON DUPLICATE KEY UPDATE {clausulaActualizacion};
                        """

                        connection.execute(text(insert_sql), row.to_dict())

                        print(f"Fila {index + 1} insertada/actualizada.")

                print("✅ Todos los datos fueron insertados con éxito.")

            except SQLAlchemyError as e:
                print(f"❌ Error durante la inserción: {e}")
