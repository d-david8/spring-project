package ro.ddavid.springproject.services;

import ro.ddavid.springproject.models.dtos.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);
}
