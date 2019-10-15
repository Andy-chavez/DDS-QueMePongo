package entities.Categorias;

import javax.persistence.*;

import entities.Categoria;

@Entity
@DiscriminatorValue("calzado")
public class Calzado extends Categoria {

	@Transient
	private static Calzado singleInstance = null;

	public static Calzado getInstance(){
		if(singleInstance == null){
			singleInstance = new Calzado();
		}
		return singleInstance;
	}
}
