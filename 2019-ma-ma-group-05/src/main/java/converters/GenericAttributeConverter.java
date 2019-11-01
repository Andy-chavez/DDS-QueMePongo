package converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class GenericAttributeConverter implements AttributeConverter<Object, String>{
	@Override
	public String convertToDatabaseColumn(Object o) {
		return o.getClass().getSimpleName();
	}

	@Override
	public Object convertToEntityAttribute(String objectName) {
		String fullObjectName = "models.entities.Tipos." + objectName;
		System.out.println(fullObjectName);
		Object o = null;
		try {
			o = Class.forName(fullObjectName).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TO DO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
}


