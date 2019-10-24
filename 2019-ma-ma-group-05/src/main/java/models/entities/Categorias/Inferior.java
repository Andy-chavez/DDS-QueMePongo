package models.entities.Categorias;

import javax.persistence.*;

import models.entities.Categoria;
@Entity
public class Inferior extends Categoria {
	public Inferior(){
		this.setNombre("Inferior");
	}
}
