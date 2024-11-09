package kelmerdev.com.model;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.time.LocalDate;
import java.time.Period;

public class AgeConverter implements Converter<LocalDate, Integer> {
    @Override
    public Integer convert(MappingContext<LocalDate, Integer> context) {
        LocalDate birthDate = context.getSource();
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
