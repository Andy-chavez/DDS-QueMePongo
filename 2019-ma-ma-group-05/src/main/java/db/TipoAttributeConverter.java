package db;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class TipoAttributeConverter implements AttributeConverter<Object, String>{
	@Override
	public String convertToDatabaseColumn(Object o) {
		return o.getClass().getSimpleName();
	}

	@Override
	public Object convertToEntityAttribute(String objectName) {
		String fullObjectName = "entities.Tipos." + objectName;
		System.out.println(fullObjectName);
		Object o = null;
		try {
			o = Class.forName(fullObjectName).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
}
