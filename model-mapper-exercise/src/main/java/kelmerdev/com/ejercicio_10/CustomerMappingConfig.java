package kelmerdev.com.ejercicio_10;

import kelmerdev.com.ejercicio_09.Customer;
import kelmerdev.com.ejercicio_09.CustomerDTO;
import org.modelmapper.ModelMapper;


public class CustomerMappingConfig {
    private final ModelMapper modelMapper;


    public CustomerMappingConfig(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    private void configureMapper() {
        modelMapper.createTypeMap(CustomerDTO.class, Customer.class)
                .addMappings(mapper -> {
                    // Mapear fullName a firstName y lastName
                    mapper.map(src -> src.getFullName().split(" ")[0], Customer::setFirstName);
                    mapper.map(src -> src.getFullName().split(" ")[1], Customer::setLastName);
                    // Mapear campos con nombres diferentes
                    mapper.map(CustomerDTO::getEmailAddress, Customer::setEmail);
                    mapper.map(CustomerDTO::getPhoneNumber, Customer::setPhone);
                });
    }

    public Customer toCustomer(CustomerDTO dto) {
        return modelMapper.map(dto, Customer.class);
    }
}
