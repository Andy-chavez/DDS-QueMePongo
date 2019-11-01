package models.entities.Categorias;

import javax.persistence.*;

import models.entities.Atuendo;
import models.entities.Categoria;
import models.entities.Prenda;

import java.util.List;
import java.util.Random;

@Entity
public class SuperiorBase extends Categoria{
	public SuperiorBase(){
		this.setNombre("SuperiorBase");
	}
	@Override
	public int calcularNivelAbrigoRequerido(Atuendo atuendo, int nivelAbrigoRequerido){
		return nivelAbrigoRequerido - atuendo.getAbrigoSuperior();
	}

	@Override
	public void agregarAbrigoCategoria(Atuendo atuendo, Prenda prenda){
		atuendo.addAbrigoSuperior(prenda.getNivelAbrigo());
	}
}
