package kelmerdev.com.modelmapper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDefaultDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private  byte age;
    private  Character gender;
}
