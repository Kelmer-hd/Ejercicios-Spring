package kelmerdev.com;

import kelmerdev.com.modelmapper.dto.PersonCustomDto;
import kelmerdev.com.modelmapper.dto.PersonDefaultDto;
import kelmerdev.com.modelmapper.entities.Person;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MappersExamples2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MappersExamples2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Model Mapper - Default
        /*
        ModelMapper modelMapper = new ModelMapper();

        Person person = new Person(1L, "John", "Doe", "john.doe@example.com", (byte) 18, 'M');
        System.out.println(person);

        PersonDefaultDto personDefaultDto = modelMapper.map(person, PersonDefaultDto.class);
        System.out.println(personDefaultDto);

        */

        // Model Mapper - Custom

        ModelMapper modelMapper = new ModelMapper();

        TypeMap<Person, PersonCustomDto> propertyMapper = modelMapper.createTypeMap(Person.class, PersonCustomDto.class);
        propertyMapper.addMapping(Person::getId, PersonCustomDto::setIdDto);
        propertyMapper.addMapping(Person::getName, PersonCustomDto::setNameDto);
        propertyMapper.addMapping(Person::getLastName, PersonCustomDto::setLastNameDto);
        propertyMapper.addMapping(Person::getEmail, PersonCustomDto::setEmailDto);
        propertyMapper.addMapping(Person::getGender, PersonCustomDto::setGenderDto);


        Person person = new Person(1L, "John", "Doe", "john.doe@example.com", (byte) 18, 'M');
        System.out.println(person);

        PersonCustomDto personCustomDto = propertyMapper.map(person);
        System.out.println(personCustomDto);


    }
}
