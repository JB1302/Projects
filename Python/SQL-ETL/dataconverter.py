import pandas as pd
import json
from datetime import datetime
import os

hoy = datetime.now()
fecha_str = hoy.strftime('%Y-%m-%d_%H-%M')

class JSONparser:
    def __init__(self, xlsx_file):
      self.xlsx_file = xlsx_file
    
    def convertir_a_json(self):
      df = pd.read_excel(self.xlsx_file, sheet_name=None)
      #Convertir cada hoja a JSON
      json_data = {}
      for sheet_name, data in df.items():
        json_data[sheet_name] = data.to_dict(orient = 'records')
        
      #Definir la ruta del dump
      folder_path = 'JSON Dumps'
      json_file = os.path.join(folder_path, f'JSON_{fecha_str}.json')
        
      #Guardar en archivo Json
      with open(json_file, 'w') as json_output:
          json.dump(json_data, json_output, indent=4)
        
      print(f"El archivo JSON se ha guardado como {json_file}")
  
  
#Cargar archivo
parser = JSONparser(r'C:\Users\jstev\Downloads\Interview\HR info.xlsx')
parser.convertir_a_json()