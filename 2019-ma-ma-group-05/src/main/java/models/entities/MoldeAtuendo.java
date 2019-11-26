package models.entities;

import models.domain.ConfigReader;

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
	@Column(name = "abrigo_calzado")
	private int abrigoCalzado;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Tipo> moldeTipos;
	
	public MoldeAtuendo() {
		this.moldeTipos = new ArrayList<Tipo>();
	}
	public MoldeAtuendo(Atuendo atuendo){
		this();
		this.agregarTipos(atuendo);
		this.abrigoSuperior = atuendo.getAbrigoSuperior();
		this.abrigoInferior = atuendo.getAbrigoInferior();
		this.abrigoCalzado = atuendo.getAbrigoCalzado();
	}

	public void agregarTipos(Atuendo atuendo){
		atuendo.getPrendas().forEach( prenda -> this.moldeTipos.add(prenda.getTipo()));
	}

	public Boolean moldeAbrigaLoSuficiente(SensibilidadFrio sf, int nivelAbrigoRequerido){
		int margenAdmitido = ConfigReader.getIntValue("configuraciones.properties","margenAdmitido");//5;
		return Math.abs(getAbrigoSuperior() - nivelAbrigoRequerido - sf.getSuperior()) <= margenAdmitido &&
				Math.abs(getAbrigoInferior() - nivelAbrigoRequerido - sf.getInferior()) <= margenAdmitido &&
				Math.abs(getAbrigoCalzado() - nivelAbrigoRequerido) <= margenAdmitido;
	}
	// --- GETTERS Y SETTERS ---
	public List<Tipo> getMoldeTipos(){ 	return this.moldeTipos;	}

	public void setMoldeTipos(List<Tipo> listaDeMoldes){
		this.moldeTipos.clear();
		this.moldeTipos.addAll(listaDeMoldes);
	}
	public SensibilidadFrio getSensibilidadFrio(Usuario u){ return u.getSensibilidadFrio(); }

	public int getAbrigoSuperior(){
		return abrigoSuperior;
	}
	public int getAbrigoInferior() {
		return abrigoInferior;
	}
	public int getAbrigoCalzado() {
		return abrigoCalzado;
	}
}
