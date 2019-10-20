package converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Converter(autoApply = true)
public class InstantAttributeConverter implements AttributeConverter<Instant, Date> {

    @Override
    public Date convertToDatabaseColumn(Instant instant) {
        LocalDate locDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        return locDate == null ? null : Date.valueOf(locDate);
    }

    @Override
    public Instant convertToEntityAttribute(Date sqlDate) {
        return sqlDate == null ? null : sqlDate.toInstant();
    }
}