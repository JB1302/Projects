import type { ReactNode, CSSProperties } from "react"; // Tipos: contenido renderizable + estilos inline

type CardProps = {
  titulo?: string; // Título opcional
  children: ReactNode; // Contenido dentro del <Card>...</Card>
  actions?: ReactNode; // Zona opcional para botones/links
  style?: CSSProperties; // Estilos extra/sobrescritura desde afuera
};

export default function Card({ titulo, children, actions, style }: CardProps) {
  const baseStyle: CSSProperties = {
    padding: 16,
    border: "1px solid #ddd",
    borderRadius: 12,
    marginBottom: 12,
  };

  return (
    <section style={{ ...baseStyle, ...style }}>
      {" "}
      {/* Combina base + overrides */}
      {(titulo || actions) /* Header solo si hay título o actions */ && (
        <div
          style={{ display: "flex", justifyContent: "space-between", gap: 12 }}
        >
          {titulo && (
            <h3 style={{ marginTop: 0, marginBottom: 8 }}>{titulo}</h3>
          )}{" "}
          {/* Título */}
          {actions && <div>{actions}</div>} {/* Acciones */}
        </div>
      )}
      <div>{children}</div> {/* Cuerpo */}
    </section>
  );
}
