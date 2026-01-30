import { Routes, Route, Outlet } from "react-router"; // Componentes del router:
// definir rutas y el “hueco” (Outlet) donde se renderiza la página
import MainLayout from "./layouts/MainLayout"; // Layout general (Header/Main/Footer)
import HomePage from "./components/pages/HomePage"; // Página para la ruta "/"
import ApiPage from "./components/pages/ApiPage"; // Página para la ruta "/api"

//Basicamente rodeamos el outlet con el layout.
//La vista selecta sera la que se mostrara bajo de esto.

//La pagina que se defina como outlet, sa
export default function App() {
  return (
    <Routes>
      {/* Ruta “padre”: envuelve las rutas hijas con el layout */}
      <Route
        element={
          // Este elemento se renderiza siempre que coincida cualquier ruta hija
          <MainLayout>
            {/* Outlet = aquí se inserta la página hija que corresponda */}
            <Outlet />
          </MainLayout>
        }
      >
        {/* Ruta índice: corresponde a "/" */}
        <Route index element={<HomePage />} />

        {/* Ruta hija: corresponde a "/api" */}
        <Route path="api" element={<ApiPage />} />
      </Route>
    </Routes>
  );
}
