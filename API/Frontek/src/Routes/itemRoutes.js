// src/Routes/itemRoutes.js
const express = require("express");
const router = express.Router();
const itemController = require("../Controllers/itemController");

//MATCH

router.get("/usuarios/Admin", itemController.adminList);

router.get("/productos/Accesorios", itemController.accesoriosList);

//GROUP
router.get("/productos/Stock_Accesorios", itemController.stockAccesorios);

router.get(
	"/productos/Cantidad_Por_Categoria",
	itemController.cantidadProductos,
);

//PROJECT

router.get("/productos/Nombre_Categoria", itemController.nombreCategoria);

//GENERAL

router.get("/productos/Activos", itemController.activeProducts);

module.exports = router;
