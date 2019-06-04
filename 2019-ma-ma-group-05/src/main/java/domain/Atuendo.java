package domain;

import java.util.HashMap;
import java.util.Random;

import domain.Prenda;

public class Atuendo {
	private HashMap<String, Prenda> map=new HashMap<String,Prenda>();;
	
	public void agregarPrenda(Prenda prenda){
		if(!this.tieneCapa(prenda.getCapa())) {
			this.map.put(prenda.getTipo().getNombre().toLowerCase(), prenda);			
		}
	}
	
	public HashMap<String,Prenda> getMap(){return this.map;}

	public Boolean compararConOtroAtuendo(Atuendo atuendo){
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
}
