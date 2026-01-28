import { useEffect } from "react";
import { Link } from "react-router-dom";
import { useCart } from "../context/useCart";

export default function CheckoutPage() {
	const { state, dispatch } = useCart();

	useEffect(() => {
		document.title = "Checkout";
	}, []);

	const itemsCount = state.items.reduce(
		(acc: number, item) => acc + item.quantity,
		0,
	);

	const subtotal = state.items.reduce(
		(acc: number, item) => acc + item.product.price * item.quantity,
		0,
	);

	// Skeleton: por ahora dejamos envío e impuestos en 0
	const shipping = 0;
	const taxes = 0;
	const total = subtotal + shipping + taxes;

	const isEmpty = state.items.length === 0;

	return (
		<div className="text-white">
			{/* Header */}
			<div className="d-flex align-items-center justify-content-between mb-3">
				<h1 className="m-0">Checkout</h1>

				<div className="d-flex gap-2">
					<Link to="/carrito" className="btn btn-outline-light btn-sm">
						← Volver al carrito
					</Link>

					<button
						type="button"
						className="btn btn-outline-danger btn-sm"
						onClick={() => dispatch({ type: "CLEAR_CART" })}
						disabled={isEmpty}
					>
						Vaciar carrito
					</button>
				</div>
			</div>

			<div className="row g-4">
				{/* LEFT: formulario */}
				<div className="col-12 col-lg-7">
					<div className="card border-0 bg-dark bg-opacity-25">
						<div className="card-body p-4">
							<h5 className="mb-3 text-white">Datos de envío</h5>
							<p className="text-white-50 small mb-4">
								Esqueleto de checkout (sin validaciones ni pago real aún).
							</p>

							<form>
								<div className="row g-3">
									<div className="col-12 col-md-6">
										<label className="form-label text-white">Nombre</label>
										<input
											type="text"
											className="form-control"
											placeholder="Tu nombre"
											disabled={isEmpty}
										/>
									</div>

									<div className="col-12 col-md-6">
										<label className="form-label text-white">Apellidos</label>
										<input
											type="text"
											className="form-control"
											placeholder="Tus apellidos"
											disabled={isEmpty}
										/>
									</div>

									<div className="col-12">
										<label className="form-label text-white">Email</label>
										<input
											type="email"
											className="form-control"
											placeholder="tu@email.com"
											disabled={isEmpty}
										/>
									</div>

									<div className="col-12 col-md-6">
										<label className="form-label text-white">Teléfono</label>
										<input
											type="tel"
											className="form-control"
											placeholder="8888-8888"
											disabled={isEmpty}
										/>
									</div>

									<div className="col-12 col-md-6">
										<label className="form-label text-white">Provincia</label>
										<select className="form-select" disabled={isEmpty}>
											<option>San José</option>
											<option>Alajuela</option>
											<option>Cartago</option>
											<option>Heredia</option>
											<option>Guanacaste</option>
											<option>Puntarenas</option>
											<option>Limón</option>
										</select>
									</div>

									<div className="col-12">
										<label className="form-label text-white">Dirección</label>
										<input
											type="text"
											className="form-control"
											placeholder="Dirección exacta"
											disabled={isEmpty}
										/>
									</div>

									<div className="col-12 col-md-6">
										<label className="form-label text-white">
											Ciudad / Cantón
										</label>
										<input
											type="text"
											className="form-control"
											placeholder="Cantón"
											disabled={isEmpty}
										/>
									</div>

									<div className="col-12 col-md-6">
										<label className="form-label text-white">
											Código postal
										</label>
										<input
											type="text"
											className="form-control"
											placeholder="Opcional"
											disabled={isEmpty}
										/>
									</div>

									<div className="col-12">
										<label className="form-label text-white">Notas</label>
										<textarea
											className="form-control"
											placeholder="Indicaciones para el mensajero (opcional)"
											rows={3}
											disabled={isEmpty}
										/>
									</div>
								</div>

								<hr className="border-light border-opacity-25 my-4" />

								<h5 className="mb-3 text-white">Pago</h5>

								<div className="row g-3">
									<div className="col-12">
										<label className="form-label text-white">
											Nombre en la tarjeta
										</label>
										<input
											type="text"
											className="form-control"
											placeholder="Como aparece en la tarjeta"
											disabled={isEmpty}
										/>
									</div>

									<div className="col-12">
										<label className="form-label text-white">
											Número de tarjeta
										</label>
										<input
											type="text"
											className="form-control"
											placeholder="1234 5678 9012 3456"
											disabled={isEmpty}
										/>
									</div>

									<div className="col-6 col-md-4">
										<label className="form-label text-white">Expira</label>
										<input
											type="text"
											className="form-control"
											placeholder="MM/YY"
											disabled={isEmpty}
										/>
									</div>

									<div className="col-6 col-md-4">
										<label className="form-label text-white">CVV</label>
										<input
											type="password"
											className="form-control"
											placeholder="•••"
											disabled={isEmpty}
										/>
									</div>

									<div className="col-12 col-md-4">
										<label className="form-label text-white">Método</label>
										<select className="form-select" disabled={isEmpty}>
											<option>Tarjeta</option>
											<option>Sinpe móvil (próximamente)</option>
											<option>Transferencia (próximamente)</option>
										</select>
									</div>
								</div>

								<div className="text-white-50 small mt-3">
									* Esto es un esqueleto. No procesa pagos reales.
								</div>
							</form>
						</div>
					</div>
				</div>

				{/* RIGHT: resumen */}
				<div className="col-12 col-lg-5">
					<div className="card border-0 bg-dark bg-opacity-25">
						<div className="card-body p-4">
							<div className="d-flex justify-content-between align-items-center mb-2">
								<h5 className="m-0 text-white">Resumen</h5>
								<span className="badge bg-secondary">
									{itemsCount} item{itemsCount !== 1 && "s"}
								</span>
							</div>

							<hr className="border-light border-opacity-25" />

							{/* Lista compacta */}
							{state.items.length === 0 ? (
								<div className="text-center py-4">
									<div className="text-white-50 mb-2">
										No hay productos para pagar
									</div>
									<Link to="/productos" className="btn btn-primary btn-sm">
										Ver productos
									</Link>
								</div>
							) : (
								<div className="d-flex flex-column gap-2 mb-3">
									{state.items.map((item) => (
										<div
											key={item.product.id}
											className="d-flex justify-content-between align-items-center"
										>
											<div className="me-2">
												<div className="text-white small fw-semibold">
													{item.product.name}
												</div>
												<div className="text-white-50 small">
													x{item.quantity}
												</div>
											</div>
											<div className="text-white small">
												₡{item.product.price * item.quantity}
											</div>
										</div>
									))}
								</div>
							)}

							<hr className="border-light border-opacity-25" />

							<div className="d-flex justify-content-between mb-2">
								<span className="text-white-50">Subtotal</span>
								<span className="text-white">₡{subtotal}</span>
							</div>

							<div className="d-flex justify-content-between mb-2">
								<span className="text-white-50">Envío</span>
								<span className="text-white">₡{shipping}</span>
							</div>

							<div className="d-flex justify-content-between mb-3">
								<span className="text-white-50">Impuestos</span>
								<span className="text-white">₡{taxes}</span>
							</div>

							<hr className="border-light border-opacity-25" />

							<div className="d-flex justify-content-between align-items-center mb-3">
								<span className="fw-bold text-white">Total</span>
								<span className="fw-bold fs-5 text-white">₡{total}</span>
							</div>

							<button
								type="button"
								className="btn btn-primary w-100"
								disabled={isEmpty}
							>
								Confirmar pedido
							</button>

							{isEmpty && (
								<div className="text-white-50 small mt-2">
									Agregá productos al carrito para continuar.
								</div>
							)}

							<div className="text-white-50 small mt-3">
								<Link to="/carrito" className="text-white text-decoration-none">
									← Editar carrito
								</Link>
							</div>
						</div>
					</div>

					<div className="text-white-50 small mt-3">
						Siguiente paso: conectar validaciones + enviar pedido a una API
						.NET.
					</div>
				</div>
			</div>
		</div>
	);
}
