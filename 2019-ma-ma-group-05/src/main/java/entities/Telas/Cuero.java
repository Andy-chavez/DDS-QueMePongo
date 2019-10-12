package entities.Telas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import entities.Tela;

@Entity
@DiscriminatorValue("cuero")
public class Cuero extends Tela{
    private static Cuero singleInstance = null;

	public static Cuero getInstance(){
		if(singleInstance == null){
			singleInstance = new Cuero();
		}
		return singleInstance;
	}
	public Cuero() {
		this.nombre = "cuero";
	}
}
