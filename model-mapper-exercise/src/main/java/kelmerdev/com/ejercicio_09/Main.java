package kelmerdev.com.ejercicio_09;

import org.modelmapper.ModelMapper;

public class Main {
    public static void main(String[] args){

        // 1. Crear una instancia de ModelMapper
        ModelMapper modelMapper = new ModelMapper();

        // 2. Configuracion del mapeo personalizado
        modelMapper.typeMap(CustomerDTO.class, Customer.class)
                .addMappings(mapper -> {
                    mapper.map(CustomerDTO::getFullName, Customer::setFirstName);
                    mapper.map(CustomerDTO::getFullName, Customer::setLastName);
                    mapper.map(CustomerDTO::getEmailAddress, Customer::setEmail);
                    mapper.map(CustomerDTO::getPhoneNumber, Customer::setPhone);
                });

        // 3: Crear objetos de prueba
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFullName("Juan Perez");
        customerDTO.setEmailAddress("juanperez@gmail.com");
        customerDTO.setPhoneNumber("+34 666 777 888");

        // 4: Ralizar el mapeo
        Customer customer = modelMapper.map(customerDTO, Customer.class);

        // 5. Verificar resultados
        System.out.println("Nombre: " + customer.getFirstName());
        System.out.println("Apellido: " + customer.getLastName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Teléfono: " + customer.getPhone());
    }
}
