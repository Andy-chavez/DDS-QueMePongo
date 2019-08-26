package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.List;

import domain.Prenda;

public class Atuendo implements Cloneable {

	private HashMap<String, Prenda> map = new HashMap<String,Prenda>();;
	private Boolean rechazado;
	private int nivelAbrigo;

	public void setNivelAbrigo(int nivelAbrigo){
		this.nivelAbrigo = nivelAbrigo;
	}
	
	public void setRechazado(Boolean flag){this.rechazado=flag;}
	public Boolean getRechazado(){return this.rechazado;}
	
	public void agregarPrenda(Prenda prenda){
		if(prenda != null && !this.tieneCapa(prenda.getCapa())) {
			this.map.put(prenda.getTipo().getNombre().toLowerCase(), prenda);	
		}
	}
	
	public void agregarPrendas(List<Prenda> prendas){
		for(Prenda p : prendas){
			agregarPrenda(p);
		}
	}
	
	public HashMap<String,Prenda> getMap(){return this.map;}

	public Boolean compararConOtroAtuendo(Atuendo atuendo){
		if(this.map.size()!=atuendo.getMap().size()){return false;};
		for(String key : this.map.keySet()){
			if(!(this.map.get(key).equals(atuendo.getMap().get(key)))){
				return false;
			}
		}
		return true;
	}
	
	public boolean tieneCapa(Capa capa) {
		for (HashMap.Entry<String, Prenda> entry : this.map.entrySet()) {
			if(entry.getValue().getCapa() == capa) {
				return true;
			}
		}
		return false;
	}
	
	public int getNivelAbrigo() {
		return this.nivelAbrigo;
	}
	
}
