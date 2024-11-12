package kelmerdev.com.ejercicio_12;

import org.modelmapper.ModelMapper;

public class Main {
    public static void main(String[] args) {
        // 1. Crear instancia de ModelMapper
        ModelMapper modelMapper = new ModelMapper();

        // 2. Configurar mapeo personalixado
        modelMapper.typeMap(UsuarioConDireccion.class, UsuarioDireccionDTO.class)
                .addMappings(mapper -> {
                    // Mapear el nombre directamente
                    mapper.map(UsuarioConDireccion::getNombre,
                            UsuarioDireccionDTO::setNombreCompleto);

                    // Mapear la dirección combinando calle y ciudad
                    mapper.using(ctx -> {
                        UsuarioConDireccion src = (UsuarioConDireccion) ctx.getSource();
                        if (src.getDireccion() != null) {
                            return src.getDireccion().getCalle() + ", " +
                                    src.getDireccion().getCiudad();
                        }
                        return "";
                    }).map(src -> src, UsuarioDireccionDTO::setDireccionCompleta);
                });

        // 3. Uso
        UsuarioConDireccion usuario = new UsuarioConDireccion();
        usuario.setNombre("Juan Pérez");

        Direccion direccion = new Direccion();
        direccion.setCalle("Calle Principal 123");
        direccion.setCiudad("Madrid");
        usuario.setDireccion(direccion);

        // 4. Mapeo
        UsuarioDireccionDTO dto = modelMapper.map(usuario, UsuarioDireccionDTO.class);

        // 5. Imprimir resultado
        System.out.println("Nombre: " + dto.getNombreCompleto());
        System.out.println("Dirección: " + dto.getDireccionCompleta());
    }
}
