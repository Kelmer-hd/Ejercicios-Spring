package kelmerdev.com.ejercicio_01;

import org.modelmapper.ModelMapper;

public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        Product product = new Product(1L, "Product 1", 100.0, "Product 1 description");
        System.out.println(product);

        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        System.out.println(productDTO);
    }
}