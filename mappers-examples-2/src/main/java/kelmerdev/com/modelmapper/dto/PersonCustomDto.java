package kelmerdev.com.modelmapper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonCustomDto {
    private Long idDto;
    private String nameDto;
    private String lastNameDto;
    private String emailDto;
    private  byte ageDto;
    private  Character genderDto;
}
