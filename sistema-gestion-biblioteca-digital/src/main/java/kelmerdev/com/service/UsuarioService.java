package kelmerdev.com.service;

import kelmerdev.com.dto.UserDto;
import kelmerdev.com.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

    Usuario create(UserDto userDto);

    Usuario update(Long id,UserDto userDto);

    void delete(Long id);

    Usuario get(Long id);

    List<Usuario> getAll();
}
