import { useEffect } from "react";
import { Link } from "react-router-dom";

export default function LoginPage() {
	useEffect(() => {
		document.title = "Iniciar sesión";
	}, []);

	return (
		<div className="text-white d-flex justify-content-center">
			<section className="w-100" style={{ maxWidth: 420 }}>
				<div className="card border-0 bg-dark bg-opacity-25 mt-5">
					<div className="card-body p-4 p-md-5">
						<h1 className="h4 fw-bold text-light mb-1 text-center">
							Iniciar sesión
						</h1>

						<p className="text-white-50 mb-4 text-center">
							Esqueleto de login (sin autenticación).
						</p>

						<form>
							{/* Email */}
							<div className="mb-3">
								<label className="form-label text-white">Email</label>
								<input
									type="email"
									className="form-control"
									placeholder="tu@email.com"
								/>
							</div>

							{/* Password */}
							<div className="mb-3">
								<label className="form-label text-white">Contraseña</label>
								<input
									type="password"
									className="form-control"
									placeholder="••••••••"
								/>
							</div>

							<div className="d-flex justify-content-between align-items-center mb-3">
								<div className="form-check">
									<input
										className="form-check-input"
										type="checkbox"
										id="rememberMe"
										defaultChecked
									/>
									<label
										className="form-check-label text-white-50"
										htmlFor="rememberMe"
									>
										Recordarme
									</label>
								</div>

								<button
									type="button"
									className="btn btn-link p-0 text-white text-decoration-none"
								>
									¿Olvidaste tu contraseña?
								</button>
							</div>

							<button type="submit" className="btn btn-primary w-100 mb-3">
								Ingresar
							</button>

							<hr className="border-light border-opacity-25 my-4" />

							<div className="text-center text-white-50 small mt-4">
								¿No tenés cuenta?{" "}
								<Link to="/" className="text-white text-decoration-none">
									Volver al inicio
								</Link>
							</div>
						</form>
					</div>
				</div>
			</section>
		</div>
	);
}
