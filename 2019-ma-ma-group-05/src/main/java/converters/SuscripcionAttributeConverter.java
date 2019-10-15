package converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import models.entities.Suscripcion;
import models.entities.Suscripciones.Free;
import models.entities.Suscripciones.Premium;

@Converter(autoApply = true)
public class SuscripcionAttributeConverter implements AttributeConverter<Suscripcion, String>{

	@Override
	public String convertToDatabaseColumn(Suscripcion attribute) {
		return attribute.getClass().getSimpleName().toLowerCase();
	}

	@Override
	public Suscripcion convertToEntityAttribute(String dbData) {
		switch(dbData){
		case "free":
			return Free.getInstance();
		
		case "premium":
			return Premium.getInstance();
		default:
			return Free.getInstance();
		}
	}
}
