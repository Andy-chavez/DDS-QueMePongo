package domain.Categorias;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.persistence.*;

import domain.Atuendo;
import domain.Categoria;
import domain.Prenda;

@Entity
@DiscriminatorValue("accesorio")
public class Accesorio extends Categoria{

	@ManyToOne
	@JoinColumn(name = "categoria",referencedColumnName = "id")
	private static Accesorio singleInstance = null;

	public static Accesorio getInstance(){
		if(singleInstance == null){
			singleInstance = new Accesorio();
		}
		return singleInstance;
	}
	public void agregarPrendas(Atuendo atuendo, List<Prenda> prendas, int nivelAbrigoRequerido){
		List<Prenda> prendasDeEstaCategoria =  prendas.stream().filter(p -> p.esDeCategoria(this)).collect(Collectors.toList());
		Random random = new Random();
		atuendo.agregarPrenda(prendasDeEstaCategoria.get(random.nextInt(prendasDeEstaCategoria.size())));
	}
}
