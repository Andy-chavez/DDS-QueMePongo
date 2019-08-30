package domain.Categorias;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import domain.Atuendo;
import domain.Categoria;
import domain.Prenda;

public class Accesorio extends Categoria{
	public void agregarPrendas(Atuendo atuendo, List<Prenda> prendas, int nivelAbrigoRequerido){
		List<Prenda> prendasDeEstaCategoria =  prendas.stream().filter(p -> p.esDeCategoria(this)).collect(Collectors.toList());
		Random random = new Random();
		atuendo.agregarPrenda(prendasDeEstaCategoria.get(random.nextInt(prendasDeEstaCategoria.size())));
	}
}
