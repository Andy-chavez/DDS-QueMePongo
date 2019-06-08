package domain;

import java.util.HashMap;

import domain.Prenda;

public class Atuendo {
	private HashMap<String, Prenda> map=new HashMap<String,Prenda>();;
	
	public void agregarPrenda(Prenda prenda){
		this.map.put(prenda.getTipo().getNombre().toLowerCase(), prenda);
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
}
