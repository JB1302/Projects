import NavItem from "./NavItems";
import NavButton from "./NavButtons";

export default function Header() {
	return (
		<nav
			style={{ backgroundColor: "#01011c" }}
			className="navbar navbar-expand-lg navbar-dark text-white py-4"
		>
			<div className="container-fluid">
				<a className="navbar-brand" href="#">
					<img
						src="https://getbootstrap.com/docs/5.1/assets/brand/bootstrap-logo.svg"
						alt="Logo"
						width="48"
						height="48"
					/>
				</a>

				<button
					className="navbar-toggler"
					type="button"
					data-bs-toggle="collapse"
					data-bs-target="#nav_lc"
					aria-controls="nav_lc"
					aria-expanded="false"
					aria-label="Toggle navigation"
				>
					<span className="navbar-toggler-icon"></span>
				</button>

				<div className="collapse navbar-collapse" id="nav_lc">
					<ul className="navbar-nav my-3 my-lg-0 ms-lg-3 me-auto">
						<NavItem to="/">Inicio</NavItem>

						<NavItem to="/productos">Productos</NavItem>
					</ul>

					<div className="d-flex align-items-center gap-2">
						<NavButton to="/carrito" variant="outline-light">
							🛒 Carrito
						</NavButton>

						<NavButton to="/login" variant="primary">
							Iniciar sesión
						</NavButton>
					</div>
				</div>
			</div>
		</nav>
	);
}
