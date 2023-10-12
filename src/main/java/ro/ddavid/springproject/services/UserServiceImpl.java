package ro.ddavid.springproject.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.ddavid.springproject.models.dtos.UserDTO;
import ro.ddavid.springproject.models.entities.User;
import ro.ddavid.springproject.repositories.UserRepository;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public UserServiceImpl(UserRepository userRepository,
                           ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User userEntity = objectMapper.convertValue(userDTO, User.class);
//        User userEntity = new User();
//        userEntity.setFirstName(userDTO.getFirstName());
//        userEntity.setLastName(userDTO.getLastName());
//        userEntity.setEmail(userDTO.getEmail());
//        userEntity.setAge(userDTO.getAge());

        User userResponseEntity = userRepository.save(userEntity);
        log.info("Created user with id {}", userResponseEntity.getId());

//        UserDTO userResponseDTO = new UserDTO();
//        userResponseDTO.setId(userResponseEntity.getId());
//        userResponseDTO.setFirstName(userResponseEntity.getFirstName());
//        userResponseDTO.setLastName(userResponseEntity.getLastName());
//        userResponseDTO.setEmail(userResponseEntity.getEmail());
//        userResponseDTO.setAge(userResponseEntity.getAge());
//        return userResponseDTO;

        return objectMapper.convertValue(userResponseEntity, UserDTO.class);
    }
}
