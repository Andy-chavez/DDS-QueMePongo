package entities;

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
	@ManyToMany //TODO asi?
	@JoinColumn(name = "COMPLETAR", referencedColumnName = "id")
	private List<Tipo> moldeTipos;
	@Column(name = "puntos")
	private int nivelAbrigo;
	@OneToOne //TODO asi?
	@JoinColumn(name = "COMPLETAR", referencedColumnName = "id")
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
