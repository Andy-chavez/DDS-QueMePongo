package models.entities.Categorias;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.persistence.*;

import models.entities.Atuendo;
import models.entities.Categoria;
import models.entities.Prenda;

@Entity
public class Accesorio extends Categoria{
	public Accesorio(){
		this.setNombre("Accesorio");
	}
	public void agregarPrendas(Atuendo atuendo, List<Prenda> prendas, int nivelAbrigoRequerido){
		List<Prenda> prendasDeEstaCategoria =  prendas.stream().filter(p -> p.esDeCategoria(this)).collect(Collectors.toList());
		Random random = new Random();
		atuendo.agregarPrenda(prendasDeEstaCategoria.get(random.nextInt(prendasDeEstaCategoria.size())));
	}
}
