import { Routes, Route, Outlet } from "react-router-dom";

import MainLayout from "./layouts/MainLayout";
import HomePage from "./pages/HomePage";
import ProductPage from "./pages/ProductPage";
import ProductDetailPage from "./pages/ProductDetailPage";
import Carrito from "./pages/CartPage";

import "./App.css";

function App() {
	return (
		<Routes>
			{/* Aqui va element dentro de route */}
			<Route
				element={
					<MainLayout>
						<Outlet />
					</MainLayout>
				}
			>
				<Route index element={<HomePage />} />
				<Route path="productos" index element={<ProductPage />} />
				<Route path="productos/:id" element={<ProductDetailPage />} />
				<Route path="carrito" element={<Carrito />} />
			</Route>
		</Routes>
	);
}

export default App;
