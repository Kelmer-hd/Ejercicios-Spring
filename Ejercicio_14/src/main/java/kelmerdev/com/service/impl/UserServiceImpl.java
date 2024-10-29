package kelmerdev.com.service.impl;

import kelmerdev.com.dto.UserRequest;
import kelmerdev.com.dto.UserResponse;
import kelmerdev.com.exception.BadRequestException;
import kelmerdev.com.exception.ResourceNotFoundException;
import kelmerdev.com.mapper.UserMapper;
import kelmerdev.com.model.User;
import kelmerdev.com.repository.UserRepository;
import kelmerdev.com.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Transactional
    @Override
    public UserResponse createUser(UserRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("El usuario con email " + request.getEmail() + " ya existe");
        }
        // Si el email no existe, procedemos a crear el usuario
        User user = userMapper.userRequestToUser(request);
        user.setRegistrationDate(LocalDateTime.now());
        user = userRepository.save(user);
        return userMapper.userToUserResponse(user);

        /*
        User user = userMapper.userRequestToUser(request);
        user = userRepository.save(user);
        return userMapper.userToUserResponse(user);
         */
    }

    @Transactional
    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setMembershipNumber(request.getMembershipNumber());
        user = userRepository.save(user);
        return userMapper.userToUserResponse(user);

    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        UserResponse user = getUserById(id);
        userRepository.deleteById(user.getId());
    }

    @Transactional(readOnly = true)
    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));
        return userMapper.userToUserResponse(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users =  userRepository.findAll();
        return userMapper.userListToUserResponseList(users);
    }
}
