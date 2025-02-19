import webview
import json

class Api:
  
  def __init__(self):
    self.data_file = 'datos.json' #archivos para guardar
    
  def save_data(self,data):
    "Guardar los datos en un JSON"
    with open(self.data_file, "w") as f:
      json.dump(data, f)
    return "Datos guardados"
  
  def load_data(self):
    "cargar los datos de un JSON si existe"
    try:
      with open(self.data_file, 'r') as f:
        data = json.load(f)
      return data
    except Exception as e:
      return{}
    
api = Api()
    
rutaBackEnd = "C:/Users/jstev/OneDrive/Documents/GitHub/Projects/Python/Transaction Manager/frontend/index.html"
ventana = webview.create_window(
    "Mi Aplicación",
    rutaBackEnd,
    width=668,     # Ancho total aproximado
    height=426,    # Alto total aproximado
    resizable=False,
    js_api=api  # Exponemos la API a JavaScript
)

webview.start()