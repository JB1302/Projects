### UNA API (Application Program Interface) 
### Es basicamente un conector para recuperar datos.

#Instar pip requests

import os #Para cargar archivos
import requests #Para ejecutar HTTPS Requets
from dotenv import load_dotenv #Para cargar el archivo .env
import json #Para darle formato bonito al JSON

#Cargar el archivo
load_dotenv()

#Definir el API como una varaible
api_key = os.environ.get("API_KEY")

#En caso de que no se logre encontrar
if not api_key:
  #Ejecutar  mensaje de error en consola
  raise ValueError("API KEY NO ENCONTRADA")


#Metodo para llamr al API
def obtener_datos_metereologicos(api, country):
  temperaturas = [] #Lista de temperaturas
  superaron25 = 0 #Verificar si pasaron los 25 Grados
  
  #URL Base
  baseURL =  "http://api.weatherapi.com/v1"

  #Constructor
  url = f"""{baseURL}/forecast.json?key={api}
                    &q={country}
                    &days=7
                    &lang=es"""

  #Ejecutar petición al API
  response = requests.get(url)

  #Ejecutar en caso de ejecutarse exitosamente
  if response.status_code == 200:
    print("Respuesta ejecutada\n")

    #Cargar el JSON  
    dataJson = response.json()
    
    #Identificar las Categorias dentro del JSON 
    #Para poder iterar basado en los objetos
    data = dataJson["forecast"]["forecastday"]
    
    #Usar los primeros parametros para las variables
    dia_mas_caluroso = data[0]["day"]["maxtemp_c"]
    dia_mas_frio = data[0]["day"]["mintemp_c"]

    #iterar por cada dia en la data
    for dia in range(len(data)):
      print("/----------------/")
      
      #Definir indice actual
      diaActual = dataJson["forecast"]["forecastday"][dia]

      #Fecha Actual    
      fecha = diaActual["date"]
      #Temperatura Maxima
      temp_max  = diaActual["day"]["maxtemp_c"]
      
      #Verificar el dia mas caluroso de la semana
      #De ser asi, actualizar la variable
      dia_mas_caluroso = es_mas_caluroso(dia_mas_caluroso, temp_max)
      
      #Aumentar el contador si superan la Temp   
      if temp_max > 25:
        superaron25 = superaron25 +1
        
      #Temperatura Promedio
      temp_avg  = diaActual["day"]["avgtemp_c"]
      #Añadir a la lista de Temps
      temperaturas.append(temp_avg)
      
      #Temperatura Minima
      temp_min  = diaActual["day"]["mintemp_c"]
      
      #Comprobar si el dia es el mas frio
      #De ser asi, actualizar la variable
      dia_mas_frio = es_mas_frio(dia_mas_frio, temp_min)
      
      #Print de los elementos.
      print(f"Fecha: {fecha}\nTemp Maxima: {temp_max}\nTemp Avg: {temp_avg}\nTemp Min: {temp_min}")
    
    #Ordenar el arreglo
    temperaturas.sort()
    print("/----------------/")
    
    return dia_mas_caluroso,dia_mas_frio,superaron25,temperaturas
  #Ejecutar en caso de fallos
  else:
      print(f"Respuesta fallida con codigo:{response.status_code}")
  
#Metodo para Verificar el dia mas caluroso    
def es_mas_caluroso(actual, candidato):
  #Devuelve el valor mas grande
  return max(actual,candidato)
    
def es_mas_frio(actual, candidato):
    #Devuelve el valor mas pequeño
  return min(actual,candidato)
    
#Metodo para imprimir valores
def imprimirValores(valor1,valor2,valor3,valor4):
  listaTemporal = []
  
  print("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n")
  print(f"Dia mas Caluroso: ☀️   °C{valor1}")
  print(f"Dia mas frio: ❄️   °C{valor2}")
  print(f"Dia que superaron 25 grados: 🔥 #{valor3}")
 # print(f"Lista de temperaturas: 🌡️   {valor4}")
 
  for temp in valor4:
    listaTemporal.append(f"°C{temp}")
    
  print(f"Lista de temperaturas: 🌡️   {listaTemporal}")
    
  print("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n")
  
#Llamar a el API -> Asignar valores a variables
dia_mas_caluroso,dia_mas_frio,superaron25,temperaturas = obtener_datos_metereologicos(api_key,input("\nIngrese la ubicación a buscar: "))

#Imprimir los valores
imprimirValores(dia_mas_caluroso,dia_mas_frio,superaron25,temperaturas)
