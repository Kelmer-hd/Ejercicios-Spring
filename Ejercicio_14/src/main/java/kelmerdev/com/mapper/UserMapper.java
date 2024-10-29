package kelmerdev.com.mapper;

import kelmerdev.com.dto.UserRequest;
import kelmerdev.com.dto.UserResponse;
import kelmerdev.com.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public User userRequestToUser (UserRequest request){
        return modelMapper.map(request, User.class);
    }

    public UserResponse userToUserResponse (User user){
        return modelMapper.map(user, UserResponse.class);
    }


    public List<User> userRequestListToUserList (List<UserRequest> requests){
        return requests.stream()
                .map((this::userRequestToUser))
                .toList();
    }

    public List<UserResponse> userListToUserResponseList (List<User> users){
        return users.stream()
                .map(this::userToUserResponse)
                .toList();
    }

}
