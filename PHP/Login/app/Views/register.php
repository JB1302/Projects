<section class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
  <div class="border border-secondary rounded-4 shadow-sm p-5 bg-light" style="max-width: 420px; width: 100%;">

    <form method="POST"
          action="/Controllers/UserController.php"
          onsubmit="return validarFormularioRegister()">

      <h1 class="display-6 text-primary fw-bold mb-5 text-center">Registrarse</h1>

      <div class="mb-3">
        <label for="nombre" class="lead">Usuario:</label>
        <input type="text" class="form-control" id="nombre" name="nombre">
      </div>

      <div class="mb-3">
        <label for="email" class="lead">Email:</label>
        <input type="email" class="form-control" id="email" name="email">
      </div>

      <div class="mb-4">
        <label for="password" class="lead">Contraseña:</label>
        <input type="password" class="form-control" id="password" name="password">
      </div>

      <input type="hidden" name="action" value="register">

      <a href="index.php" class="btn btn-outline-secondary w-100 mb-3">Regresar</a>

      <button type="submit" class="btn btn-primary w-100" id="btnRegistrar">Crear Cuenta</button>

    </form>

  </div>
</section>
