import { useContext } from "react";
import CartContext from "./CartContext";

//creaamos una API para usar el carrito facilmente
export function useCart() {
	//Si existe lo cargamos
	const ctx = useContext(CartContext);
	//Verifica que el carrito exista
	if (!ctx) throw new Error("useCart debe usarse dentro de CartProvider");
	return ctx;
}
