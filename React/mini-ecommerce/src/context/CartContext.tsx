import { createContext } from "react";
import type { CartState } from "../types/CartState";
import type { CartAction } from "./cartActions"; //Contiene las acciones permitidas

export type CartContextType = {
	state: CartState; // el estado actual del carrito.
	dispatch: React.Dispatch<CartAction>; // es el botón para pedir cambios.
};

//Permite que cualquier componente lo lea.
// Cart Context Type: “La caja del carrito contiene estas dos cosas”.
const CartContext = createContext<CartContextType | undefined>(undefined);

export default CartContext;
