package kelmerdev.com.ejercicio_11;

import org.modelmapper.ModelMapper;

public class EjemploBasico {
    public static void main(String[] args) {
        /*
         // 1. Crear instancia de ModelMapper
        ModelMapper modelMapper = new ModelMapper();

        // 2. Crear y llenar objetos de origen

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Juan Perez");
        usuario.setEmail("juanperez@gmail.com");
        usuario.setPassword("123456");

        // 3. Mapear de Usuario a UsuarioDTO
        UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);

        // 4. Imprimir resultado
        System.out.println("ID: " + usuarioDTO.getId());
        System.out.println("Nombre: " + usuarioDTO.getNombre());
        System.out.println("Email: " + usuarioDTO.getEmail());

        */

        // Mapeo personalizado
        ModelMapper modelMapper = new ModelMapper();
        // Configurar mapeo personalizado
        modelMapper.createTypeMap(Usuario.class, UsuarioDTO.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getNombre().toUpperCase(),
                            UsuarioDTO::setNombre);
                    // El nombre se convertirá a mayúsculas
                });

        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");

        UsuarioDTO dto = modelMapper.map(usuario, UsuarioDTO.class);
        System.out.println(dto.getNombre());
    }
}
