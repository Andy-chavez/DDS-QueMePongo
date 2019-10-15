package converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import models.entities.EstadosEvento.*;
import models.entities.EstadosEvento.EstadoEvento;

@Converter(autoApply = true)
public class EstadoEventoAttributeConverter implements AttributeConverter<EstadoEvento, String> {

	@Override
	public String convertToDatabaseColumn(EstadoEvento attribute) {
		return attribute.getClass().getSimpleName().toLowerCase();
	}

	@Override
	public EstadoEvento convertToEntityAttribute(String dbData) {
		switch(dbData){
		case "atuendolisto":
			return new AtuendoListo();
		case "inactivo":
			return new Inactivo();
		case "pendiente":
		default:
			return new Pendiente();
		}
	}

}
