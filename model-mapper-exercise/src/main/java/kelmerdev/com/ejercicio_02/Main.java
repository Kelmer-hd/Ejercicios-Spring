package kelmerdev.com.ejercicio_02;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        Employee employee = new Employee(1L, "John", "Doe", LocalDate.of(1990, 1, 1), new BigDecimal(1000));
        System.out.println(employee);

        TypeMap<Employee, EmployeeDTO> propertyMapper = modelMapper.createTypeMap(Employee.class, EmployeeDTO.class);
        propertyMapper.addMapping(Employee::getId, EmployeeDTO::setEmployeeId);
        propertyMapper.addMapping(Employee::getFirstName, EmployeeDTO::setFullName);
        propertyMapper.addMapping(Employee::getLastName, EmployeeDTO::setFullName);
        propertyMapper.addMapping(Employee::getHireDate, EmployeeDTO::setYearsEmployed);
        propertyMapper.addMapping(Employee::getSalary, EmployeeDTO::setFormattedSalary);

        EmployeeDTO employeeDTO = propertyMapper.map(employee);
        System.out.println(employeeDTO);
    }
}
