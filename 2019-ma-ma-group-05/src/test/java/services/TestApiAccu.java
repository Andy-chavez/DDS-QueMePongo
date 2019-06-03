package services;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import dtoClases.ClimaDto;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestApiAccu {

	public static void main(String[] args) {
		Properties archivoDeConfiguraciones= new Properties();
    	InputStream input=null;
    	try{
            input = new FileInputStream("configuraciones.properties");
            archivoDeConfiguraciones.load(input);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    	String urlBase= archivoDeConfiguraciones.getProperty("endpointAccu");
    	//String appid=archivoDeConfiguraciones.getProperty("appidAccu");
    	
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitClimaService service = retrofit.create(RetrofitClimaService.class);
        
        Call<List<ResponseClimaApiAccuweather>> call = service.getClimaByAccuweather();
        
        try{
            Response<List<ResponseClimaApiAccuweather>> response = call.execute();
            ClimaDto clima = new ClimaDto();
            //clima.setTemperatura(response.body().get(0).temperature.metric.value);
            
            System.out.print(response.body().get(0).getClass());
        }
        catch (Exception ex){
            System.out.print(ex.getMessage());
        }
	}

}
