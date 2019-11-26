package converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true)
public class InstantAttributeConverter implements AttributeConverter<Instant, String> {

    @Override
    public String convertToDatabaseColumn(Instant instant) {
        LocalDate locDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        return instant.toString();
    }

    @Override
    public Instant convertToEntityAttribute(String dbData) {
        DateTimeFormatter fmt = DateTimeFormatter.ISO_INSTANT;
        return (Instant) fmt.parse(dbData, Instant::from);
    }

}