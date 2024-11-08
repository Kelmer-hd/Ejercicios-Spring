package kelmerdev.com;

import kelmerdev.com.dto.OrderDTO;
import kelmerdev.com.model.Address;
import kelmerdev.com.model.Customer;
import kelmerdev.com.model.Order;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class ModelMapperApplication implements CommandLineRunner {

    private ModelMapper modelMapper;

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(ModelMapperApplication.class, args);
    }

    public void run(String... args) throws Exception {
        Customer customer = new Customer("Francisco", "Ibáñez");
        Address billigAddress = new Address("c\\ Rue del Percebe, 13", "Madrid");
        Order order = new Order(customer, billigAddress);

        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

        System.out.printf("Customer First Name: %s%n", orderDTO.getCustomerFirstName());
        System.out.printf("Customer Last Name: %s%n", orderDTO.getCustomerLastName());
        System.out.printf("Billing Address Street: %s%n", orderDTO.getBillingAddressStreet());
        System.out.printf("Billing Address City: %s%n", orderDTO.getBillingAddressCity());
    }
}
