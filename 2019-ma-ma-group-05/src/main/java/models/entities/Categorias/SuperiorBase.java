package models.entities.Categorias;

import javax.persistence.*;

import models.entities.Atuendo;
import models.entities.Categoria;
@Entity
public class SuperiorBase extends Categoria{
	protected SuperiorBase(){
		this.setNombre("superior_base");
	}
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
