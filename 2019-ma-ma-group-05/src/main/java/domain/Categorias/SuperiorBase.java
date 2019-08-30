package domain.Categorias;

import domain.Atuendo;
import domain.Categoria;

public class SuperiorBase extends Categoria{
	@Override
	public int calcularNivelAbrigoRequerido(Atuendo atuendo){
		return atuendo.getNivelAbrigo() + atuendo.getSensibilidadFrio().getSuperior();
	}
	// TODO: hacer que se puedan agregar una remera y una camisa
}
