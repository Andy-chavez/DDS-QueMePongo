package models.entities;

import javax.persistence.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
@Entity
@Table(name = "categoria")
public abstract class Categoria  extends EntidadPersistente{
	@Column(name = "nombre")
	private String nombre;

	public static class ComparatorAbrigoPrendas implements Comparator<Prenda> {
		public int compare(Prenda a, Prenda b) {
			if (a.getNivelAbrigo() > b.getNivelAbrigo()) return 1;
			if (a.getNivelAbrigo() == b.getNivelAbrigo()) return 0;
			return -1;
		}
	}
	protected List<Prenda> obtenerPrendasCategoria(List<Prenda> prendas, Categoria categoria){
		return prendas.stream().filter(p -> p.esDeCategoria(this)).collect(Collectors.toList());
	}
	// devuelve el nivel de abrigo requerido para esta categoria
	protected int calcularNivelAbrigoRequerido(Atuendo atuendo, int nivelAbrigoRequerido){
		return nivelAbrigoRequerido;
	}
	protected Prenda elegirPrendaRandom(List<Prenda> prendas){
		if(prendas.size() == 0){ return null; }
		Random random = new Random();
		return prendas.get(random.nextInt(prendas.size()));
	}

	// obtiene la prenda que tenga el nivel de abrigo +- margen. O la que mas se acerque en caso de que no
	protected Prenda obtenerPrendaParaNivelAbrigo(List<Prenda> prendas, int nivelAbrigoRequerido) {
		if(prendas.size() == 0) return null; // si prendas esta vacio, retorno un null. Cuando se intente agregar al atuendo no lo agrega
		int margenAdmitido = ConfigReader.getIntValue("configuraciones.properties","margenAdmitido");//5;
		List<Prenda> prendasConAbrigoOk = obtenerPrendasConAbrigoOk(prendas, nivelAbrigoRequerido, margenAdmitido);

		// si no esta vacio quiere decir que las prendas de la lista cumplen exactamente con el nivel de abrigo
		if(!prendasConAbrigoOk.isEmpty()) {
			return prendasConAbrigoOk.get(0);
		}
		// si esta vacia es porque ninguna cumple adecuadamente con el nivel de abrigo
		// => comparo los extremos y elijo la que menos diferencia tenga con el nivel requerido
		Prenda prendaMasAbrigada = Collections.min(prendas, new ComparatorAbrigoPrendas());
		Prenda prendaMenosAbrigada = Collections.max(prendas, new ComparatorAbrigoPrendas());
		return Math.abs(nivelAbrigoRequerido - prendaMasAbrigada.getNivelAbrigo()) <= Math.abs(nivelAbrigoRequerido - prendaMenosAbrigada.getNivelAbrigo()) ? prendaMasAbrigada : prendaMenosAbrigada;
	}

	// filtra las prendas que cumplan con el nivel de abrigo +- margen. (puede quedar vacio)
	protected List<Prenda> obtenerPrendasConAbrigoOk(List<Prenda> prendas, int nivelAbrigoRequerido, int margen){
		Predicate<Prenda> cubreLoNecesario = p -> Math.abs(nivelAbrigoRequerido - p.getNivelAbrigo()) <= margen;
		return prendas.stream().filter(cubreLoNecesario).collect(Collectors.toList());
	}
	protected List<Prenda> filtrarCapaYaUsada(List<Prenda> prendas, int capa){
		List<Prenda> prendasFiltradas =  prendas.stream().filter(p -> p.getCapa() !=  capa).collect(Collectors.toList());
		return prendasFiltradas;
	}
	public void agregarAbrigoCategoria(Atuendo atuendo, Prenda prenda){
	}

	public void agregarPrenda(Atuendo atuendo, Prenda prenda){
		if(prenda != null){
			agregarAbrigoCategoria(atuendo, prenda);
			atuendo.agregarPrenda(prenda);
		}
	}
	
	public void agregarPrendas(Atuendo atuendo, List<Prenda> prendas, int nivelAbrigoRequerido){
		List<Prenda> prendasDeEstaCategoria = obtenerPrendasCategoria(prendas, this);
		Prenda prendaElegida = obtenerPrendaParaNivelAbrigo(prendasDeEstaCategoria, nivelAbrigoRequerido);
		agregarPrenda(atuendo, prendaElegida);
	}
	protected void setNombre(String nombre){
		this.nombre = nombre;
	}
	public String getNombre(){
		return this.nombre;
	}
}
