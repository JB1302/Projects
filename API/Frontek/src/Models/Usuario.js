const mongoose = require("mongoose");

const UsuarioSchema = new mongoose.Schema(
	{
		nombre: {
			type: String,
			required: true,
		},
		email: {
			type: String,
			required: true,
			unique: true,
		},
		passwordHash: {
			type: String,
			required: true,
		},
		rol: {
			type: String,
			enum: ["Administrador", "Cliente"],
			required: true,
		},
		activo: {
			type: Boolean,
			default: true,
		},
		ultimaConexion: {
			type: Date,
		},
		createdAt: {
			type: Date,
		},
	},
	{ collection: "usuarios" },
);

module.exports = mongoose.model("Usuario", UsuarioSchema);
