type FilterBarProps = {
	categories: string[];
	selectedCategory: string;
	searchText: string;
	onCategoryChange: (value: string) => void;
	onSearchChange: (value: string) => void;
	onClear?: () => void;
};

export default function FilterBar({
	categories,
	selectedCategory,
	searchText,
	onCategoryChange,
	onSearchChange,
	onClear,
}: FilterBarProps) {
	return (
		<div className="mb-3">
			<div className="row g-2 align-items-center">
				{/* Categoría */}
				<div className="col-12 col-md-3">
					<select
						className="form-select"
						value={selectedCategory}
						onChange={(e) => onCategoryChange(e.target.value)}
						aria-label="Filtrar por categoría"
					>
						<option value="Todas">Categorías</option>
						{categories.map((cat) => (
							<option key={cat} value={cat}>
								{cat}
							</option>
						))}
					</select>
				</div>

				{/* Buscar */}
				<div className="col-12 col-md-9">
					<div className="input-group">
						<input
							type="text"
							className="form-control"
							placeholder="Buscar producto..."
							value={searchText}
							onChange={(e) => onSearchChange(e.target.value)}
							aria-label="Buscar producto"
						/>
						{onClear && (
							<button
								type="button"
								className="btn btn-outline-light"
								onClick={onClear}
							>
								Limpiar
							</button>
						)}
					</div>
				</div>
			</div>
		</div>
	);
}
