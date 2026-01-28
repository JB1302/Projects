import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

export default function HomePage() {
	const [tituloPagina] = useState("Home");

	useEffect(() => {
		document.title = tituloPagina;
	}, [tituloPagina]);

	return (
		<div className="text-white">
			{/* HERO */}
			<section className="py-3">
				<div className="card border-0 bg-dark bg-opacity-25">
					<div className="card-body p-4 p-md-5">
						<div className="row align-items-center g-4">
							<div className="col-12 col-lg-7">
								<h1 className="fw-bold text-light display-6 mb-2">
									Compra rápido, filtra fácil,
									<br className="d-none d-md-block" />y compartí enlaces con
									URL.
								</h1>

								<p className="text-white-50 mb-4">
									Explorá productos, buscá por texto, filtrá por categoría y
									navegá por páginas. Cada vista se mantiene en el URL para que
									podás compartirla.
								</p>

								<div className="d-flex flex-wrap gap-2">
									<Link to="/productos" className="btn btn-primary">
										Ver productos
									</Link>

									<Link to="/carrito" className="btn btn-outline-light">
										Ir al carrito
									</Link>
								</div>
							</div>

							<div className="col-12 col-lg-5">
								<div className="card border-0 bg-dark bg-opacity-50">
									<div className="d-flex justify-content-between align-items-center mb-3">
										<span className="text-white-50">
											Mira nuestro catalogo!
										</span>
									</div>

									<div className="card-body">
										<img
											src="https://d30gl8nkrjm6kp.cloudfront.net/articulos/articulos-351717.jpg"
											alt="Vista catálogo"
											className="rounded-3 mb-3 w-100"
											style={{
												background: "rgba(255,255,255,0.06)",
												height: 160,
											}}
										/>

										<hr className="border-light border-opacity-25" />

										<div className="d-flex justify-content-between"></div>

										<div className="d-grid mt-3">
											<Link
												to="/productos"
												className="btn btn-outline-light btn-sm"
											>
												Entrar al catálogo
											</Link>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>

			{/* FEATURES */}
			<section className="pb-5">
				<div className="row g-3">
					<div className="col-12 col-md-4">
						<div className="card border-0 bg-dark bg-opacity-25 h-100">
							<div className="card-body">
								<div className="fw-semibold text-light mb-1">
									Filtros dinámicos
								</div>
								<div className="text-white-50 small">
									Las categorías se generan desde la data, sin hardcode.
								</div>
							</div>
						</div>
					</div>

					<div className="col-12 col-md-4">
						<div className="card border-0 bg-dark bg-opacity-25 h-100">
							<div className="card-body">
								<div className="fw-semibold text-light mb-1">Búsqueda live</div>
								<div className="text-white-50 small">
									Filtrás por texto mientras escribís sin romper paginación.
								</div>
							</div>
						</div>
					</div>

					<div className="col-12 col-md-4">
						<div className="card border-0 bg-dark bg-opacity-25 h-100">
							<div className="card-body">
								<div className="fw-semibold text-light mb-1">
									Detalle de producto
								</div>
								<div className="text-white-50 small">
									Ruta dinámica{" "}
									<code className="text-white">/productos/:id</code> con vista
									tipo e-commerce.
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	);
}
