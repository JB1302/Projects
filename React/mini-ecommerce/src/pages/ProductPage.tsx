import { useEffect, useState } from "react";
import { products } from "../data/Products";
import Card from "../components/Card";

export default function ProductosPage() {
	const [tituloPagina] = useState("Productos");

	useEffect(() => {
		document.title = tituloPagina;
	}, [tituloPagina]);
	return (
		<div>
			<h1 className="text-center text-white">Productos</h1>
			{/* Utilizar la data en la base de datos */}
			<p className="text-white">Total de Productos: {products.length}</p>

			<div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-3 g-3">
				{products.map((product) => (
					<div key={product.id} className="col">
						<Card
							name={product.name}
							category={product.category}
							price={product.price}
							stock={product.stock}
							brand={product.brand}
							imageUrl={product.imageUrl}
						/>
					</div>
				))}
			</div>
		</div>
	);
}
