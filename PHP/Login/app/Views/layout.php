<?php
session_start();
?>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Gestión de Tareas</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>



<body class="d-flex flex-column min-vh-100">
  <nav class="navbar navbar-expand-lg shadow-sm">
    <div class="container">
      <a class="navbar-brand d-flex align-items-center" href="#">
        <i class="fa-solid fa-store fs-3 me-2 align-middle"></i>SuperDuperApp
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
        aria-controls="navbarNav" aria-expanded="false" aria-label="Alternar navegación">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mx-auto">
          <li class="nav-item"><a class="nav-link active" href="#">Inicio</a></li>
          <li class="nav-item"><a class="nav-link" href="#">Beneficios</a></li>
          <li class="nav-item"><a class="nav-link" href="#">Testimonios</a></li>
          <li class="nav-item"><a class="nav-link" href="#">Precios</a></li>
        </ul>
        <button class="btn bg-dark text-white ms-lg-3">Prueba Gratis</button>
      </div>
    </div>
  </nav>

  <main class="flex-grow-1 d-flex justify-content-center align-items-center">
    <?php
    if (!isset($_SESSION['id'])) {

      if (isset($_GET['register'])) {
        include 'Views/register.php';
      } else {
        include 'Views/login.php';
      }
    } else {
      include 'Tasks.php';
    }
    ?>

  </main>

  <script src="../public/js/script.js" defer></script>

  <!-- ========== FOOTER PRINCIPAL ========== -->
  <footer class="bg-light text-center mt-auto">
    <div class="text-center p-4 text-secondary">
      <i class="fa-solid fa-copyright"></i> 2025 <span>SuperDuperApp. Todos los derechos reservados.</span>
    </div>
  </footer>

</body>

</html>