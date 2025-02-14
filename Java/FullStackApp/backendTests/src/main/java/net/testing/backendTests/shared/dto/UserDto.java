package net.testing.backendTests.shared.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstname, lastname, email, password;

    // Añadidos
    private long id;
    private String userId;
    private String encryptedPassword;

    public String getFirstname() {
        return firstname; // Getter correcto
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname; // Setter correcto
    }

    public String getLastname() {
        return lastname; // Getter correcto
    }

    public void setLastname(String lastname) {
        this.lastname = lastname; // Setter correcto
    }

    public String getEmail() {
        return email; // Getter correcto
    }

    public void setEmail(String email) {
        this.email = email; // Setter correcto
    }

    public String getPassword() {
        return password; // Getter correcto
    }

    public void setPassword(String password) {
        this.password = password; // Setter correcto
    }

    public long getId() {
        return id; // Getter correcto
    }

    public void setId(long id) {
        this.id = id; // Setter correcto
    }

    public String getUserId() {
        return userId; // Getter correcto
    }

    public void setUserId(String userId) {
        this.userId = userId; // Setter correcto
    }

    public String getEncryptedPassword() {
        return encryptedPassword; // Getter correcto
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword; // Setter correcto
    }

    // Datos adicionales futuros:
}
