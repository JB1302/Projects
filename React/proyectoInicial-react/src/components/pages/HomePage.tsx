import { useState } from "react";
import Card from "../Card";

export default function HomePage() {
  const [mensaje, setMensaje] = useState<string>("Bienvenido");

  return (
    <>
      <h2>Inicio</h2>
      <p>{mensaje}</p>

      <Card titulo="Acciones">
        <button onClick={() => setMensaje("Cambiado ✅")}>
          Cambiar mensaje
        </button>
      </Card>

      <Card titulo="Notas">
        <p>Este contenido vive dentro del layout.</p>
      </Card>
    </>
  );
}
