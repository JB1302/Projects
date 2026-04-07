const mongoose = require("mongoose");

const connectDB = async () => {
	try {
		await mongoose.connect("mongodb://localhost:27017/Fronteks", {});
		console.log("Conexion a DB Exitosa");
	} catch (err) {
		console.log(err.message);
		process.exit(1);
	}
};

module.exports = connectDB;
