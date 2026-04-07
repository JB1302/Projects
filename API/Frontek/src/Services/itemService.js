//Aqui los modelos
const Producto = require("../Models/Producto");
const Usuario = require("../Models/Usuario");

class ItemService {
	//MATCH
	async adminList() {
		return await Usuario.aggregate([
			{
				$match: { rol: "Administrador" },
			},
		]);
	}

	async accesoriosList() {
		return await Producto.aggregate([
			{
				$match: { categoria: "Accesorios" },
			},
		]);
	}

	//GROUP
	async stockAccesorios() {
		return await Producto.aggregate([
			{
				$match: { categoria: "Accesorios" },
			},
			{
				$group: {
					_id: "Stock de Accesorios",
					StockTotal: { $sum: "$stock" },
				},
			},
		]);
	}

	async cantidadProductos() {
		return await Producto.aggregate([
			{
				$group: {
					_id: "$categoria",
					CantidadProductos: { $sum: 1 },
				},
			},
		]);
	}

	//PROJECT
	async nombreCategoria() {
		return await Producto.aggregate([
			{
				$project: {
					_id: 0,
					Producto: "$nombre",
					Categoria: "$categoria",
					Stock: "$stock",
				},
			},
		]);
	}

	//GENERAL
	async activeProducts() {
		return await Producto.aggregate([
			{
				$match: {
					categoria: "Accesorios",
					activo: true,
				},
			},
			{
				$project: {
					_id: 0,
					nombre: 1,
					stock: 1,
				},
			},
			{
				$sort: {
					stock: 1,
				},
			},
		]);
	}
}

module.exports = new ItemService();
