type CardProps = {
	name: string;
	category: string;
	price: number;
	stock: number;
	brand: string;
	imageUrl?: string;
};

export default function Card({
	name,
	category,
	price,
	stock,
	brand,
	imageUrl,
}: CardProps) {
	return (
		<div className="card h-100">
			<img
				className="card-img-top"
				src={imageUrl}
				alt=""
				width={40}
				style={{ borderRadius: 8 }}
			/>

			<div className="card-body p-0">
				<h6 className="card-title fw-bold mt-1">{name}</h6>

				<div className="small mb-3">
					<span className="fw-semibold">Precio: ₡{price}</span>
				</div>

				<div className="mt-auto mb-3 d-flex gap-2 justify-content-center">
					<button className="btn btn-sm btn-outline-primary">Detalles</button>
					<button className="btn btn-sm btn-success">Agregar</button>
				</div>

				<div className="small d-flex justify-content-center gap-2 flex-wrap">
					<span className="badge bg-light text-dark">{category}</span>
					<span className="badge bg-light text-dark">{brand}</span>
					<span className="badge bg-secondary">Stock: {stock}</span>
				</div>
			</div>
		</div>
	);
}
