package kelmerdev.com.ejercicio_05;

import org.modelmapper.ModelMapper;

public class Main {
    public static void main(String[] args) {

        // 1. Crear una instancia de ModelMapper
        ModelMapper modelMapper = new ModelMapper();

        // 2. Configurar el mapeo personalizado
        modelMapper.typeMap(Persona.class, PersonaDTO.class)
                .addMappings(mapper -> {
                    mapper.map(Persona::getNombre, PersonaDTO::setNombreCompleto);
                    mapper.map(Persona::getEdad, PersonaDTO::setAniosVividos);
                });

        // 3. Crear y configurar objeto fuente
        Persona persona = new Persona();
        persona.setNombre("Juan Perez");
        persona.setEdad(30);

        // 4. Realizar el mapeo
        PersonaDTO personaDTO = modelMapper.map(persona, PersonaDTO.class);

        // 5. Imprimir el resultado
        System.out.println("Nombre: " + personaDTO.getNombreCompleto()); // Juan Pérez
        System.out.println("Años: " + personaDTO.getAniosVividos());    // 25


    }
}
