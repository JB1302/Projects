import type { Product } from "../types/Product";
import type { DummyJsonProduct } from "./dummyjsonAdapter";
import { mapDummyToProduct } from "./dummyjsonAdapter";

type DummyJsonListResponse = {
	products: DummyJsonProduct[];
	total: number;
	skip: number;
	limit: number;
};

export async function fetchProducts(params: {
	page: number;
	pageSize: number;
	q?: string;
	cat?: string; // category en DummyJSON (string)
}): Promise<{ items: Product[]; total: number }> {
	const { page, pageSize, q, cat } = params;

	const skip = (page - 1) * pageSize;

	let url = `https://dummyjson.com/products?limit=${pageSize}&skip=${skip}`;

	// Si hay búsqueda, usamos /search
	if (q && q.trim() !== "") {
		url = `https://dummyjson.com/products/search?q=${encodeURIComponent(
			q.trim(),
		)}&limit=${pageSize}&skip=${skip}`;
	}

	// Si hay categoría (y no es "Todas"), usamos /category/:cat
	// Nota: cat debe existir en las categorías del API.
	if (cat && cat !== "Todas") {
		url = `https://dummyjson.com/products/category/${encodeURIComponent(
			cat,
		)}?limit=${pageSize}&skip=${skip}`;
	}

	const res = await fetch(url);
	if (!res.ok) throw new Error("Error cargando productos");

	const data: DummyJsonListResponse = await res.json();

	return {
		items: data.products.map(mapDummyToProduct),
		total: data.total,
	};
}
