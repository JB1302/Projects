import { StrictMode } from "react"; // Modo estricto: ayuda a detectar problemas en desarrollo
import { createRoot } from "react-dom/client"; // Crea la “raíz” donde React renderiza
import { BrowserRouter } from "react-router"; // Habilita navegación por URL (rutas) sin recargar
import "./index.css"; // Carga estilos globales
import App from "./App"; // Importa el componente raíz de la app

// Busca el <div id="root"> del index.html y monta React ahí
createRoot(document.getElementById("root")!).render(
  <StrictMode>
    {/* Envuelve la app para que Routes/NavLink/etc funcionen */}
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </StrictMode>,
);
