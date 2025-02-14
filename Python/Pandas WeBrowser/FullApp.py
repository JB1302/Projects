import pandas as pd
import webbrowser
import urllib.parse

file_path = r"C:\Users\jstev\Desktop\Python\DBTesing.xlsx"
df = pd.read_excel(file_path, usecols=['DUNS_STREET_ADDR', 'DUNS_PSTL_CODE'], sheet_name='Testing')
longitud = len(df)

print(f"El archivo contiene {longitud} filas\n")

# Solicitar al usuario el índice inicial
while True:
    try:
        index = int(input("Favor digite el índice a utilizar: ")) # Solicitar al usuario un Número
        if 0 < index <= longitud: # Si el índice es válido
            contador = index
            break # Aceptar y salir del bucle
        else:
            print("Índice fuera del rango. Intenta de nuevo.")
    except ValueError:
        print("El valor ingresado no es un número. Intenta de nuevo.")

# Iniciar el proceso de búsqueda y actualización del contador
continuar = True

while continuar:
    # Verifica si el contador está dentro del rango válido
    if 0 < contador <= longitud:
        row = df.iloc[contador - 1]  # Obtener la fila actual según el contador

        dunsSTREET = row['DUNS_STREET_ADDR'] #Definir la direccion en una variable
        dunsZIP = str(row['DUNS_PSTL_CODE'])[:5] #Definir el ZIP en una variable
        fullAddress = (dunsSTREET + " " + dunsZIP) #Concatenarlo

        URLparaBuscar = f"https://www.google.com/search?q={urllib.parse.quote_plus(fullAddress)}" #Construir URL
        
        try:
            print(f"\nAbriendo: {URLparaBuscar}\n") #Indicar al usuario que se esta buscando
            webbrowser.open(URLparaBuscar)
        except Exception as e:
            print(f"An error occurred: {e}")

        # Solicitar al usuario si desea continuar
        checkStatus = input("¿Deseas continuar al siguiente índice? [Y/N]: ").strip().lower()

        if checkStatus == "y":
            contador += 1
            if contador > longitud:
                print("Has alcanzado el final del archivo.")
                continuar = False
            else:
                print(f"Contador actualizado a: {contador}")
        
        elif checkStatus == "n":
            print(f"El índice actual es {contador}. Proceso terminado.")
            continuar = False
        
        else:
            print("Entrada no válida. Por favor, ingresa 'Y' o 'N'.")
    
    else:
        print("El contador está fuera del rango del archivo.")
        continuar = False
