package domain.Categorias;

import javax.persistence.*;

import domain.Categoria;

@Entity
@DiscriminatorValue("inferior")
public class Inferior extends Categoria {

	@ManyToOne
	@JoinColumn(name = "categoria",referencedColumnName = "id")
	private static Inferior singleInstance = null;

	public static Inferior getInstance(){
		if(singleInstance == null){
			singleInstance = new Inferior();
		}
		return singleInstance;
	}
}
