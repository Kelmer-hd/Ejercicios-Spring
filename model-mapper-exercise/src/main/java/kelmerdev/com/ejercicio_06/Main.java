package kelmerdev.com.ejercicio_06;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1. Crear una instancia de ModelMapper
        ModelMapper modelMapper = new ModelMapper();

        // 2. Configurar el mapeo personalizado
        modelMapper.typeMap(Libro.class, LibroDTO.class)
                .addMappings(mapper -> {
                    mapper.map(Libro::getTitulo, LibroDTO::setTituloLibro);
                    mapper.map(Libro::getAutor, LibroDTO::setNombreAutor);
                    mapper.map(Libro::getAnioPublicacion, LibroDTO::setAnioEdicion);
                });

        // 3. Crear lista de libros de prueba
        List<Libro> libros = new ArrayList<>();

        Libro libro1 = new Libro();
        libro1.setTitulo("El libro de la vida");
        libro1.setAutor("Juan Perez");
        libro1.setAnioPublicacion(2000);

        Libro libro2 = new Libro();
        libro2.setTitulo("El libro de la muerte");
        libro2.setAutor("Juan Perez");
        libro2.setAnioPublicacion(2010);

        libros.add(libro1);
        libros.add(libro2);

        // 4. Mapear la lista completa usando Stream
        List<LibroDTO> librosDTO = libros.stream()
                .map(libro -> modelMapper.map(libro, LibroDTO.class))
                .collect(Collectors.toList());

        // 5. Verificar el resultado
        librosDTO.forEach(libroDTO -> {
            System.out.println("Título: " + libroDTO.getTituloLibro());
            System.out.println("Autor: " + libroDTO.getNombreAutor());
            System.out.println("Año: " + libroDTO.getAnioEdicion());
            System.out.println("---");
        });

    }
}
