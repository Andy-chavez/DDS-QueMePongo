package domain;

import java.util.HashMap;
import java.util.Random;
import java.util.List;

import domain.Prenda;

public class Atuendo {

	private HashMap<String, Prenda> map=new HashMap<String,Prenda>();;
	private Boolean rechazado;
	
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
		int nivelAbrigo = 0;
		for(Prenda prenda : this.map.values()) {
			System.out.print(prenda.getNivelAbrigo() + " ");
			nivelAbrigo += prenda.getNivelAbrigo();
		}
		return nivelAbrigo;
	}

	public int bienAbrigado(double temp) { // devuelve -1, 0, 1 dependiendo si esta por encima, si esta bien, o por debajo del nivel requerido
		int variableTemperaturaSarasa = 50;
		int margenAdmitido = 10;
		int nivelAbrigoRequerido = variableTemperaturaSarasa - (int) temp;
		int nivelAbrigoCubierto = nivelAbrigoRequerido - this.getNivelAbrigo();
		return (nivelAbrigoCubierto >= -margenAdmitido) && (nivelAbrigoCubierto <= margenAdmitido) ? 0 : nivelAbrigoCubierto < -margenAdmitido ? 1 : -1;
	}
}
