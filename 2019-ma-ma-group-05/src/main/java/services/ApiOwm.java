package services;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import domain.ApiClima;
import dtoClases.ResponseClimaApiOwmDto;
import dtoClases.ResponsePronosticoApiOwmDto;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiOwm implements ApiClima{
	private String urlBase;
	private String appid;
	private String units;
	private String cabaId;
	
	public ApiOwm(){
		Properties archivoDeConfiguraciones= new Properties();
    	InputStream input=null;
    	try{
            input = new FileInputStream("configuraciones.properties");
            archivoDeConfiguraciones.load(input);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    	this.urlBase= archivoDeConfiguraciones.getProperty("endpointOwm");
    	this.appid=archivoDeConfiguraciones.getProperty("appidOwm");
    	this.units=archivoDeConfiguraciones.getProperty("unitsOwm");
    	this.cabaId=archivoDeConfiguraciones.getProperty("cabaId");
    	
	}
	private RetrofitClimaService iniciarConexion(){
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(this.urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(RetrofitClimaService.class);
       
	}
	public Double getTemperaturaActual(){
		Double temp=null;
        RetrofitClimaService service = this.iniciarConexion();
        Call<ResponseClimaApiOwmDto> call = service.getClimaActualByOwm(cabaId,units,appid);
        try{
            Response<ResponseClimaApiOwmDto> response = call.execute();
            ResponseClimaApiOwmDto respuesta = response.body();
            temp=respuesta.main.temp;
        }
        catch (Exception ex){
            System.out.print(ex.getMessage());
        }
        return temp;
	}
	public Double getPronostico(){
		Double temp=null;
		int indexMañana=1;
		RetrofitClimaService service= this.iniciarConexion();
		Call<ResponsePronosticoApiOwmDto> call = service.getPronosticoByOwm(cabaId,units,appid);
		try{
            Response<ResponsePronosticoApiOwmDto> response = call.execute();
            ResponsePronosticoApiOwmDto respuesta = response.body();
            temp=respuesta.list.get(indexMañana).main.temp;
        }
        catch (Exception ex){
            System.out.print(ex.getMessage());
        }
        return temp;
	}
}
