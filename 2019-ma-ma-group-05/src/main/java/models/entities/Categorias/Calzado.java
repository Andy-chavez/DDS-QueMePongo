package models.entities.Categorias;

import javax.persistence.*;

import models.entities.Atuendo;
import models.entities.Categoria;
import models.entities.Prenda;

@Entity
@DiscriminatorValue(value = "Calzado")
public class Calzado extends Categoria {
	public Calzado(){
		this.setNombre("Calzado");
	}
	@Override
	public void agregarAbrigoCategoria(Atuendo atuendo, Prenda prenda){
		atuendo.addAbrigoCalzado(prenda.getNivelAbrigo());
	}
}
