<?php
require_once '../Config/database.php';
require_once '../Models/Task.php';
$taskModel = new Task($conn);
session_start();
$idUsuario = $_SESSION["id"] ?? null;


header('Content-Type: application/json');

try {
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        // $data = json_decode(file_get_contents("php://input"), true);
        $data = $_POST;

        $action      = $_POST['action'] ?? '';
        $titulo      = $_POST['titulo'] ?? null;
        $descripcion = $_POST['descripcion'] ?? null;

        if ($action === 'add' && $titulo && $descripcion && $idUsuario) {

            $taskModel->add($idUsuario, $titulo, $descripcion);
            header("Location: ../../index.php");
        } else {
            throw new Exception("Acción no válida o parámetros incorrectos.");
        }
    } else {
        if ($_SERVER['REQUEST_METHOD'] === 'GET') {
            // $data = json_decode(file_get_contents("php://input"), true);
            $data = $_GET;

            $action = $data['action'] ?? '';

            if ($action === 'delete' && !empty($data['id'])) {
                $taskModel->delete($data['id']);
            } elseif ($action === 'completed' && !empty($data['id'])) {
                $taskModel->complete($data['id']);
            } else {
                throw new Exception("Acción no válida o parámetros incorrectos.");
            }
            header("Location: ../../index.php");
        } else {
            echo json_encode($taskModel->getAll());
        }
    }
} catch (Exception $e) {
    echo json_encode(["error" => $e->getMessage()]);
}
