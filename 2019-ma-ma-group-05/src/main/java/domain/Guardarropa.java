package domain;

import java.util.List;

public class Guardarropa {
	private String nombre;
	private List<Prenda> prendas;
	private List<Atuendo> atuendosRechazados;
	//getters y setters
	public String getNombre(){return this.nombre;}
	public void setNombre(String unNombre){
		this.nombre=unNombre;
	}
	
	public List<Prenda> getPrendas(){return this.prendas;}
	public void agregarPrenda(Prenda prenda){
		this.prendas.add(prenda);
	}
	public void agregarPrendas(List<Prenda> prendas) {
		this.prendas.addAll(prendas);
	}
	
	public List <Atuendo> getAtuendosRechazados(){return this.atuendosRechazados;}
	
	public Atuendo obtenerSugerencia(){
		return new Atuendo();//Falta implementacion de la combinatoria
		
	}
	
}
