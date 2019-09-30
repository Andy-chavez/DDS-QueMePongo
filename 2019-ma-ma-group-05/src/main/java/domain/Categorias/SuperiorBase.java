package domain.Categorias;

import javax.persistence.*;

import domain.Atuendo;
import domain.Categoria;

@Entity
@DiscriminatorValue("superior_base")
public class SuperiorBase extends Categoria{

	@ManyToOne
	@JoinColumn(name = "categoria",referencedColumnName = "id")
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
