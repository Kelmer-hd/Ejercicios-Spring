package kelmerdev.com.service;

import kelmerdev.com.dto.UserRequest;
import kelmerdev.com.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);

    UserResponse updateUser(Long id, UserRequest request);

    void deleteUser(Long id);

    UserResponse getUserById(Long id);

    List<UserResponse> getAllUsers();
}
