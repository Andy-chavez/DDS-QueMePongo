package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import domain.Prenda;

public class Atuendo {

	private List<Prenda> prendas = new ArrayList<Prenda>();;
	private Boolean rechazado;
	private int nivelAbrigo;
	private SensibilidadFrio sensibilidadFrio;

	public void setNivelAbrigo(int nivelAbrigo){
		this.nivelAbrigo = nivelAbrigo;
	}
	
	public void setSensibilidadFrio(SensibilidadFrio sf){
		this.sensibilidadFrio = sf;
	}
	
	public SensibilidadFrio getSensibilidadFrio(){
		return this.sensibilidadFrio;
	}
	
	public void setRechazado(Boolean flag){this.rechazado=flag;}
	public Boolean getRechazado(){return this.rechazado;}
	
	public void agregarPrenda(Prenda prenda){
		if(prenda != null && !tieneTipo(prenda.getTipo())) {
			this.prendas.add(prenda);
		}
	}
	
	public void agregarPrendas(List<Prenda> prendas){
		for(Prenda p : prendas){
			agregarPrenda(p);
		}
	}
	
	public List<Prenda> getPrendas(){return this.prendas;}

	public Boolean compararConOtroAtuendo(Atuendo atuendo){
		if(this.prendas.size() != atuendo.getPrendas().size()){
			return false;
		}
		for(Prenda unaPrenda : this.prendas){
			boolean contienePrenda = false;
			for(Prenda otraPrenda : atuendo.getPrendas()){
				if(unaPrenda.getTipo().getNombre().equals(otraPrenda.getTipo().getNombre())){
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
	
	public int getNivelAbrigo() {
		return this.nivelAbrigo;
	}
	
	public void printPrendas(){
		for(Prenda prenda : this.prendas){
			System.out.println(prenda.getTipo().getNombre());
		}
	}
	
}
