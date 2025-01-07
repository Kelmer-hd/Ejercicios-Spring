package kelmerdev.com.repository;

import kelmerdev.com.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByUsername(String username);
}
