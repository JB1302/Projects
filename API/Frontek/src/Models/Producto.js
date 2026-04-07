const mongoose = require("mongoose");

const ProductoSchema = new mongoose.Schema(
	{
		nombre: {
			type: String,
			required: true,
			trim: true,
		},
		precio: {
			type: Number,
			required: true,
			min: 0,
		},
		stock: {
			type: Number,
			required: true,
			min: 0,
		},
		categoria: {
			type: String,
			required: true,
		},
		activo: {
			type: Boolean,
			default: true,
		},
		createdAt: {
			type: Date,
		},
	},
	{ collection: "productos" },
);

module.exports = mongoose.model("Producto", ProductoSchema);
