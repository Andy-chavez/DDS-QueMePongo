package domain;

import java.time.Instant;
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

	public Atuendo(int nivelAbrigo, SensibilidadFrio sensibilidadFrio){
		this.nivelAbrigo = nivelAbrigo;
		this.sensibilidadFrio = sensibilidadFrio;
	}
	// --- GETTERS Y SETTERS ---
	public void setNivelAbrigo(int nivelAbrigo){	this.nivelAbrigo = nivelAbrigo;		}
	public void setSensibilidadFrio(SensibilidadFrio sensibilidadFrio){	this.sensibilidadFrio = sensibilidadFrio;	}
	public SensibilidadFrio getSensibilidadFrio(){	return this.sensibilidadFrio;	}
	public void setRechazado(Boolean flag){	this.rechazado=flag;}
	public Boolean getRechazado(){	return this.rechazado;	}
	public int getNivelAbrigo() {	return this.nivelAbrigo;	}
	public List<Prenda> getPrendas(){	return this.prendas;	}
	
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
}
