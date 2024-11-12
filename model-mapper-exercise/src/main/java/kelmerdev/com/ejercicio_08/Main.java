package kelmerdev.com.ejercicio_08;

import org.modelmapper.ModelMapper;

public class Main {
    public static void main(String[] args) {
        // 1. Crear una instancia de ModelMapper
        ModelMapper modelMapper = new ModelMapper();

        // 2. Configurar el mapeo condicional
        modelMapper.typeMap(Cliente.class, ClienteDTO.class)
                .addMappings(mapper -> {
                    mapper.map(Cliente::getNombre, ClienteDTO::setNombreCliente);
                    mapper.map(Cliente::getTelefono, ClienteDTO::setInfoContacto);
                })
                .setPostConverter(context -> {
                    Cliente cliente = context.getSource();
                    ClienteDTO clienteDTO = context.getDestination();

                    // Mapeo condicional de la dirección
                    if (cliente.getDireccion() != null) {
                        String direccionCompleta = String.format("%s, %s, %s",
                                cliente.getDireccion().getCalle(),
                                cliente.getDireccion().getCiudad(),
                                cliente.getDireccion().getPais());
                        clienteDTO.setDireccionCompleta(direccionCompleta);
                    }

                    return clienteDTO;
                });


        // 3. Crear objetos de prueba - Caso con dirección
        Direccion direccion = new Direccion();
        direccion.setCalle("Av. Principal 123");
        direccion.setCiudad("Madrid");
        direccion.setPais("España");

        Cliente clienteConDireccion = new Cliente();
        clienteConDireccion.setNombre("María García");
        clienteConDireccion.setTelefono("+34 666 777 888");
        clienteConDireccion.setDireccion(direccion);

        // 4. Crear cliente sin dirección
        Cliente clienteSinDireccion = new Cliente();
        clienteSinDireccion.setNombre("Pedro López");
        clienteSinDireccion.setTelefono("+34 999 888 777");
        clienteSinDireccion.setDireccion(null);

        // 5. Realizar mapeos
        ClienteDTO clienteDTO1 = modelMapper.map(clienteConDireccion, ClienteDTO.class);
        ClienteDTO clienteDTO2 = modelMapper.map(clienteSinDireccion, ClienteDTO.class);

        // 6. Verificar resultados
        System.out.println("Cliente 1 (con dirección):");
        System.out.println("Nombre: " + clienteDTO1.getNombreCliente());
        System.out.println("Contacto: " + clienteDTO1.getInfoContacto());
        System.out.println("Dirección: " + clienteDTO1.getDireccionCompleta());

        System.out.println("\nCliente 2 (sin dirección):");
        System.out.println("Nombre: " + clienteDTO2.getNombreCliente());
        System.out.println("Contacto: " + clienteDTO2.getInfoContacto());
        System.out.println("Dirección: " + clienteDTO2.getDireccionCompleta());
    }
}

