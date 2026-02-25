const express = require("express");
const router = express.Router();
const itemController = require("../controllers/itemController");

router.post("/items", itemController.createItem);
router.get("/items/:id", itemController.getItem);
router.put("/items/:id", itemController.updateItem);
router.delete("/items/:id", itemController.deleteItem);
router.get("/itemsGroup", itemController.agrupacionPorSabor);

router.get("/match", itemController.ejemploDeMatch);
router.get("/project", itemController.ejemploDeProject);
router.get("/completo", itemController.ejemploCompleto);

module.exports = router;
