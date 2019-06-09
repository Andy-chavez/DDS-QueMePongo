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
    	
	}
	public Double getTemperaturaActual(){
		Double temp=0.0;/*lo inicialicé en 0 para que no rompa las bolas el Ide.
		La idea es que se intenta hacer la llamada, si hay un error, lanzo la excepción y si no, 
		devuelvo la temperatura*/
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(this.urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitClimaService service = retrofit.create(RetrofitClimaService.class);
        
        Call<ResponseClimaApiDarkSkyDto> call = service.getClimaByDarkSky(appid,latitud,longitud,units);
        
        try{
            Response<ResponseClimaApiDarkSkyDto> response = call.execute();
            ResponseClimaApiDarkSkyDto resp = response.body();
            temp = resp.currently.temperature;
        }
        catch (Exception ex){
            System.out.print(ex.getMessage());
        }
        return temp;
	}
}
