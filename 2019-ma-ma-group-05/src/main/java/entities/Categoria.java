package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Entity
@Table(name = "categoria")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Categoria extends EntidadPersistente {
	// devuelve el nivel de abrigo requerido para esta categoria
	protected int calcularNivelAbrigoRequerido(Atuendo atuendo){
		return atuendo.getNivelAbrigo();
	}
	protected Prenda elegirPrendaRandom(List<Prenda> prendas){
		if(prendas.size() == 0){ return null; }
		Random random = new Random();
		return prendas.get(random.nextInt(prendas.size()));
	}

	// Filtra las prendas que cubran el nivel de temperatura del usuario y elige una al azar. Si no hay ninguna, elige la que mas abrigue
	protected List<Prenda> obtenerPrendasParaNivelAbrigo(List<Prenda> prendas, int nivelAbrigoRequerido){
		if(prendas.size() == 0) { return new ArrayList<Prenda>(); } // si prendas esta vacio, retorno un array vacio

		int margenAdmitido = 5;		
		List<Prenda> prendasConAbrigoOk = new ArrayList<Prenda>();
		do{ // si la lista que me queda al filtrar es 0, agrando el margen y pruebo de nuevo hasta que tenga al menos 1 prenda.
			int margenAdmitidoCopy = margenAdmitido; // tengo que copiar el int porque sino se queja por alguna razon el predicate de abajo :/
			Predicate<Prenda> cubreLoNecesario = p -> Math.abs(nivelAbrigoRequerido - p.getNivelAbrigo()) <= margenAdmitidoCopy;
			prendasConAbrigoOk =  prendas.stream().filter(cubreLoNecesario).collect(Collectors.toList());
			margenAdmitido *= 1.5;
		}while(prendasConAbrigoOk.size() == 0);
				
		return prendasConAbrigoOk;
	}
	
	public void agregarPrendas(Atuendo atuendo, List<Prenda> prendas, int nivelAbrigoRequerido){
		List<Prenda> prendasDeEstaCategoria =  prendas.stream().filter(p -> p.esDeCategoria(this)).collect(Collectors.toList());
		List<Prenda> prendasConAbrigoOk = obtenerPrendasParaNivelAbrigo(prendasDeEstaCategoria, nivelAbrigoRequerido);
		Prenda prendaElegida = elegirPrendaRandom(prendasConAbrigoOk);
		atuendo.agregarPrenda(prendaElegida);
		atuendo.printPrendas();
	}
	
}
