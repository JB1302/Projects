import type { Product } from "../types/Product";

export type CartAction =
	| { type: "ADD_ITEM"; product: Product; quantity: number }
	| { type: "REMOVE_ITEM"; productId: string }
	| { type: "SET_QTY"; productId: string; quantity: number }
	| { type: "CLEAR_CART" };
