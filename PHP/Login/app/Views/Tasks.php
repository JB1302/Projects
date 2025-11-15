<?php
require_once './Config/database.php';
$idUsuario = $_SESSION["id"];

$stmt = $conn->prepare("SELECT * FROM tareas WHERE id_usuario = :id ORDER BY id DESC");
$stmt->execute(['id' => $idUsuario]);
$result = $stmt;

?>

<main class="container my-5">

    <div class="d-flex justify-content-between align-items-center mb-3">
        <h5 class="m-0">Hola, <?php echo $_SESSION["usuario"] ?> </h5>
        <a href="Views/logout.php" 
        class="btn btn-outline-danger btn-sm">Salir</a>

    </div>


    <div class="mb-4">
        <form method="POST"
            action="Controllers/TaskController.php">

            <div class="input-group mb-3">
                <input
                    type="text"
                    class="form-control"
                    name="titulo"
                    placeholder="Título">
            </div>

            <div class="input-group mb-3">
                <input
                    type="text"
                    class="form-control"
                    name="descripcion"
                    placeholder="Descripción">
            </div>

            <input type="hidden" name="action" value="add">
            <button class="btn btn-primary">Agregar</button>
        </form>
    </div>

    <hr class="mb-4">

    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2 class="fw-bold text-primary mb-0">
            <i class="fa-solid fa-user me-2"></i> Tareas
        </h2>

    </div>

    <div class="table-responsive shadow-sm">
        <table class="table table-sm table-hover align-middle">
            <thead class="table-primary">
                <tr>
                    <th>ID</th>
                    <th>TÍTULO</th>
                    <th>DESCRIPCIÓN</th>
                    <th>CREADO EN</th>
                    <th class="text-center">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <?php if ($result->rowCount() > 0): ?>
                    <?php foreach ($result as $p): ?>
                        <tr>
                            <td><?= htmlspecialchars($p['id']) ?></td>
                            <td><?= htmlspecialchars($p['titulo']) ?></td>
                            <td><?= htmlspecialchars($p['descripcion']) ?></td>
                            <td><?= htmlspecialchars($p['creado_en']) ?></td>
                            <td class="text-center">
                                <a href="Controllers/TaskController.php?action=delete&id=<?= $p['id'] ?>"
                                    class="btn btn-danger btn-sm">
                                    ELIMINAR
                                </a>
                            </td>
                        </tr>
                    <?php endforeach; ?>
                <?php else: ?>
                    <tr>
                        <td colspan="5" class="text-center text-muted">
                            No hay tareas registradas
                        </td>
                    </tr>
                <?php endif; ?>
            </tbody>
        </table>
    </div>

</main>