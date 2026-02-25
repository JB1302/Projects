const mongoose = require("mongoose");
const ItemSchema = new mongoose.Schema(
	{
		Sabor: { type: String },
		Cantidad: { type: Number },
		Total: { type: Number },
	},
	{ collection: "Productos" },
); // Especificar el nombre de la colección

module.exports = mongoose.model("item", ItemSchema);
