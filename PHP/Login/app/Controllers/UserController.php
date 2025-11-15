<?php
session_start();

require_once '../Config/database.php';
require_once '../Models/User.php';

$userModel = new User($conn);


try {
  if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // $data = json_decode(file_get_contents("php://input"), true);
    $data = $_POST;

    $action = $data['action'] ?? '';

    if ($action === 'login' && !empty($data['nombre']) && !empty($data['password'])) {

      $user = $userModel->login($data['nombre']);
      $password = $data['password'];



      if ($user && password_verify($password, $user[0]['password_hash'])) {
        $_SESSION["usuario"] = $user[0]['nombre'];
        $_SESSION["id"] = $user[0]['id'];
        $_SESSION["email"] = $user[0]['email'];
        header("Location: ../../index.php");
      } else {
        echo "Error de autentificacion";
        session_destroy();
      }
    } elseif (
      $action === 'register'
      && !empty($data['nombre'])
      && !empty($data['email'])
      && !empty($data['password'])
    ) {

      $nombre   = trim($data['nombre']);
      $email    = trim($data['email']);
      $password = $data['password'];

      $passwordHash = password_hash($password, PASSWORD_DEFAULT);

      $userModel->register($nombre, $email, $passwordHash);

      header("Location: ../../index.php");
      exit;
    } else {
      throw new Exception("Acción no válida o parámetros incorrectos.");
    }
  }
} catch (Exception $e) {
  echo json_encode(["error" => $e->getMessage()]);
}
