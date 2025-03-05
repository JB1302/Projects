package Backend.controlador;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Backend.util.DatabaseUtil;
import Backend.modelo.Usuario.Usuario;

public class UsuarioController extends DatabaseUtil {
    //Usar un objeto ususario
    private Usuario usuario;

    //Definine un controlador basado en el objeto usuario
    public UsuarioController(Usuario usuario) {
        this.usuario = usuario;
    }

    //Construir SQL Query Abstracta
    @Override
    protected String getQuery() {
        return "INSERT INTO taller_mecanico.usuarios (nombre, correo,contrasena,role) VALUES (?,?,?,?)";
    }

    //Definor SQL Statement basado en el constructor
    @Override
    protected void setParametros(PreparedStatement statement) throws SQLException {
        statement.setString(1, usuario.getNombre());
        statement.setString(2, usuario.getCorreo());
        statement.setString(3, usuario.getPassword());
        statement.setString(4, usuario.getRol().name());

    }
}
