<?php
require_once '../Config/database.php';

class Task
{
    private $conn;

    public function __construct($db)
    {
        $this->conn = $db;
    }


    public function getAll(): array
    {
        try {
            $stmt = $this->conn->query("SELECT * FROM tareas");
            return $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (PDOException $e) {
            return ["error" => "Error al obtener tareas: " . $e->getMessage()];
        }
    }

    public function add($idUsuario, $titulo, $descripcion)
    {
        try {
            $sql = "INSERT INTO tareas (id_usuario, titulo, descripcion)
                VALUES (:id_usuario, :titulo, :descripcion)";

            $stmt = $this->conn->prepare($sql);

            return $stmt->execute([
                'id_usuario'  => $idUsuario,
                'titulo'      => $titulo,
                'descripcion' => $descripcion
            ]);
        } catch (PDOException $e) {
            return false;
        }
    }



    public function delete(int $id): bool
    {
        try {
            $stmt = $this->conn->prepare("DELETE FROM tareas WHERE id = :id");
            return $stmt->execute(['id' => $id]);
        } catch (PDOException $e) {
            return false;
        }
    }



    public function complete(int $id): bool
    {
        try {
            $stmt = $this->conn->prepare("UPDATE tareas SET activo = 0 WHERE id = :id");
            return $stmt->execute(['id' => $id]);
        } catch (PDOException $e) {
            return false;
        }
    }
}
