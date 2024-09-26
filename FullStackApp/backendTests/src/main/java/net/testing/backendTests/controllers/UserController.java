package net.testing.backendTests.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.testing.backendTests.models.requests.UserDetailRequestModel;
import net.testing.backendTests.models.responses.UserRest;
import net.testing.backendTests.shared.dto.UserDto;

@RestController //Definir como controlador
@RequestMapping ("/users")  //localhost:8080/users
public class UserController {

  @GetMapping //Definir la ruta del Getter
  public String getUser(){
    return "get User Details";
  }

  @PostMapping //Crear un nuevo usuario desde JSON a Java
  public UserRest createUser(@RequestBody UserDetailRequestModel userDetails){
    
    //Crear un nuevo objeto UserRest para devolver al cliente
    UserRest userToReturn = new UserRest();
    //Data transfer object (DTO) para transferir datos de usuario
    UserDto userDto = new UserDto();
    //Copiar datos del usuario del RequestModel al DTO
    BeanUtils.copyProperties(userDetails, userDto);
    //Crear el usuario en la base de datos
    UserDto createdUser = userService.createUser(userDto);
    //Transferir los datos del usuario creado al objecto REST que se devolvera
    BeanUtils.copyProperties(createdUser, userToReturn);

    //Devolvemos el usauario al cliente
    return userToReturn;
  }

}

