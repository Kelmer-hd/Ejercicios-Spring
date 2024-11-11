package kelmerdev.com.ejercicio_04;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        // Mapeo Basico
        /*
        Source source = new Source();
        source.setNombre("Juan");
        source.setEdad(10);
        System.out.println(source);

        Destination destination = modelMapper.map(source, Destination.class);
        System.out.println(destination);

         */

        // Mapeo de Lista


        List<Source> sourceList = Arrays.asList(new Source(), new Source());
        List<Destination> destinationList = sourceList.stream()
                .map(source -> modelMapper.map(source, Destination.class))
                .collect(Collectors.toList());
    }
}
