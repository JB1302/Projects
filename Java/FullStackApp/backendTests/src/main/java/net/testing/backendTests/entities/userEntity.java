package net.testing.backendTests.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "users") //NOMBRE DE LA TABLA
public class userEntity  implements Serializable{

    private static final long serialVersionUID = 1L;

    //definir los campos

    @Id //Definir como valor clave
    @GeneratedValue // se auto incrementa
    private long id;

    @Column(nullable= false) //No puede ser null
    private String userId;
    @Column(nullable= false, length=50) //No puede ser null, maximo 50 caracteres
    private String firstname;
    @Column(nullable= false, length=50) //No puede ser null, maximo 50 caracteres
    private String lastname;
    @Column(nullable= false, length=255) //No puede ser null, maximo 250 caracteres
    private String email;

    @Column(nullable= false) //No puede ser null
    private String encryptedPassword;


    //Getters and setters
    public long getId() {
      return id;
    }

    public void setId(long id) {
      this.id = id;
    }

    public String getUserId() {
      return userId;
    }

    public void setUserId(String userId) {
      this.userId = userId;
    }

    public String getFirstname() {
      return firstname;
    }

    public void setFirstname(String firstname) {
      this.firstname = firstname;
    }

    public String getLastname() {
      return lastname;
    }

    public void setLastname(String lastname) {
      this.lastname = lastname;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getEncryptedPassword() {
      return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
      this.encryptedPassword = encryptedPassword;
    }


  
}
