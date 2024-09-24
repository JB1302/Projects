package net.testing.backendTests.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.testing.backendTests.models.requests.UserDetailRequestModel;

@RestController //Definir como controlador
@RequestMapping ("/users")  //localhost:8080/users
public class UserController {

  @GetMapping //Definir la ruta del Getter
  public String getUser(){
    return "get User Details";
  }

  @PostMapping //Crear un nuevo usuario desde JSON a Java
  public String createUser(@RequestBody UserDetailRequestModel userDetails){
    return "create new User";
  }

}

