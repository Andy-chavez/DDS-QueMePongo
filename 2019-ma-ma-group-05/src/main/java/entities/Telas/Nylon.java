package entities.Telas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import entities.Tela;

@Entity
@DiscriminatorValue("nylon")
public class Nylon extends Tela{
    private static Nylon singleInstance = null;

	public static Nylon getInstance(){
		if(singleInstance == null){
			singleInstance = new Nylon();
		}
		return singleInstance;
	}
	public Nylon() {
		this.nombre = "nylon";
	}
}
