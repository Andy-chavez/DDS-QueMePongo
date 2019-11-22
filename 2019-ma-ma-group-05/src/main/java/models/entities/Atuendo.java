package models.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.persistence.*;

@Entity
@Table(name = "atuendo")
public class Atuendo extends EntidadPersistente {

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "prenda_id",referencedColumnName = "id")
	private List<Prenda> prendas;
	@Column(name = "rechazado")
	private Boolean rechazado;
	@Column(name = "calificacion")
	private int calificacion;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	@Column(name = "abrigo_superior")
	int abrigoSuperior;
	@Column(name = "abrigo_inferior")
	int abrigoInferior;
	@Column(name = "abrigo_calzado")
	int abrigoCalzado;

	public Atuendo() {
		prendas = new ArrayList<Prenda>();
		this.abrigoSuperior = 0;
		this.abrigoInferior = 0;
		this.abrigoCalzado = 0;
		this.rechazado = false;
	}

	public Atuendo(Usuario unUsuario) {
		this();
		this.usuario = unUsuario;
	}

	public void addPrenda(Prenda prenda){
		this.prendas.add(prenda);
	}

	public void agregarPrenda(Prenda prenda){
		if(prenda != null && !tieneTipo(prenda.getTipo())) {
			prendas.add(prenda);
//			System.out.println("Abrigo " + prenda.getTipo().getNombre() + ": " + prenda.getNivelAbrigo());
		}
		else System.out.println("prenda null o ya tiene tipo");
	}

	public void agregarPrendas(List<Prenda> prendas){
		for(Prenda p : prendas){
			agregarPrenda(p);
		}
	}


	public Boolean compararConOtroAtuendo(Atuendo atuendo){
		if(this.prendas.size() != atuendo.getPrendas().size()){
			return false;
		}
		for(Prenda unaPrenda : this.prendas){
			boolean contienePrenda = false;
			for(Prenda otraPrenda : atuendo.getPrendas()){
				if(unaPrenda.equals(otraPrenda)){
					contienePrenda = true;
				}
			}
			if(!contienePrenda){
				return false;
			}
		}
		return true;
	}

	public boolean tieneTipo(Tipo tipo) {
		for (Prenda prenda : this.prendas) {
			if(prenda.getTipo().getNombre().equals(tipo.getNombre())) {
				return true;
			}
		}
		return false;
	}

	public List<Prenda> filtrarPrendasSegunCondicion(List<Prenda> prendas, Predicate<Prenda> predicado) {
		return prendas.stream().filter(predicado).collect(Collectors.toList());
	}

	public int getNivelAbrigoDeCategoria(Categoria unaCategoria){
		int nivelAbrigo = 0;
		for(Prenda p : this.prendas){
			if(p.esDeCategoria(unaCategoria)){
				nivelAbrigo += p.getNivelAbrigo();
			}
		}
		return nivelAbrigo;
	}


	public void printPrendas(){
		System.out.print("Atuendo: ");
		for(Prenda prenda : this.prendas){
			System.out.print(prenda.getTipo().getNombre() + " ");
		}
		System.out.println();
	}

	public void reservarPrendas(Instant fecha){
		this.prendas.forEach(p -> p.reservarFecha(fecha,this.usuario));
	}
	public void reservarPrendas(){
		this.reservarPrendas(Instant.now());
	}
	public void liberarPrendas(Instant fecha){
		this.prendas.forEach(p -> p.liberarFecha(fecha));
	}

	// --- GETTERS Y SETTERS ---
	public void setRechazado(Boolean flag){	this.rechazado=flag;}
	public Boolean getRechazado(){	return this.rechazado;	}
	public List<Prenda> getPrendas(){	return this.prendas;	}
	public int getAbrigoSuperior() { return abrigoSuperior; }
	public int getAbrigoInferior() { return abrigoInferior; }
	public int getAbrigoCalzado() { return abrigoCalzado; }
	public void addAbrigoSuperior(int cantidad) { this.abrigoSuperior += cantidad; }
	public void addAbrigoInferior(int cantidad) { this.abrigoInferior += cantidad; }
	public void addAbrigoCalzado(int cantidad) { this.abrigoCalzado += cantidad; }
}

