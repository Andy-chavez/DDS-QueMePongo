package models.entities.Categorias;

import javax.persistence.*;

import models.entities.Atuendo;
import models.entities.Categoria;
@Entity
public class SuperiorBase extends Categoria{
	public SuperiorBase(){
		this.setNombre("SuperiorBase");
	}
	@Override
	public int calcularNivelAbrigoRequerido(Atuendo atuendo){
		return atuendo.getNivelAbrigo() + atuendo.getSensibilidadFrio().getSuperior();
	}
	// TODO: hacer que se puedan agregar una remera y una camisa
}
