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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
}

//@Converter(autoApply = true)
//public class TipoAttributeConverter implements AttributeConverter<Tipo, String>{
//	@Override
//	public String convertToDatabaseColumn(Tipo tipo) {
//		return tipo.getClass().getSimpleName().toLowerCase();
//	}
//
//	@Override
//	public Tipo convertToEntityAttribute(String tipoName) {
//		switch(tipoName){
//			case "antiparras": return Antiparras.getInstance();
//			case "camisa": return Camisa.getInstance();
//			case "campera": return Campera.getInstance();
//			case "musculosa": return Musculosa.getInstance();
//			case "ojotas": return Ojotas.getInstance();
//			case "pantalon": return Pantalon.getInstance();
//			case "reloj": return Reloj.getInstance();
//			case "remera": return Remera.getInstance();
//			case "short": return Short.getInstance();
//			case "sweater": return Sweater.getInstance();
////			case "zapatillas": return Zapatillas.getInstance();
//			default: return Zapatillas.getInstance();
//		}
//	}
//}

