import { Link } from "react-router-dom";
import { useCart } from "../context/useCart";

export default function CartPage() {
	const { state } = useCart();

	const itemsCount = state.items.reduce((acc, item) => acc + item.quantity, 0);

	const subtotal = state.items.reduce(
		(acc, item) => acc + item.product.price * item.quantity,
		0,
	);

	return (
		<div className="text-white">
			{/* Header */}
			<div className="d-flex align-items-center justify-content-between mb-3">
				<h1 className="m-0">Carrito</h1>

				<Link to="/productos" className="btn btn-outline-light btn-sm">
					← Seguir comprando
				</Link>
			</div>

			<div className="row g-4">
				{/* LEFT: items */}
				<div className="col-12 col-lg-7">
					<div className="card border-0 bg-dark bg-opacity-25">
						<div className="card-body">
							<div className="d-flex justify-content-between align-items-center mb-3">
								<div>
									<div className="fw-semibold text-light">Shopping cart</div>
									<div className="text-white-50 small">
										Tienes {itemsCount} item{itemsCount !== 1 && "s"} en tu
										carrito
									</div>
								</div>
							</div>

							<hr className="border-light border-opacity-25" />

							{/* EMPTY STATE */}
							{state.items.length === 0 && (
								<div className="text-center py-5">
									<div className="text-white-50 mb-2">
										Tu carrito está vacío
									</div>
									<Link to="/productos" className="btn btn-primary btn-sm">
										Ver productos
									</Link>
								</div>
							)}

							{/* ITEMS */}
							{state.items.map((item) => (
								<div
									key={item.product.id}
									className="card mb-3 bg-dark bg-opacity-50 border-0"
								>
									<div className="card-body">
										<div className="d-flex justify-content-between align-items-center">
											<div className="d-flex align-items-center gap-3">
												<img
													src={item.product.imageUrl}
													alt={item.product.name}
													style={{
														width: 64,
														height: 64,
														objectFit: "contain",
														borderRadius: 8,
													}}
												/>

												<div>
													<div className="fw-semibold text-light">
														{item.product.name}
													</div>
													<div className="text-white-50 small">
														{item.product.brand}
													</div>
												</div>
											</div>

											<div className="d-flex align-items-center gap-3">
												<div className=" text-white small">
													Cant: <strong>{item.quantity}</strong>
												</div>

												<div className="fw-semibold text-white">
													₡{item.product.price * item.quantity}
												</div>
											</div>
										</div>
									</div>
								</div>
							))}
						</div>
					</div>
				</div>

				{/* RIGHT: resumen */}
				<div className="col-12 col-lg-5">
					<div className="card border-0 bg-dark bg-opacity-25">
						<div className="card-body">
							<h5 className="mb-3 text-white">Resumen</h5>

							<hr className="border-light border-opacity-25" />

							<div className="d-flex justify-content-between mb-2">
								<span className="text-white-50">Subtotal</span>
								<span className="text-white">₡{subtotal}</span>
							</div>

							<div className="d-flex justify-content-between mb-2">
								<span className="text-white-50">Envío</span>
								<span className="text-white">₡0</span>
							</div>

							<hr className="border-light border-opacity-25" />

							<div className="d-flex justify-content-between align-items-center mb-3">
								<span className="fw-bold text-white">Total</span>
								<span className="fw-bold fs-5 text-white">₡{subtotal}</span>
							</div>

							<button
								className="btn btn-primary w-100"
								disabled={state.items.length === 0}
							>
								Ir a pagar
							</button>

							{state.items.length === 0 && (
								<div className="text-white-50 small mt-2">
									Agregá productos para continuar.
								</div>
							)}
						</div>
					</div>
				</div>
			</div>
		</div>
	);
}
