import mysql.connector;
from credentials import credentialsDB;
from dataconverter import JSONparser;
from jsonLoader import JsonSQLUpload;

if __name__ == "__main__":
  #Encapsulamiento de credenciales
  config = {
    "host" : "127.0.0.1",
    "user" : credentialsDB.SQLuser,
    "password" : credentialsDB.SQLPassword
  }

  # Convertir el excel a JSON

  excelLocation = input("Favor digite la locación del excel: ")

  parser = JSONparser(excelLocation)
  parser.convertir_a_json()

  # Crear la instancia de JsonSQLUpload
  json_loader = JsonSQLUpload()

  #Cargar al servidor
  try:
    conn = mysql.connector.connect(**config)
    
    if conn.is_connected():
      print ("Conectado a SQL")
      
      #Cargar el archivo del Json al SQL Server
      json_loader.subirJson()


  except mysql.connector.errors as err:
    print(f"⚠ Error: {err}")
  finally:
    if 'conn' in locals () and conn.is_connected():
      conn.close()
      print ("Conexion cerrada")