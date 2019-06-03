package services;

public class ResponseClimaApiAccuweather {
	public ClimaAccuweather temperature;
	
	public void setTemperature(ClimaAccuweather clima){
		this.temperature=clima;
	}
	public ClimaAccuweather getTemperature(){
		return this.temperature;
	}
}
