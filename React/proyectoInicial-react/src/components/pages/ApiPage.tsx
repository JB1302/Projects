import Card from "../Card";
import { useEffect, useState } from "react";

type User = {
  id: number;
  name: string;
  email: string;
};

export default function ApiPage() {
  //Estados

  //Esto nos indicara si los datos se estan cargando
  const [loading, setLoading] = useState(false);
  //errores
  const [error, setError] = useState<string | null>(null);
  //Objetos recibidos del API en un arreglo de DTOs
  const [users, setUsers] = useState<User[]>([]);

  //Metodo de fetch
  async function cargar() {
    try {
      setLoading(true);
      setError(null);

      //Direccion del API
      const res = await fetch("https://jsonplaceholder.typicode.com/users");

      // Devolver que paso bien:
      if (!res.ok) {
        throw new Error(`HTTP ${res.status}`);
      }

      //guardar la data del api en un json
      //bajo un arreglo de DTOs sacados de USER
      const data = (await res.json()) as User[];
      //guardamos un arreglo nuevo con la data
      setUsers(data);

      //En caso de error
    } catch (e) {
      //guardamos el error y lo presentamos
      setError(e instanceof Error ? e.message : "Error desconocido");

      //Desactivamos el tiempo de espera
    } finally {
      setLoading(false);
    }
  }

  //Cargar automaticamente la data de la api al llamar la vista
  useEffect(() => {
    cargar();
  }, []);

  return (
    <>
      <h2>API</h2>

      {/* Llamamos al componente card :
            -Titulo
            -boton conectado al metodo cargar
            -Se desactivara hasta que el estado de loading sea false
      */}
      <Card
        titulo="Usuarios"
        actions={
          <button onClick={cargar} disabled={loading}>
            {loading ? "Cargando..." : "Refrescar"}
          </button>
        }
      >
        {/*Si falla poner boton rojo y marcar error*/}
        {error && <p style={{ color: "crimson" }}>Error: {error}</p>}

        {/*Si no falla pero no hay data marcar error*/}
        {!error && !loading && users.length === 0 && <p>No hay datos.</p>}

        {/*Definimos una lista:
            -Recorre todo el arreglo
            -Cada KEY de la lista se convierte en un elemento de lista
            - Mostramos Usuario.Nombre y Usuario.Email
        */}

        <ul>
          {users.map((u) => (
            <li key={u.id}>
              <li key={u.id}>
                <strong>{u.name}</strong>
                <div>{u.email}</div>
              </li>
            </li>
          ))}
        </ul>
      </Card>
    </>
  );
}
