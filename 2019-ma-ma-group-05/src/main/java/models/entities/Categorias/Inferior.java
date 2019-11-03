package models.entities.Categorias;

import javax.persistence.*;

import models.entities.Atuendo;
import models.entities.Categoria;
import models.entities.Prenda;

@Entity
public class Inferior extends Categoria {
	public Inferior(){
		this.setNombre("Inferior");
	}
	@Override
	public void agregarAbrigoCategoria(Atuendo atuendo, Prenda prenda){
		atuendo.addAbrigoInferior(prenda.getNivelAbrigo());
	}
}
