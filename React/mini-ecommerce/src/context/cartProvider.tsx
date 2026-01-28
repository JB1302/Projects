import type { ReactNode } from "react";
import { useReducer } from "react";

// ✅ Importamos el Context que va a "publicar" el carrito globalmente.
import CartContext from "./CartContext";

// ✅ Tipos del dominio del carrito:
import type { CartState } from "../types/CartState";
import type { CartAction } from "./cartActions";

// ✅ Estado inicial del carrito (lo que tenemos al arrancar la app):
// items vacío = carrito vacío.
const initialState: CartState = { items: [] };

// ✅ Reducer: función pura que decide cómo cambia el estado del carrito.
// Recibe:
// - state: estado actual del carrito
// - action: lo que acaba de pasar (ADD_ITEM, REMOVE_ITEM, CLEAR_CART)
// Devuelve:
// - el NUEVO estado (sin mutar el estado anterior)
function cartReducer(state: CartState, action: CartAction): CartState {
	// switch según el tipo de acción:
	switch (action.type) {
		// ✅ AGREGAR ITEM
		case "ADD_ITEM": {
			// Buscamos si el producto ya existe en el carrito.
			// existing será el CartItem encontrado o undefined si no existe.
			const existing = state.items.find(
				(item) => item.product.id === action.product.id,
			);

			// Si ya existe, NO queremos duplicar la fila.
			// Queremos sumar la cantidad.
			if (existing) {
				return {
					// Copiamos el estado
					...state,

					// Creamos un nuevo array de items:
					// - si el item coincide con el producto, le sumamos quantity
					// - si no coincide, lo dejamos igual
					items: state.items.map((item) =>
						item.product.id === action.product.id
							? {
									...item,
									quantity: item.quantity + action.quantity,
								}
							: item,
					),
				};
			}

			// Si NO existe, lo agregamos como un nuevo CartItem al final del array.
			return {
				...state,
				items: [
					...state.items, // copiamos los items anteriores
					{ product: action.product, quantity: action.quantity }, // agregamos el nuevo
				],
			};
		}

		// ✅ REMOVER ITEM
		case "REMOVE_ITEM":
			return {
				...state,

				// filter crea un nuevo array dejando solo los que NO tengan ese id.
				// o sea, elimina el item cuyo product.id coincide con action.productId
				items: state.items.filter(
					(item) => item.product.id !== action.productId,
				),
			};

		// ✅ VACIAR CARRITO
		case "CLEAR_CART":
			// Volvemos al carrito vacío.
			return { items: [] };

		// ✅ ACCIÓN DESCONOCIDA
		default:
			// Si llega una acción que no conocemos, no cambiamos nada.
			return state;
	}
}

type CartProviderProps = { children: ReactNode };

// ✅ CartProvider: componente que crea el estado global y lo expone con CartContext.Provider
export function CartProvider({ children }: CartProviderProps) {
	// useReducer conecta:
	// - cartReducer (reglas de cambio)
	// - initialState (estado inicial)
	// y devuelve:
	// - state: estado actual
	// - dispatch: función para enviar acciones al reducer
	const [state, dispatch] = useReducer(cartReducer, initialState);

	// Publicamos state y dispatch en el contexto,
	// para que cualquier componente (Header, ProductPage, CartPage) pueda leerlos con useCart().
	return (
		<CartContext.Provider value={{ state, dispatch }}>
			{children}
		</CartContext.Provider>
	);
}
