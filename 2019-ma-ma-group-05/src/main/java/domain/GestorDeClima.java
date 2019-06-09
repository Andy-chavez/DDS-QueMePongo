package domain;

public class GestorDeClima {
	private ApiClima apiClima;
	
	public GestorDeClima(ApiClima api){
		this.apiClima=api;
	}
	public ApiClima getApiClima(){ return this.apiClima;}
	public void setApiClima(ApiClima api){ this.apiClima=api;}
	
	public Double getTemperaturaActual(){
		return this.apiClima.getTemperaturaActual();
	}
}
