import type { Product } from "../types/Product";

export type CartAction =
	| { type: "ADD_ITEM"; product: Product; quantity: number }
	| { type: "REMOVE_ITEM"; productId: string }
	| { type: "CLEAR_CART" };
