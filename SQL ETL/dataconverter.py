import pandas as pd
import json



class JSONparser:
    def __init__(self, xlsx_file):
      self.xlsx_file = xlsx_file
    
    def convertir_a_json(self):
      df = pd.read_excel(self.xlsx_file, sheet_name=None)
      #Convertir cada hoja a JSON
      json_data = {}
      for sheet_name, data in df.items():
        json_data[sheet_name] = data.to_dict(orient = 'records')
        
      #Guardar en archivo Json
      json_file = 'archivo.json'
      with open(json_file, 'w') as json_output:
          json.dump(json_data, json_output, indent=4)
        
      print(f"El archivo JSON se ha guardado como {json_file}")
  
  
#Cargar archivo
excelFile = r'C:\Users\jstev\Downloads\Interview\HR info.xlsx'
parser = JSONparser(excelFile)
parser.convertir_a_json()