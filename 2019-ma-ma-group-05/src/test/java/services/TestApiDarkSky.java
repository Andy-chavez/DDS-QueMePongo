package services;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import dtoClases.ResponseClimaApiDarkSky;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestApiDarkSky {

	public static void main(String[] args) {
		Properties archivoDeConfiguraciones= new Properties();
    	InputStream input=null;
    	try{
            input = new FileInputStream("configuraciones.properties");
            archivoDeConfiguraciones.load(input);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    	String urlBase= archivoDeConfiguraciones.getProperty("endpointDarkSky");
    	String appid=archivoDeConfiguraciones.getProperty("appidDarkSky");
    	String latitud=archivoDeConfiguraciones.getProperty("cabaLat");
    	String longitud=archivoDeConfiguraciones.getProperty("cabaLong");
    	String units=archivoDeConfiguraciones.getProperty("unitsDarkSky");
    	
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitClimaService service = retrofit.create(RetrofitClimaService.class);
        
        Call<ResponseClimaApiDarkSky> call = service.getClimaByDarkSky(appid,latitud,longitud,units);
        
        try{
            Response<ResponseClimaApiDarkSky> response = call.execute();
            ResponseClimaApiDarkSky resp = response.body();
            
            System.out.print(resp.currently.temperature);

        }
        catch (Exception ex){
            System.out.print(ex.getMessage());
        }
	}

}
