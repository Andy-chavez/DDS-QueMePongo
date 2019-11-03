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

	// hace lo mismo que Categoria pero no checkea temperatura
	public void agregarPrendas(Atuendo atuendo, List<Prenda> prendas, int nivelAbrigoRequerido){
		List<Prenda> prendasDeEstaCategoria = obtenerPrendasCategoria(prendas, this);
		Random random = new Random();
		Prenda prendaElegida = prendasDeEstaCategoria.get(random.nextInt(prendasDeEstaCategoria.size()));
		agregarPrenda(atuendo, prendaElegida);
	}
}
