<section class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
  <div class="border border-secondary rounded-4 shadow-sm p-5 bg-light" style="max-width: 420px; width: 100%;">

    <form method="POST"
      action="/Controllers/UserController.php"
      onsubmit="return validarFormularioLogin()">

      <h1 class="display-6 text-primary fw-bold mb-5 text-center">Iniciar Sesión</h1>

      <div class="mb-3">
        <label for="nombre" class="lead">Usuario:</label>
        <input type="text" class="form-control" id="nombre" name="nombre">
      </div>

      <div class="mb-5">
        <label for="password" class="lead">Contraseña:</label>
        <input type="password" class="form-control" id="password" name="password">
      </div>

      <input type="hidden" name="action" value="login">

      <button type="submit" class="btn btn-primary w-100 mb-3" id="btnLogin">Login</button>
      
      <a href="index.php?register=1" class="btn btn-info w-100 text-white">Registrarse</a>


    </form>

  </div>
</section>