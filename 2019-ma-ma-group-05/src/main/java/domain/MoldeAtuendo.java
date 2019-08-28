package domain;

import java.util.ArrayList;
import java.util.List;

public class MoldeAtuendo {
	List<Tipo> moldeTipos;
	int nivelAbrigo;
	
	public MoldeAtuendo(Atuendo atuendo){
		this.moldeTipos = new ArrayList<Tipo>();
		this.agregarTipos(atuendo);
		this.nivelAbrigo = atuendo.getNivelAbrigo();
	}
	
	public List<Tipo> getMoldeTipos(){
		return this.moldeTipos;
	}
	
	public void agregarTipos(Atuendo atuendo){
		atuendo.getPrendas().forEach( (k,v) -> this.moldeTipos.add(v.getTipo()));

	}
	public int getNivelAbrigo(){
		return this.nivelAbrigo;
	}
}
