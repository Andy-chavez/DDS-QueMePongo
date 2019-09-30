package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import domain.Atuendo;
import domain.Prenda;

@Entity
@Table(name = "guardarropa")
public class Guardarropa extends EntidadPersistente{

	@Column(name = "nombre")
	private String nombre;

	@OneToMany
	@JoinColumn(name = "prenda_id", referencedColumnName = "id")
	private List<Prenda> prendas;

	@OneToMany
	@JoinColumn(name = "atuendos_sugeridos", referencedColumnName = "id")
	private List<Atuendo> atuendosSugeridos;

	@Transient //TODO cambiar cuando decidamos eso bien
	private List<MoldeAtuendo> moldesAtuendos;

	public Guardarropa(String unNombre, List<Prenda> unasPrendas) {
		this.nombre = unNombre;
		this.prendas = new ArrayList<Prenda>();
		this.atuendosSugeridos = new ArrayList<Atuendo>();
		this.agregarPrendas(unasPrendas);
		this.moldesAtuendos = new ArrayList<MoldeAtuendo>();

	}
	// --- GETTERS Y SETTERS ---
	public List<MoldeAtuendo> getMoldesAtuendos(){ 	return this.moldesAtuendos;	}
	public void agregarMoldeAtuendo(MoldeAtuendo moldeAtuendo){
		this.moldesAtuendos.add(moldeAtuendo); 	}
	public String getNombre() { return this.nombre;	}
	public void setNombre(String unNombre) { this.nombre = unNombre;}
	public List<Prenda> getPrendas() {	return this.prendas; }
	public List<Atuendo> getAtuendosSugeridos(){ return this.atuendosSugeridos;	}

	public void agregarPrenda(Prenda prenda) { 
		this.prendas.add(prenda); 
	}
	public void agregarPrendas(List<Prenda> unasPrendas) { 
		this.prendas.addAll(unasPrendas); 
	}

	public int cantidadDePrendas() {
		return this.prendas.size();
	}
	
	public Boolean tieneLaPrenda(Prenda unaPrenda) {
		return this.getPrendas().stream().anyMatch(prenda -> prenda.esIgualA(unaPrenda));
	}

	public void agregarSugerencia(Atuendo atuendo) {
		this.atuendosSugeridos.add(atuendo);
	}
	
	public void eliminarAtuendoSugerido(Atuendo atuendo) {
		for (Atuendo atuendoYaSugerido : this.atuendosSugeridos) {
			if(atuendo.compararConOtroAtuendo(atuendoYaSugerido)) {
				this.atuendosSugeridos.remove(atuendo);
			}
		}
	}

}
