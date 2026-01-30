import { NavLink } from "react-router";

type HeaderProps = {
  titulo: string;
};

export default function Header({ titulo }: HeaderProps) {
  return (
    <header
      style={{
        padding: 16,
        borderBottom: "1px solid #ddd",
        backgroundColor: "#06022c",
      }}
    >
      <div
        style={{
          maxWidth: 1000,
          margin: "0 auto",
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
        }}
      >
        <h1
          style={{
            margin: 0,
            fontSize: "1.5rem",
            fontWeight: 700,
            color: "white",
          }}
        >
          {titulo}
        </h1>

        <nav style={{ display: "flex", gap: 12 }}>
          <NavLink
            to="/"
            end
            style={({ isActive }) => ({
              color: "white",
              textDecoration: "none",
              fontWeight: isActive ? "bold" : "normal",
            })}
          >
            Home
          </NavLink>

          <NavLink
            to="/api"
            style={({ isActive }) => ({
              color: "white",
              textDecoration: "none",
              fontWeight: isActive ? "bold" : "normal",
            })}
          >
            API
          </NavLink>
        </nav>
      </div>
    </header>
  );
}
