package kelmerdev.com.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String membershipNumber;
    private LocalDateTime registrationDate;
}
