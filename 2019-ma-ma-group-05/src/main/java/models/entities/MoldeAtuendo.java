package models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="molde")
public class MoldeAtuendo extends EntidadPersistente{

	@Column(name = "nivel_abrigo")
	private int nivelAbrigo;

	@ManyToMany //TODO asi?
	@JoinColumn(name = "molde_tipos", referencedColumnName = "id")
	private List<Tipo> moldeTipos;
	
	public MoldeAtuendo(Atuendo atuendo){
		this.moldeTipos = new ArrayList<Tipo>();
		this.agregarTipos(atuendo);
		this.nivelAbrigo = atuendo.getNivelAbrigo();
	}
	// --- GETTERS Y SETTERS ---
	public List<Tipo> getMoldeTipos(){ 	return this.moldeTipos;	}
	public int getNivelAbrigo(){	return this.nivelAbrigo;	}
	public SensibilidadFrio getSensibilidadFrio(Usuario u){ return u.getSensibilidadFrio(); }
	
	public void agregarTipos(Atuendo atuendo){
		atuendo.getPrendas().forEach( prenda -> this.moldeTipos.add(prenda.getTipo()));

	}
}
