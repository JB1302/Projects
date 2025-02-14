package net.testing.backendTests;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.testing.backendTests.entities.userEntity;

@Repository             //Crear un Repositorio
public interface UserRepository extends CrudRepository<userEntity, Long>{
  /* //Aqui iria la funcionalidad adicional /
  public userEntity findUserByFirstName(String name); //Buscar por nombre
  public userEntity findUserByEmail(String email); //Buscar por correo 
   */

}

