package kelmerdev.com.ejercicio_09;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String fullName;
    private String emailAddress;
    private String phoneNumber;
}
