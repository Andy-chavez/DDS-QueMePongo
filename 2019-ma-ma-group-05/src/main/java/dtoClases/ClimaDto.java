package dtoClases;

import java.util.ArrayList;
import java.util.List;

public class ClimaDto {
	public CoordenadasDto coord;
	public List<WeatherDto> weather = new ArrayList<WeatherDto>();
	public String base;
	public MainDto main;
	public int visibility;
	public WindDto wind;
	public CloudsDto clouds;
	public Double dt;
	public SysDto sys;
	public Double id;
	public String name;
	public int cod;
	
	public String allMainClimaData(){
        return "La info del clima es: " + main.toString();
    }

}
