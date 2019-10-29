package models.entities;

import models.entities.Categorias.Inferior;
import models.entities.Categorias.SuperiorBase;
import models.entities.Categorias.SuperiorExtra;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "atuendo")
public class Atuendo extends EntidadPersistente {

	@ManyToMany
	@JoinColumn(name = "prenda_id",referencedColumnName = "id")
	private List<Prenda> prendas;
	@Column(name = "rechazado")
	private Boolean rechazado;
	@Column(name = "calificacion")
	private int calificacion;
	@OneToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	@Column(name = "abrigo_superior")
	int abrigoSuperior;
	@Column(name = "abrigo_inferior")
	int abrigoInferior;

	public Atuendo() {
		prendas = new ArrayList<Prenda>();
		this.abrigoSuperior = 0;
		this.abrigoInferior = 0;
	}

	public Atuendo(Usuario unUsuario) {
		this();
		this.usuario = unUsuario;
	}

	public void agregarPrenda(Prenda prenda){
		if(prenda != null && !tieneTipo(prenda.getTipo())) {
			this.prendas.add(prenda);
			if(prenda.esDeCategoria(new SuperiorBase()) || prenda.esDeCategoria(new SuperiorBase())){
				this.abrigoSuperior += prenda.getNivelAbrigo();
			}
			if(prenda.esDeCategoria(new Inferior())){
				this.abrigoInferior += prenda.getNivelAbrigo();
			}
		}
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
			if(prenda.getTipo().getClass().equals(tipo.getClass())) {
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
		this.prendas.forEach(p -> p.reservarFecha(fecha));
	}
	public void reservarPrendas(){
		reservarPrendas(Instant.now());
	}
	public void liberarPrendas(Instant fecha){
		this.prendas.forEach(p -> p.liberarFecha(fecha));
	}

	// --- GETTERS Y SETTERS ---
	//public void setSensibilidadFrio(SensibilidadFrio sensibilidadFrio){	this.sensibilidadFrio = sensibilidadFrio;	}
	public SensibilidadFrio getSensibilidadFrio(){	return this.usuario.getSensibilidadFrio();	}
	public void setRechazado(Boolean flag){	this.rechazado=flag;}
	public Boolean getRechazado(){	return this.rechazado;	}
	public List<Prenda> getPrendas(){	return this.prendas;	}
	public int getAbrigoSuperior() { return abrigoSuperior; }
	public int getAbrigoInferior() { return abrigoInferior; }
}

