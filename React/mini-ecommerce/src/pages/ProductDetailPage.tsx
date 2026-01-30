import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import type { Product } from "../types/Product";
import { mapDummyToProduct } from "../api/dummyjsonAdapter";
import type { DummyJsonProduct } from "../api/dummyjsonAdapter";
import { useCart } from "../context/useCart";

export default function ProductDetailPage() {
	const { id } = useParams<{ id: string }>();

	const { dispatch } = useCart();

	const [product, setProduct] = useState<Product | null>(null);
	const [loading, setLoading] = useState<boolean>(true);
	const [error, setError] = useState<string | null>(null);

	const [qty, setQty] = useState<number>(1);
	const [selectedIndex, setSelectedIndex] = useState<number>(0);

	useEffect(() => {
		document.title = "Detalle del producto";
	}, []);

	useEffect(() => {
		let cancelled = false;

		const safe = (fn: () => void) => {
			if (!cancelled) fn();
		};

		async function load() {
			if (!id) {
				safe(() => {
					setError("Producto no encontrado");
					setProduct(null);
					setLoading(false);
				});
				return;
			}

			safe(() => {
				setLoading(true);
				setError(null);
			});

			try {
				const res = await fetch(`https://dummyjson.com/products/${id}`);
				if (!res.ok) throw new Error("Producto no encontrado");

				const data: DummyJsonProduct = await res.json();
				const mapped = mapDummyToProduct(data);

				safe(() => {
					setProduct(mapped);
				});
			} catch (e) {
				safe(() => {
					setError(e instanceof Error ? e.message : "Error cargando producto");
					setProduct(null);
				});
			} finally {
				safe(() => setLoading(false));
			}
		}

		load();

		return () => {
			cancelled = true;
		};
	}, [id]);

	if (loading) {
		return <p className="text-white-50">Cargando producto...</p>;
	}

	if (error || !product) {
		return (
			<div className="text-white">
				<h1>Producto no encontrado</h1>
				<p className="text-white-50">{error ?? "No existe."}</p>
				<Link to="/productos" className="btn btn-outline-light mt-3">
					Volver
				</Link>
			</div>
		);
	}

	// Galería: si viene una sola, repetimos para el layout
	const images = product.imageUrl
		? [product.imageUrl, product.imageUrl, product.imageUrl, product.imageUrl]
		: [];

	const mainImage = images[selectedIndex];
	const inStock = product.stock > 0;

	return (
		<div className="text-white">
			{/* top: breadcrumb + volver */}
			<div className="d-flex align-items-center justify-content-between mb-3">
				<div className="small text-white-50">
					<Link to="/productos" className="text-white-50 text-decoration-none">
						Productos
					</Link>
					<span className="mx-2">/</span>
					<span className="text-white">{product.name}</span>
				</div>

				<Link to="/productos" className="btn btn-outline-light btn-sm">
					Volver
				</Link>
			</div>

			<div className="row g-4">
				{/* IZQUIERDA: galería */}
				<div className="col-12 col-lg-7">
					<div className="card border-0 bg-white">
						<div className="card-body">
							<div
								className="d-flex align-items-center justify-content-center"
								style={{ minHeight: 380 }}
							>
								{mainImage ? (
									<img
										src={mainImage}
										alt={product.name}
										style={{
											maxWidth: "100%",
											maxHeight: 360,
											objectFit: "contain",
										}}
									/>
								) : (
									<div className="text-muted">Sin imagen</div>
								)}
							</div>

							{images.length > 0 && (
								<div className="d-flex gap-2 mt-3 flex-wrap">
									{images.map((img, idx) => (
										<button
											key={`${img}-${idx}`}
											type="button"
											onClick={() => setSelectedIndex(idx)}
											className={`p-0 border ${
												idx === selectedIndex ? "border-primary" : "border-0"
											}`}
											style={{
												width: 72,
												height: 72,
												borderRadius: 10,
												overflow: "hidden",
												background: "#f5f5f5",
											}}
											aria-label={`Imagen ${idx + 1}`}
										>
											<img
												src={img}
												alt=""
												style={{
													width: "100%",
													height: "100%",
													objectFit: "cover",
												}}
											/>
										</button>
									))}
								</div>
							)}
						</div>
					</div>
				</div>

				{/* DERECHA: info + acciones */}
				<div className="col-12 col-lg-5">
					<div className="card border-0 bg-white h-100">
						<div className="card-body">
							<div className="text-muted small mb-1">{product.brand}</div>

							<h2 className="fw-bold text-dark mb-2">{product.name}</h2>

							<div className="mb-2">
								<span className="text-warning">★★★★☆</span>
								<span className="text-muted small ms-2">(123)</span>
							</div>

							<div className="mb-3">
								<div className="fs-4 fw-bold text-primary">
									₡{product.price}
								</div>
							</div>

							<p className="text-muted small">
								Descripción breve del producto (placeholder).
							</p>

							<hr />

							<div className="row g-3 align-items-end">
								<div className="col-6">
									<div className="text-muted small mb-1">QTY</div>
									<div className="input-group">
										<button
											className="btn btn-outline-secondary"
											type="button"
											onClick={() => setQty((q) => Math.max(1, q - 1))}
										>
											-
										</button>
										<input
											className="form-control text-center"
											value={qty}
											onChange={(e) => {
												const n = Number(e.target.value);
												if (!Number.isNaN(n)) setQty(Math.max(1, n));
											}}
										/>
										<button
											className="btn btn-outline-secondary"
											type="button"
											onClick={() => setQty((q) => q + 1)}
										>
											+
										</button>
									</div>
								</div>

								<div className="col-6">
									<div className="text-muted small mb-1">Categoría</div>
									<div className="form-control bg-light">
										{product.category}
									</div>
								</div>
							</div>

							<div className="d-flex gap-2 mt-4">
								<button
									className="btn btn-warning flex-grow-1"
									disabled={!inStock}
									onClick={() =>
										dispatch({
											type: "ADD_ITEM",
											product,
											quantity: qty,
										})
									}
								>
									ADD TO CART
								</button>

								<button
									className="btn btn-outline-secondary"
									type="button"
									aria-label="Favorito"
								>
									♥
								</button>
							</div>

							<div className="mt-3">
								<span
									className={`badge ${inStock ? "bg-success" : "bg-danger"}`}
								>
									{inStock ? `Stock: ${product.stock}` : "Sin stock"}
								</span>
							</div>

							<div className="mt-4 text-muted small">
								SHARE IT <span className="ms-2">ⓕ ⓧ ⓘ</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	);
}
