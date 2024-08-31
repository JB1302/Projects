import pandas as pd
import webbrowser
import urllib.parse
import tkinter as tk
from tkinter import messagebox
import os

# Ruta al archivo Excel
file_path = r"C:\Users\jstev\Desktop\Python\DBTesing.xlsx" #Filepath

# Extraer el nombre del archivo sin la extensión
file_name = os.path.basename(file_path).split('.')[0]

# Función para leer datos del archivo Excel
def load_data():
    global df, longitud
    try:
        df = pd.read_excel(file_path, usecols=['DUNS_STREET_ADDR', 'DUNS_PSTL_CODE'], sheet_name='Testing') #Definir base de datos
        longitud = len(df) #Definir la longitud

        # Actualizar el texto del Label con la longitud
        max_index_label.config(text=f"Total de Columnas: {longitud}")
        file_name_label.config(text=f"Archivo: {file_name}")
        messagebox.showinfo("Información", f"El archivo contiene {longitud} filas")

    except Exception as e:
        messagebox.showerror("Error", f"Error al leer el archivo Excel: {e}")

# Función para realizar la búsqueda
def search():
    global contador
    try:
        index = int(index_entry.get()) 
        if 0 < index <= longitud:
            contador = index 
            process_search()
        else:
            messagebox.showwarning("Advertencia", "Índice fuera del rango. Intenta de nuevo.")
    except ValueError:
        messagebox.showwarning("Advertencia", "El valor ingresado no es un número. Intenta de nuevo.")

# Función para procesar la búsqueda y abrir URL
def process_search():
    global contador
    if 0 < contador <= longitud:
        row = df.iloc[contador - 1]
        dunsSTREET = row['DUNS_STREET_ADDR'] #Variable para almacenar el Address
        dunsZIP = str(row['DUNS_PSTL_CODE'])[:5] #Variable para almacenar el ZIP
        fullAddress = f"{dunsSTREET} {dunsZIP}" #Concatenarlos
        URLparaBuscar = f"https://www.google.com/search?q={urllib.parse.quote_plus(fullAddress)}" #Constructor de address
        try:
            webbrowser.open(URLparaBuscar)
            response = messagebox.askyesno("Continuar", "¿Deseas continuar al siguiente índice?") #Seguir con la busqueda?
            if response:
                contador += 1 #Aumentar el indice 
                if contador > longitud: 
                    messagebox.showinfo("Información", "Has alcanzado el final del archivo.") #Limite del archivo
                else:
                    index_entry.delete(0, tk.END)
                    index_entry.insert(0, str(contador))
            else:
                messagebox.showinfo("Información", f"El índice actual es {contador}. Proceso terminado.")
        except Exception as e:
            messagebox.showerror("Error", f"Se produjo un error al intentar abrir la URL: {e}")
    else:
        messagebox.showwarning("Advertencia", "El contador está fuera del rango del archivo.")

# Crear la ventana principal
root = tk.Tk()
root.title("Buscador de Direcciones")
root.geometry("390x245")  # Ajustar el tamaño de la ventana
root.config(bg='white')  # Cambiar el color de fondo a blanco

# Crear widgets
load_button1 = tk.Button(root, text="Web Searcher", command=load_data, bg='#0c2d48', fg='white', font=('Roboto', 12, 'bold'), width=50, height=1, borderwidth=0)  # Botón de Excel
load_button1.pack(pady=(10, 10))

# Frame para los Labels
labels_frame = tk.Frame(root, bg='white')
labels_frame.pack(pady=(5, 10))

# Frame para "Total de Columnas" y "Archivo"
info_frame = tk.Frame(labels_frame, bg='white')
info_frame.pack(side=tk.TOP, fill=tk.X, pady=5)

max_index_label = tk.Label(info_frame, text="Total de Columnas: 0", font=('Roboto', 10), fg='#2e8bc0', bg='white')
max_index_label.pack(side=tk.LEFT)

file_name_label = tk.Label(info_frame, text="Archivo: ", font=('Roboto', 10), fg='#2e8bc0', bg='white')
file_name_label.pack(side=tk.LEFT)

# Frame para "Índice"
index_frame = tk.Frame(labels_frame, bg='white')
index_frame.pack(side=tk.TOP, fill=tk.X, pady=5)

index_label = tk.Label(index_frame, text="Índice:", font=('Roboto', 10), fg='#145da0', bg='white')
index_label.pack(side=tk.LEFT, padx=(0, 20))

index_entry = tk.Entry(root, font=('Roboto', 12), fg='#2e8bc0', bd=5, relief="groove", width=26)  # Sección de Texto
index_entry.pack(pady=(0, 5))  # Márgenes abajo

search_button = tk.Button(root, text="Buscar", command=search, bg='#2e8bc0', fg='white', font=('Roboto', 10), width=10, borderwidth=0)  # Botón de Buscar
search_button.pack(pady=(5, 25))

# Crear un Frame para el botón "Cargar Archivo Excel" y ajustarlo para ocupar toda la parte inferior
bottom_frame = tk.Frame(root, bg='#0c2d48')
bottom_frame.pack(side=tk.BOTTOM, fill=tk.X)

load_button = tk.Button(bottom_frame, text="Cargar Archivo Excel", command=load_data, bg='#0c2d48', fg='white', font=('Roboto', 12, 'bold'), width=50, borderwidth=0)  # Botón de Excel
load_button.pack(fill=tk.X, pady=(5, 5))  # El botón ocupa todo el ancho disponible del frame

# Variables globales
df = pd.DataFrame()
longitud = 0
contador = 1

# Cargar datos al iniciar la aplicación
load_data()

# Ejecutar la aplicación
root.mainloop()
