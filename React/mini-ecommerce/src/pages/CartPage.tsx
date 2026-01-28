import { Link } from "react-router-dom";
import { useCart } from "../context/useCart";

export default function CartPage() {
	const { state, dispatch } = useCart();

	const itemsCount = state.items.reduce((acc, item) => acc + item.quantity, 0);

	const subtotal = state.items.reduce(
		(acc, item) => acc + item.product.price * item.quantity,
		0,
	);

	const setQty = (productId: string, quantity: number) => {
		dispatch({ type: "SET_QTY", productId, quantity });
	};

	const removeItem = (productId: string) => {
		dispatch({ type: "REMOVE_ITEM", productId });
	};

	const clearCart = () => {
		dispatch({ type: "CLEAR_CART" });
	};

	return (
		<div className="text-white">
			{/* Header */}
			<div className="d-flex align-items-center justify-content-between mb-3">
				<h1 className="m-0">Carrito</h1>

				<div className="d-flex gap-2">
					<Link to="/productos" className="btn btn-outline-light btn-sm">
						← Seguir comprando
					</Link>

					<button
						type="button"
						className="btn btn-outline-danger btn-sm"
						onClick={clearCart}
						disabled={state.items.length === 0}
					>
						Vaciar
					</button>
				</div>
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
							{state.items.map((item) => {
								const lineTotal = item.product.price * item.quantity;

								return (
									<div
										key={item.product.id}
										className="card mb-3 bg-dark bg-opacity-50 border-0"
									>
										<div className="card-body">
											<div className="d-flex justify-content-between align-items-center">
												{/* Left: product info */}
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
														<div className="text-white-50 small">
															₡{item.product.price} c/u
														</div>
													</div>
												</div>

												{/* Right: qty + total + remove */}
												<div className="d-flex align-items-center gap-3">
													<div className="d-flex align-items-center gap-2">
														<button
															type="button"
															className="btn btn-outline-light btn-sm"
															onClick={() =>
																setQty(item.product.id, item.quantity - 1)
															}
															aria-label="Disminuir cantidad"
														>
															−
														</button>

														<span
															className="text-white small"
															style={{ minWidth: 28, textAlign: "center" }}
														>
															<strong>{item.quantity}</strong>
														</span>

														<button
															type="button"
															className="btn btn-outline-light btn-sm"
															onClick={() =>
																setQty(item.product.id, item.quantity + 1)
															}
															aria-label="Aumentar cantidad"
														>
															+
														</button>
													</div>

													<div
														className="fw-semibold text-white"
														style={{ minWidth: 90, textAlign: "right" }}
													>
														₡{lineTotal}
													</div>

													<button
														type="button"
														className="btn btn-outline-danger btn-sm"
														onClick={() => removeItem(item.product.id)}
														aria-label="Eliminar item"
													>
														✕
													</button>
												</div>
											</div>
										</div>
									</div>
								);
							})}
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
							//Link a el boton de checkout
							<Link
								to="/checkout"
								className={`btn btn-primary w-100 ${
									state.items.length === 0 ? "disabled" : ""
								}`}
							>
								Ir a pagar
							</Link>
							{state.items.length === 0 && (
								<div className="text-white-50 small mt-2">
									Agregá productos para continuar.
								</div>
							)}
						</div>
					</div>

					{state.items.length > 0 && (
						<div className="text-white-50 small mt-2">
							Tip: Podés ajustar cantidades con +/− o eliminar con ✕.
						</div>
					)}
				</div>
			</div>
		</div>
	);
}
