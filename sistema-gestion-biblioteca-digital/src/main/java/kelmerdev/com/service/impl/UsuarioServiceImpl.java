package kelmerdev.com.service.impl;

import kelmerdev.com.dto.UserDto;
import kelmerdev.com.mapper.UserMapper;
import kelmerdev.com.model.Usuario;
import kelmerdev.com.repository.UsuarioRepository;
import kelmerdev.com.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UserMapper userMapper;

    @Override
    public Usuario create(UserDto userDto) {
        Usuario usuario = userMapper.userDtoToUser(userDto);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Long id, UserDto userDto) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        userMapper.userDtoToUser(userDto);
        usuario.setNombre(userDto.getNombre());
        usuario.setApellido(userDto.getApellido());
        usuario.setDireccion(userDto.getDireccion());
        usuario.setEmail(userDto.getEmail());
        usuario.setPassword(userDto.getPassword());
        usuarioRepository.save(usuario);
        return usuario;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Usuario get(Long id) {
        return null;
    }

    @Override
    public List<Usuario> getAll() {
        return List.of();
    }
}
