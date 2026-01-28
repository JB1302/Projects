//Elementos a recibir
type PaginationProps = {
	currentPage: number;
	totalPages: number;
	onPageChange: (page: number) => void;
};

export default function Pagination({
	currentPage,
	totalPages,
	onPageChange,
}: PaginationProps) {
	if (totalPages <= 1) return null;

	//Recibe la pagina a mostrar
	const goTo = (page: number) => {
		//Este metodo hace que
		// math.min nunca sea mas grande que el total
		// math.max nunca menor que uno
		const clamped = Math.max(1, Math.min(totalPages, page));
		onPageChange(clamped);
	};

	return (
		<nav className="d-flex justify-content-center mt-4">
			<ul className="pagination">
				<li className={`page-item ${currentPage === 1 ? "disabled" : ""}`}>
					<button className="page-link" onClick={() => goTo(currentPage - 1)}>
						Anterior
					</button>
				</li>

				{Array.from({ length: totalPages }, (_, i) => i + 1).map((page) => (
					<li
						key={page}
						className={`page-item ${page === currentPage ? "active" : ""}`}
					>
						<button className="page-link" onClick={() => goTo(page)}>
							{page}
						</button>
					</li>
				))}

				<li
					className={`page-item ${currentPage === totalPages ? "disabled" : ""}`}
				>
					<button className="page-link" onClick={() => goTo(currentPage + 1)}>
						Siguiente
					</button>
				</li>
			</ul>
		</nav>
	);
}
