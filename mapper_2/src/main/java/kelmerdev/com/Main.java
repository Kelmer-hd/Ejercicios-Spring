package kelmerdev.com;

import org.modelmapper.ModelMapper;

public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        // Configuración de mapeo profundo
        modelMapper.typeMap(Cliente.class, ClienteDTO.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getDireccion().getCalle() + ", " +
                                    src.getDireccion().getCiudad(),
                            ClienteDTO::setDireccionCompleta);
                });
    }
}