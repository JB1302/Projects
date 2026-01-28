import { useEffect, useState } from "react";

export default function HomePage() {
	const [tituloPagina] = useState("Home");

	useEffect(() => {
		document.title = tituloPagina;
	}, [tituloPagina]);

	return (
		<div>
			<h1 className="text-center text-white">Hola Mundo</h1>
		</div>
	);
}
