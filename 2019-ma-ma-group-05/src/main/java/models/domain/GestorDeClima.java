package models.domain;

import java.util.ArrayList;
import java.util.List;

import models.domain.Excepciones.FallaronTodasLasApisException;
import models.domain.services.ApiDs;
import models.domain.services.ApiOwm;

public class GestorDeClima {
	private List<ApiClima> apisDelClima;
	private static GestorDeClima instancia;
	
	public static GestorDeClima getInstance(){
		if(instancia==null){
			instancia = new GestorDeClima();
		}
		return instancia;
	}
	private GestorDeClima(){
		this.apisDelClima= new ArrayList<ApiClima>();
		this.apisDelClima.add(new ApiDs());
		this.apisDelClima.add(new ApiOwm());
	}
	public void setApisDelClima(List<ApiClima> apis){
		this.apisDelClima=apis;
	}
	public void agregarApiDelClima(ApiClima api){
		this.apisDelClima.add(api);
	}
	public Double getTemperaturaActual(){
		Double temp=null;
		for(int i=0;i<this.apisDelClima.size();i++){
			temp=this.apisDelClima.get(i).getTemperaturaActual();
			if(temp!=null){return temp;}
		}
		throw new FallaronTodasLasApisException();
	}
	public Double getPronostico(){
		Double temp=null;
		for(int i=0;i<this.apisDelClima.size();i++){
			temp=this.apisDelClima.get(i).getPronostico();
			if(temp!=null){return temp;}
		}
		throw new FallaronTodasLasApisException();
	}
}
