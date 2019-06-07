package services;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import dtoClases.ResponseClimaApiOwmDto;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.RetrofitClimaService;

public class TestApiOwm {

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
        
        Call<ResponseClimaApiOwmDto> call = service.getClimaByOwm(cabaId,units,appid);
        
        try{
            Response<ResponseClimaApiOwmDto> response = call.execute();
            ResponseClimaApiOwmDto respuesta = response.body();
            
            System.out.print(respuesta.main.temp);
        }
        catch (Exception ex){
            System.out.print(ex.getMessage());
        }

	}

}
