package kelmerdev.com;

import jdk.dynalink.linker.LinkerServices;
import kelmerdev.com.dto.UserDto;
import kelmerdev.com.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ModelMapper2Application implements CommandLineRunner{

    ModelMapper modelMapper = new ModelMapper();

    public static void main(String[] args) {
        SpringApplication.run(ModelMapper2Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        /*
        User user = new User(1L, "John Doe", "john.doe@example.com");
        UserDto userDto = modelMapper.map(user, UserDto.class);

        System.out.println(userDto);
        */

        // mapear los campos de User a UserDto
        /*
        modelMapper.createTypeMap(User.class, UserDto.class)
                .addMapping(User::getName, UserDto::setFullName)
                .addMapping(User::getEmail, UserDto::setUserEmail);

        User user = new User(1L, "John Doe", "john.doe@example.com");
        UserDto userDto = modelMapper.map(user, UserDto.class);
        System.out.println(userDto);

         */

        // Mapeo de Collectiones
        List<User> users = Arrays.asList(
                new User(1L, "John Doe", "john.doe@example.com"),
                new User(2L, "Jane Doe", "jane.doe@example.com")
        );

        List<UserDto> userDtos = modelMapper.map(users, new TypeToken<List<UserDto>>() {}.getType());


    }


}
