package models.entities;

import models.entities.Categorias.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="molde")
public class MoldeAtuendo extends EntidadPersistente{

	@Column(name = "abrigo_superior")
	private int abrigoSuperior;
	@Column(name = "abrigo_inferior")
	private int abrigoInferior;

	@Transient
	private List<Tipo> moldeTipos;
	
	public MoldeAtuendo() {
		this.moldeTipos = new ArrayList<Tipo>();
	}
	public MoldeAtuendo(Atuendo atuendo){
		this();
		this.agregarTipos(atuendo);
		this.abrigoSuperior = atuendo.getAbrigoSuperior();
		this.abrigoInferior = atuendo.getAbrigoInferior();
	}

	public void agregarTipos(Atuendo atuendo){
		atuendo.getPrendas().forEach( prenda -> this.moldeTipos.add(prenda.getTipo()));
	}


	// --- GETTERS Y SETTERS ---
	public List<Tipo> getMoldeTipos(){ 	return this.moldeTipos;	}
	public SensibilidadFrio getSensibilidadFrio(Usuario u){ return u.getSensibilidadFrio(); }

	public int getAbrigoSuperior(){
		return abrigoSuperior;
	}
	public int getAbrigoInferior() {
		return abrigoInferior;
	}
}
