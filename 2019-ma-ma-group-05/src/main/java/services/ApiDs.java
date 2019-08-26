package services;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import domain.ApiClima;
import dtoClases.ResponseClimaApiDarkSkyDto;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiDs implements ApiClima{
	private String urlBase;
	private String appid;
	private String units;
	private String latitud;
	private String longitud;
	private String camposExcluidosPronostico;
	private String camposExcluidosClimaActual;
	
	public ApiDs(){
		Properties archivoDeConfiguraciones= new Properties();
    	InputStream input=null;
    	try{
            input = new FileInputStream("configuraciones.properties");
            archivoDeConfiguraciones.load(input);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    	this.urlBase= archivoDeConfiguraciones.getProperty("endpointDarkSky");
    	this.appid=archivoDeConfiguraciones.getProperty("appidDarkSky");
    	this.latitud=archivoDeConfiguraciones.getProperty("cabaLat");
    	this.longitud=archivoDeConfiguraciones.getProperty("cabaLong");
    	this.units=archivoDeConfiguraciones.getProperty("unitsDarkSky");
    	this.camposExcluidosClimaActual=archivoDeConfiguraciones.getProperty("camposExcluidosClimaActual");
    	this.camposExcluidosPronostico=archivoDeConfiguraciones.getProperty("camposExcluidosPronostico");
    	
	}
	private RetrofitClimaService iniciarConexion(){
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(this.urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
		return retrofit.create(RetrofitClimaService.class);
	}
	public ResponseClimaApiDarkSkyDto getClima(String camposExcluidos){
		RetrofitClimaService service = this.iniciarConexion();
		Call<ResponseClimaApiDarkSkyDto> call = service.getClimaByDarkSky(appid,latitud,longitud,units,camposExcluidos);
		ResponseClimaApiDarkSkyDto resp=new ResponseClimaApiDarkSkyDto();
		try{
            Response<ResponseClimaApiDarkSkyDto> response = call.execute();
            resp = response.body();
        }
        catch (Exception ex){
            System.out.print(ex.getMessage());
        }
		return resp;
	}
	public Double getPronostico(){
		int indexMañana=1;
		ResponseClimaApiDarkSkyDto resp= this.getClima(this.camposExcluidosPronostico);
		Double promedio = resp.daily.data.get(indexMañana).temperatureHigh;
		if(promedio!=null){
			promedio=(resp.daily.data.get(indexMañana).temperatureHigh
					+ resp.daily.data.get(indexMañana).temperatureLow)/2;
		}
		
		return promedio;
		
	}
	public Double getTemperaturaActual(){
		ResponseClimaApiDarkSkyDto resp= this.getClima(this.camposExcluidosClimaActual);
		Double temp = resp.currently.temperature;
		return temp;
	}
}
