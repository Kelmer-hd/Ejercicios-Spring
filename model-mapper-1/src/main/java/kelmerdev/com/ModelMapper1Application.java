package kelmerdev.com;

import kelmerdev.com.dto.PersonDTO;
import kelmerdev.com.model.Person;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class ModelMapper1Application implements CommandLineRunner {

    private final ModelMapper modelMapper;

    public static void main(String[] args) {
        SpringApplication.run(ModelMapper1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        //ModelMapper modelMapper = new ModelMapper();

        TypeMap<Person, PersonDTO> typeMap = modelMapper.createTypeMap(Person.class, PersonDTO.class);
        typeMap.addMappings(mapper -> {
            mapper.map(src -> src.getFirstName() + " " + src.getLastName(), PersonDTO::setFullName);
            mapper.map(Person::getAge, PersonDTO::setAge);
        });


        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAge(30);

        PersonDTO personDTO = modelMapper.map(person, PersonDTO.class);

        System.out.println(personDTO);

    }
}
