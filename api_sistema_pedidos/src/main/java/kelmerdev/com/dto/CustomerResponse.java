package kelmerdev.com.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private List<String> address;
}
