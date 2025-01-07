package kelmerdev.com.mapper;

import kelmerdev.com.dto.UserDto;
import kelmerdev.com.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        configureModelMapper();
    }

    private void configureModelMapper() {
        modelMapper.typeMap(UserDto.class, Usuario.class).addMappings(mapper -> {
            mapper.map(UserDto::getNombre, Usuario::setNombre);
            mapper.map(UserDto::getApellido, Usuario::setApellido);
            mapper.map(UserDto::getDireccion, Usuario::setDireccion);
            mapper.map(UserDto::getEmail, Usuario::setEmail);
            mapper.map(UserDto::getPassword, Usuario::setPassword);
        });

        modelMapper.typeMap(Usuario.class, UserDto.class).addMappings(mapper -> {
            mapper.map(Usuario::getNombre, UserDto::setNombre);
            mapper.map(Usuario::getApellido, UserDto::setApellido);
            mapper.map(Usuario::getDireccion, UserDto::setDireccion);
            mapper.map(Usuario::getEmail, UserDto::setEmail);
            mapper.map(Usuario::getPassword, UserDto::setPassword);
        });

    }

    public Usuario userDtoToUser(UserDto userDto) {
        return modelMapper.map(userDto, Usuario.class);
    }

    public UserDto userToUserDto(Usuario user) {
        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> userListToUserDtoList(List<Usuario> users) {
        return users.stream()
                .map(this::userToUserDto)
                .collect(Collectors.toList());
    }

    public List<Usuario> userDtoListToUserList(List<UserDto> users) {
        return users.stream()
                .map(this::userDtoToUser)
                .collect(Collectors.toList());
    }
}
