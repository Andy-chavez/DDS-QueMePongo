package services;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import dtoClases.ClimaDto;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.RetrofitClimaService;

public class TestApiOWM {

	public static void main(String[] args) {
    	Properties archivoDeConfiguraciones= new Properties();
    	InputStream input=null;
    	try{
            input = new FileInputStream("configuraciones.properties");
            archivoDeConfiguraciones.load(input);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    	String urlBase= archivoDeConfiguraciones.getProperty("endpointOwm");
    	String appid=archivoDeConfiguraciones.getProperty("appidOwm");
    	String units=archivoDeConfiguraciones.getProperty("unitsOwm");
    	String cabaId=archivoDeConfiguraciones.getProperty("cabaId");
    	
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitClimaService service = retrofit.create(RetrofitClimaService.class);
        
        Call<ResponseClimaApiOWM> call = service.getClimaByOwm(cabaId,units,appid);
        
        try{
            Response<ResponseClimaApiOWM> response = call.execute();
            ResponseClimaApiOWM respuesta = response.body();
            ClimaDto clima = new ClimaDto();
            clima.setTemperatura(respuesta.main.temp);
            
            System.out.print(clima.getTemperatura());
        }
        catch (Exception ex){
            System.out.print(ex.getMessage());
        }

	}

}
