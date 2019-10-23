package models.entities.Categorias;

import javax.persistence.*;

import models.entities.Categoria;
@Entity
public class Calzado extends Categoria {
	public Calzado(){
		this.setNombre("Calzado");
	}
}
