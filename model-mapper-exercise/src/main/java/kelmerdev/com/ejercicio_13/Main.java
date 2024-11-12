package kelmerdev.com.ejercicio_13;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(Producto.class, ProductoDTO.class)
                .addMappings(mapper -> {
                    mapper.map(Producto::getNombre, ProductoDTO::setNombre);
                    mapper.using(new AbstractConverter<Double, String>() {
                        @Override
                        protected String convert(Double precio) {
                            return String.format("$%.2f", precio);
                        }
                    }).map(Producto::getPrecio, ProductoDTO::setPrecioFormateado);
                });

        List<Producto> productos = Arrays.asList(
                new Producto(1L, "Juan Perez", 100.0, "Electrónica"),
                new Producto(2L, "MacBook Pro", 500.0, "Electrónica")
        );

        // Mapear la lista completa
        List<ProductoDTO> productosDTO = productos.stream()
                .map(producto -> modelMapper.map(producto, ProductoDTO.class))
                .collect(Collectors.toList());

        // Imprimir resultado
        productosDTO.forEach(productoDTO -> {
            System.out.println("Nombre: " + productoDTO.getNombre());
            System.out.println("Precio: " + productoDTO.getPrecioFormateado());
        });
    }
}