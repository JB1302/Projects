<?php
require_once '../Config/database.php';

class User
{
    private $conn;

    public function __construct($db)
    {
        $this->conn = $db;
    }

    
    public function login($nombre): array
    {
        try {
            $stmt = $this->conn->prepare("select * from usuarios  where nombre = :nombre");
            $stmt->execute(['nombre' => $nombre]);
            return $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (PDOException $e) {
            return ["error" => "Error al obtener tareas: " . $e->getMessage()];
        }
    }

  public function register($nombre, $email, $passwordHash) {
        $sql = "INSERT INTO usuarios (nombre, email, password_hash) 
                VALUES (:nombre, :email, :password_hash)";
        $stmt = $this->conn->prepare($sql);
        $stmt->execute([
            ':nombre'        => $nombre,
            ':email'         => $email,
            ':password_hash' => $passwordHash
        ]);
    }
}
