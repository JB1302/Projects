import mysql.connector;
from credentials import credentialsDB;

#Encapsulamiento de credenciales
config = {
  "host" : "127.0.0.1",
  "user" : credentialsDB.SQLuser,
  "password" : credentialsDB.SQLPassword
}

try:
  conn = mysql.connector.connect(**config)
  
  if conn.is_connected():
    print ("Conectado a SQL")
    






except mysql.connector.errors as err:
  print(f"⚠ Error: {err}")
finally:
  if 'conn' in locals () and conn.is_connected():
    conn.close()
    print ("Conexion cerrada")