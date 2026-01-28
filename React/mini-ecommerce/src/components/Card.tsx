type CardProps = {
	name: string;
	category: string;
	price: number;
	stock: number;
	brand: string;
	imageUrl?: string;
	onAdd?: () => void;
	onDetails?: () => void;
};

export default function Card({
	name,
	category,
	price,
	stock,
	brand,
	imageUrl,
	onDetails,
	onAdd,
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
					<button
						type="button"
						className="btn btn-sm btn-outline-primary"
						onClick={onDetails}
					>
						Detalles
					</button>

					<button
						type="button"
						className="btn btn-sm btn-success"
						onClick={onAdd}
						disabled={stock === 0}
					>
						Agregar
					</button>
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
