package net.testing.backendTests.services;

import net.testing.backendTests.shared.dto.UserDto;

public interface UserServiceInterface {
  
  public UserDto createUser(UserDto user);
  
}
