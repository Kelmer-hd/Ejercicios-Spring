package kelmerdev.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String customerFirstName;
    private String customerLastName;
    private String billingAddressStreet;
    private String billingAddressCity;
}
