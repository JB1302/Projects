import type { Product } from "../types/Product";

export type DummyJsonProduct = {
	id: number;
	title: string;
	brand?: string;
	price: number;
	stock?: number;
	thumbnail?: string;
	category?: string;
};

export function mapDummyToProduct(p: DummyJsonProduct): Product {
	return {
		id: String(p.id),
		name: p.title,
		brand: p.brand ?? "Generic",
		price: p.price * 1000, // simulación colones
		stock: p.stock ?? 10,
		category: p.category ?? "General", // ahora que lo pasaste a string
		imageUrl: p.thumbnail,
	};
}
