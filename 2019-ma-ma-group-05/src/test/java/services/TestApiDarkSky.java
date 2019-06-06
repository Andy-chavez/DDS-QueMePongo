package services;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import dtoClases.ClimaDto;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

public class TestApiDarkSky {

	public static void main(String[] args) {
		Properties archivoDeConfiguraciones= new Properties();
    	InputStream input=null;
    	ArrayList stringJson = new ArrayList<String>();
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
            System.out.print(response.code() + "\n");
            ResponseClimaApiDarkSky resp = response.body();
            ClimaDto clima = new ClimaDto();
            clima.setTemperatura(resp.currently.temperature);
            
            System.out.print(clima.getTemperatura());

        }
        catch (Exception ex){
            System.out.print(ex.getMessage());
        }
	}

}
