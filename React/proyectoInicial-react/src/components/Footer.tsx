type FooterProps = {
  tituloFooter: string;
  //Definir una variable opcional
  colorFondo?: string;
};

export default function Footer({
  tituloFooter,
  colorFondo = "#ff0000 ",
}: FooterProps) {
  return (
    <footer style={{ padding: 16, backgroundColor: colorFondo }}>
      <h1 style={{ margin: 0 }}>{tituloFooter}</h1>
    </footer>
  );
}
