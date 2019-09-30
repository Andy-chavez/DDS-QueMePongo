package domain.Categorias;

import javax.persistence.*;

import domain.Categoria;

@Entity
@DiscriminatorValue("calzado")
public class Calzado extends Categoria {

	@ManyToOne
	@JoinColumn(name = "categoria",referencedColumnName = "id")
	private static Calzado singleInstance = null;

	public static Calzado getInstance(){
		if(singleInstance == null){
			singleInstance = new Calzado();
		}
		return singleInstance;
	}
}
