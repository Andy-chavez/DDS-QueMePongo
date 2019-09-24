package entities.Categorias;

import javax.persistence.Transient;

import entities.Atuendo;
import entities.Categoria;

public class SuperiorBase extends Categoria{
	@Transient
	private static SuperiorBase singleInstance = null;
	public static SuperiorBase getInstance(){
		if(singleInstance == null){
			singleInstance = new SuperiorBase();
		}
		return singleInstance;
	}
	@Override
	public int calcularNivelAbrigoRequerido(Atuendo atuendo){
		return atuendo.getNivelAbrigo() + atuendo.getSensibilidadFrio().getSuperior();
	}
	// TODO: hacer que se puedan agregar una remera y una camisa
}