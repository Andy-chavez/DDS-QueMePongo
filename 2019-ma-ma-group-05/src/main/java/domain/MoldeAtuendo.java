package domain;

import java.util.ArrayList;
import java.util.List;

public class MoldeAtuendo {
	private List<Tipo> moldeTipos;
	private int nivelAbrigo;
	private SensibilidadFrio sensibilidadFrio;
	
	public MoldeAtuendo(Atuendo atuendo){
		this.moldeTipos = new ArrayList<Tipo>();
		this.agregarTipos(atuendo);
		this.nivelAbrigo = atuendo.getNivelAbrigo();
		this.sensibilidadFrio = atuendo.getSensibilidadFrio();
	}
	// --- GETTERS Y SETTERS ---
	public List<Tipo> getMoldeTipos(){ 	return this.moldeTipos;	}
	public int getNivelAbrigo(){	return this.nivelAbrigo;	}
	public SensibilidadFrio getSensibilidadFrio(){ return this.sensibilidadFrio; }
	
	public void agregarTipos(Atuendo atuendo){
		atuendo.getPrendas().forEach( prenda -> this.moldeTipos.add(prenda.getTipo()));

	}
}
