import { useEffect, useMemo } from "react";
import { useSearchParams } from "react-router-dom";
import { products } from "../data/Products";
import Card from "../components/Card";
import FilterBar from "../components/FilterBar";
import Pagination from "../components/Pagination";
import { Link } from "react-router-dom";

export default function ProductPage() {
	const [searchParams, setSearchParams] = useSearchParams();

	// ✅ leer desde URL (con defaults)
	const currentPage = Number(searchParams.get("page") ?? "1");
	const categoriaSeleccionada = searchParams.get("cat") ?? "Todas";
	const textoBusqueda = searchParams.get("q") ?? "";

	const pageSize = 20;

	useEffect(() => {
		document.title = "Productos";
	}, []);

	const categories = useMemo(() => {
		return Array.from(
			new Set(products.map((p) => p.category).filter(Boolean)),
		).sort();
	}, []);

	const productosFiltrados = products.filter((p) => {
		const coincideCategoria =
			categoriaSeleccionada === "Todas" || p.category === categoriaSeleccionada;

		const coincideTexto =
			textoBusqueda.trim() === "" ||
			p.name.toLowerCase().includes(textoBusqueda.trim().toLowerCase());

		return coincideCategoria && coincideTexto;
	});

	const totalItems = productosFiltrados.length;
	const totalPages = Math.max(1, Math.ceil(totalItems / pageSize));

	// ✅ si el URL trae page inválida, lo corregimos (ej: filtros bajan totalPages)
	useEffect(() => {
		if (currentPage < 1 || currentPage > totalPages) {
			setSearchParams((prev) => {
				const next = new URLSearchParams(prev);
				next.set("page", "1");
				return next;
			});
		}
	}, [currentPage, totalPages, setSearchParams]);

	const safePage = Math.min(Math.max(currentPage, 1), totalPages);
	const startIndex = (safePage - 1) * pageSize;
	const productosPaginados = productosFiltrados.slice(
		startIndex,
		startIndex + pageSize,
	);

	// ✅ handlers que actualizan el URL
	const handleCategoryChange = (value: string) => {
		setSearchParams((prev) => {
			const next = new URLSearchParams(prev);
			next.set("cat", value);
			next.set("page", "1"); // al cambiar filtro, volver a 1
			return next;
		});
	};

	const handleSearchChange = (value: string) => {
		setSearchParams((prev) => {
			const next = new URLSearchParams(prev);
			next.set("q", value);
			next.set("page", "1"); // al buscar, volver a 1
			return next;
		});
	};

	const handlePageChange = (page: number) => {
		setSearchParams((prev) => {
			const next = new URLSearchParams(prev);
			next.set("page", String(page));
			return next;
		});
	};

	const limpiar = () => {
		setSearchParams({ page: "1", cat: "Todas", q: "" });
	};

	return (
		<div>
			<h1 className="text-center text-white">Productos</h1>

			<FilterBar
				categories={categories}
				selectedCategory={categoriaSeleccionada}
				searchText={textoBusqueda}
				onCategoryChange={handleCategoryChange}
				onSearchChange={handleSearchChange}
				onClear={limpiar}
			/>

			<div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-3 g-3">
				{productosPaginados.map((product) => (
					<div key={product.id} className="col">
						<Link
							to={`/productos/${product.id}`}
							className="text-decoration-none text-dark"
						>
							<Card
								name={product.name}
								category={product.category}
								price={product.price}
								stock={product.stock}
								brand={product.brand}
								imageUrl={product.imageUrl}
							/>
						</Link>
					</div>
				))}
			</div>

			<Pagination
				currentPage={safePage}
				totalPages={totalPages}
				onPageChange={handlePageChange}
			/>
		</div>
	);
}
