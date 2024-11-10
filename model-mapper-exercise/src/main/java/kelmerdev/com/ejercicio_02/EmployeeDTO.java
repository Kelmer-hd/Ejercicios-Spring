package kelmerdev.com.ejercicio_02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long employeeId;
    private String fullName;        // Combinar firstName y lastName
    private String yearsEmployed;   // Calcular años desde hireDate
    private String formattedSalary; // Formatear con símbolo de moneda
}
