package models.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "guardarropa")
public class Guardarropa extends EntidadPersistente{

	@Column(name = "nombre")
	private String nombre;
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "guardarropa_id", referencedColumnName = "id")
	private List<Prenda> prendas;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "guardarropa_id", referencedColumnName = "id")
	private List<Atuendo> atuendosSugeridos;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "guardarropa_id", referencedColumnName = "id")
	private List<Atuendo> atuendosRechazados;

	public Guardarropa() {}
	public Guardarropa(String unNombre, List<Prenda> unasPrendas) {
		this.nombre = unNombre;
		this.prendas = new ArrayList<Prenda>();
		this.atuendosSugeridos = new ArrayList<Atuendo>();
		this.atuendosRechazados = new ArrayList<Atuendo>();
		this.agregarPrendas(unasPrendas);

	}
	public Guardarropa(String unNombre) {
		this.nombre = unNombre;
		this.prendas = new ArrayList<Prenda>();
		this.atuendosSugeridos = new ArrayList<Atuendo>();
		this.atuendosRechazados = new ArrayList<Atuendo>();

	}
	// --- GETTERS Y SETTERS ---
	public String getNombre() { return this.nombre;	}
	public void setNombre(String unNombre) { this.nombre = unNombre;}
	public List<Prenda> getPrendas() {	return this.prendas; }
	public List<Atuendo> getAtuendosSugeridos(){ return this.atuendosSugeridos;	}
	public List<Atuendo> getAtuendosRechazados(){ return this.atuendosRechazados;	}

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
	public void agregarAtuendoRechazado(Atuendo atuendo) {
		this.atuendosRechazados.add(atuendo);
	}

	public void eliminarAtuendoSugerido(Atuendo atuendo) {
		for (Atuendo atuendoYaSugerido : this.atuendosSugeridos) {
			if(atuendo.compararConOtroAtuendo(atuendoYaSugerido)) {
				this.atuendosSugeridos.remove(atuendo);
			}
		}
	}

}