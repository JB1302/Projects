import { useEffect, useMemo, useState } from "react";
import Card from "../components/Card";
import FilterBar from "../components/FilterBar";
import Pagination from "../components/Pagination";
import { useCart } from "../context/useCart";
import { useNavigate, useSearchParams } from "react-router-dom";
import type { Product } from "../types/Product";
import { fetchProducts } from "../api/productsApi";

export default function ProductPage() {
	const [searchParams, setSearchParams] = useSearchParams();

	// ✅ leer desde URL (con defaults)
	const currentPage = Number(searchParams.get("page") ?? "1");
	const categoriaSeleccionada = searchParams.get("cat") ?? "Todas";
	const textoBusqueda = searchParams.get("q") ?? "";

	const pageSize = 12;

	// ✅ state para API
	const [items, setItems] = useState<Product[]>([]);
	const [total, setTotal] = useState<number>(0);
	const [loading, setLoading] = useState<boolean>(false);
	const [error, setError] = useState<string | null>(null);

	useEffect(() => {
		document.title = "Productos";
	}, []);

	// ✅ cargar desde API cuando cambie page/q/cat
	useEffect(() => {
		let cancelled = false;

		const safe = (fn: () => void) => {
			if (!cancelled) fn();
		};

		async function load() {
			safe(() => {
				setLoading(true);
				setError(null);
			});

			try {
				const result = await fetchProducts({
					page: currentPage,
					pageSize,
					q: textoBusqueda,
					cat: categoriaSeleccionada,
				});

				safe(() => {
					setItems(result.items);
					setTotal(result.total);
				});
			} catch (e) {
				safe(() => {
					setError(e instanceof Error ? e.message : "Error desconocido");
				});
			} finally {
				safe(() => {
					setLoading(false);
				});
			}
		}

		load();

		return () => {
			cancelled = true;
		};
	}, [currentPage, pageSize, textoBusqueda, categoriaSeleccionada]);

	// ✅ totalPages ahora viene de API (total)
	const totalPages = Math.max(1, Math.ceil(total / pageSize));

	// ✅ si el URL trae page inválida, lo corregimos
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

	// ✅ categorías: con API hay 2 opciones:
	// - (A) Hardcode "Todas" + las tuyas
	// - (B) Pedir categorías reales al API (mejor, lo hacemos luego)
	//
	// Por ahora, mantenemos un set desde lo cargado (página actual).
	// Si querés categorías globales, hacemos fetch a /products/categories.
	const categories = useMemo(() => {
		return Array.from(
			new Set(items.map((p) => p.category).filter(Boolean)),
		).sort();
	}, [items]);

	// ✅ handlers que actualizan el URL
	const handleCategoryChange = (value: string) => {
		setSearchParams((prev) => {
			const next = new URLSearchParams(prev);
			next.set("cat", value);
			next.set("page", "1");
			return next;
		});
	};

	const handleSearchChange = (value: string) => {
		setSearchParams((prev) => {
			const next = new URLSearchParams(prev);
			next.set("q", value);
			next.set("page", "1");
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

	const { dispatch } = useCart();
	const navigate = useNavigate();

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

			{/* Estado loading/error */}
			{error && (
				<div className="alert alert-danger">
					<strong>Error:</strong> {error}
				</div>
			)}

			{loading && <p className="text-white-50">Cargando productos...</p>}

			{/* Grid */}
			<div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-3 g-3">
				{items.map((product) => (
					<div key={product.id} className="col">
						<Card
							name={product.name}
							category={product.category}
							price={product.price}
							stock={product.stock}
							brand={product.brand}
							imageUrl={product.imageUrl}
							onAdd={() =>
								dispatch({
									type: "ADD_ITEM",
									product,
									quantity: 1,
								})
							}
							onDetails={() => navigate(`/productos/${product.id}`)}
						/>
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
