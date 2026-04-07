const Item = require("../models/item");

class ItemService {
	async createItem(data) {
		const item = new Item(data);
		await item.save();
		return item;
	}

	async getItem(id) {
		return await Item.findById(id);
	}

	async updateItem(id, data) {
		return await Item.findByIdAndUpdate(id, data, { new: true });
	}

	async deleteItem(id) {
		return await Item.findByIdAndDelete(id);
	}

	async agrupacionPorSabor() {
		return Item.aggregate([
			{
				$group: {
					_id: "$Sabor",
					cantidad: { $sum: 1 },
				},
			},
		]);
	}

	async ejemploDeMatch() {
		return Item.aggregate([
			{
				$match: {
					Cantidad: { $gte: 25 },
					Sabor: "Napolitano",
				},
			},
		]);
	}
}

module.exports = new ItemService();
