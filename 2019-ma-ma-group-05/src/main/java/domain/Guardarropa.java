package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import domain.Atuendo;
import domain.Prenda;

public class Guardarropa {
	private String nombre;
	private List<Prenda> prendas;
	private List<Atuendo> atuendosSugeridos;
	private ObtenerSugerencia obtenerSugerencia;
	private List<MoldeAtuendo> moldesAtuendos;

	public Guardarropa(String unNombre, List<Prenda> unasPrendas) {
		this.nombre = unNombre;
		this.prendas = new ArrayList<Prenda>();
		this.atuendosSugeridos = new ArrayList<Atuendo>();
		this.agregarPrendas(unasPrendas);
		this.obtenerSugerencia = new ObtenerSugerencia();
		this.moldesAtuendos = new ArrayList<MoldeAtuendo>();

	}
	
	public List<MoldeAtuendo> getMoldesAtuendos(){
		return this.moldesAtuendos;
	}
	
	public void agregarMoldeAtuendo(MoldeAtuendo moldeAtuendo){
		this.moldesAtuendos.add(moldeAtuendo);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}

	public List<Prenda> getPrendas() {
		return this.prendas;
	}

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
	
	public List<Atuendo> getAtuendosSugeridos(){
		return this.atuendosSugeridos;
	}

	@SuppressWarnings("unused")
	private Prenda crearNuevaPrenda(Tipo tipoDeEstaPrenda, Tela unaTela, Color colorPrimario,Color colorSecundario){
		tipoDeEstaPrenda.establecerTela(unaTela);
		Prenda nuevaPrenda = new Prenda(tipoDeEstaPrenda,colorPrimario,colorSecundario);
		return nuevaPrenda;
	}
	@SuppressWarnings("unused")
	private Prenda crearNuevaPrenda(Tipo tipoDeEstaPrenda, Tela unaTela, Color colorPrimario,Color colorSecundario, String pathToImg){
		tipoDeEstaPrenda.establecerTela(unaTela);
		Prenda nuevaPrenda = new Prenda(tipoDeEstaPrenda,colorPrimario,colorSecundario);
		nuevaPrenda.setImage(pathToImg);
		return nuevaPrenda;
	}
	

	public Atuendo obtenerSugerencia(double temperatura, SensibilidadFrio sensibilidadFrio) {
		return obtenerSugerencia.obtenerSugerencia(this, temperatura, sensibilidadFrio);
	}
	

}
