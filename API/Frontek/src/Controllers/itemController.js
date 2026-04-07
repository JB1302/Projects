const itemService = require("../Services/itemService");

class ItemController {
	//MATCH

	async adminList(req, res) {
		try {
			const item = await itemService.adminList();

			if (!item) {
				return res.status(404).json({ error: "Elemento no encontrado" });
			}

			return res.status(200).json(item);
		} catch (err) {
			return res.status(500).json({ error: err.message });
		}
	}

	async accesoriosList(req, res) {
		try {
			const item = await itemService.accesoriosList();

			if (!item) {
				return res.status(404).json({ error: "Elemento no encontrado" });
			}

			return res.status(200).json(item);
		} catch (err) {
			return res.status(500).json({ error: err.message });
		}
	}

	//GROUP
	async stockAccesorios(req, res) {
		try {
			const item = await itemService.stockAccesorios();

			if (!item) {
				return res.status(404).json({ error: "Elemento no encontrado" });
			}

			return res.status(200).json(item);
		} catch (err) {
			return res.status(500).json({ error: err.message });
		}
	}

	async cantidadProductos(req, res) {
		try {
			const item = await itemService.cantidadProductos();

			if (!item) {
				return res.status(404).json({ error: "Elemento no encontrado" });
			}

			return res.status(200).json(item);
		} catch (err) {
			return res.status(500).json({ error: err.message });
		}
	}

	//PROJECT
	async nombreCategoria(req, res) {
		try {
			const item = await itemService.nombreCategoria();

			if (!item) {
				return res.status(404).json({ error: "Elemento no encontrado" });
			}

			return res.status(200).json(item);
		} catch (err) {
			return res.status(500).json({ error: err.message });
		}
	}

	//GENERAL
	async activeProducts(req, res) {
		try {
			const item = await itemService.activeProducts();

			if (!item) {
				return res.status(404).json({ error: "Elemento no encontrado" });
			}

			return res.status(200).json(item);
		} catch (err) {
			return res.status(500).json({ error: err.message });
		}
	}
}

module.exports = new ItemController();
