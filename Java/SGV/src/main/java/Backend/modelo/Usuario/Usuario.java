package Backend.modelo.Usuario;

public abstract class Usuario {
    //Variables
    int id;
    private String nombre;
    private String correo;
    private String password;
    private Role role;

    public enum Role {
        ADMIN, MECANICO, CLIENTE
    }

    //Constructor
    public Usuario(String nombre, String correo, String password, Role role) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.role = role;
    }

    //Metodos
    public abstract void iniciarSesion();
    public abstract void cerrarSesion();

    //Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRol() {
        return role;
    }

    public void setRol(Role role) {
        role = role;
    }
}
