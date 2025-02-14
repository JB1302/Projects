package net.testing.backendTests.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.testing.backendTests.UserRepository;
import net.testing.backendTests.entities.userEntity;
import net.testing.backendTests.shared.dto.UserDto;

@Service
public class UserService implements UserServiceInterface {

    @Autowired  //Cargar el Crud
    UserRepository userRepository;
  
    @Override
    public UserDto createUser(UserDto user) {
      userEntity userEntity = new userEntity(); //Crear una entidad
      BeanUtils.copyProperties(user, userEntity); //Transferir datos del usuario a la entidad

      userEntity.setEncryptedPassword("testPasword"); //porque la app necesita este campo mandatorio
      userEntity.setUserId("TESTIDPUBLICO");  //porque la app necesita este campo mandatorio

      //Guardar la entidad del usuario
      userEntity storedUserDetails = userRepository.save(userEntity);
       
      userRepository.save(userEntity); //Informacion a cargar de la DB
      
      //Creamos un objeto DTO para poder regresarlo
      UserDto userToReturn = new UserDto();
      BeanUtils.copyProperties(userEntity, userToReturn);
      
      return userToReturn;
    }
  
}
