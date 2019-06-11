package domain;

import services.ApiDs;

public class GestorDeClima {
	private ApiClima apiClima;
	private static GestorDeClima instancia;
	
	public static GestorDeClima getInstance(){
		if(instancia==null){
			instancia = new GestorDeClima(new ApiDs());
			//por defecto. Me faltaría hacer que cuando una falle, se cambie sola
		}
		return instancia;
	}
	private GestorDeClima(ApiClima api){
		this.apiClima=api;
	}
	public ApiClima getApiClima(){ return this.apiClima;}
	public void setApiClima(ApiClima api){ this.apiClima=api;}
	
	public Double getTemperaturaActual(){
		return this.apiClima.getTemperaturaActual();
	}
}
