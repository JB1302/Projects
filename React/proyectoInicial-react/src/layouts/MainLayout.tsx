import type { ReactNode } from "react";
//Cargar el componente header.
import Header from "../components/Header";
//Cargar el componente Footer
import Footer from "../components/Footer";

type MainLayoutProps = {
  children: ReactNode;
};

export default function MainLayout({ children }: MainLayoutProps) {
  return (
    <div
      style={{
        fontFamily: "sans-serif",
        minHeight: "100vh",
        display: "flex",
        flexDirection: "column",
      }}
    >
      {/*Titulo del Componente*/}
      <Header titulo="Mi primera página en React" />

      <main style={{ padding: 16, flex: 1 }}>
        <div style={{ maxWidth: 1000, margin: "0 auto" }}>{children}</div>
      </main>

      <Footer
        tituloFooter="Este es el footer"
        //Esto puede o no estar
        //Si no usa default
        colorFondo="#030438"
      />
    </div>
  );
}
