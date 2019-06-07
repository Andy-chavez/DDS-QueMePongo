package services;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

import domain.ApiClima;
import domain.GestorDeClima;
import dtoClases.ResponseClimaApiOwmDto;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.RetrofitClimaService;

public class TestApiClima {
	private ApiClima api;
	private GestorDeClima gestor;
	@Before
	public void init(){
		api = new ApiDs();
		gestor=new GestorDeClima(api);
	}
	@Test
	public void seRecibeCorrectamenteLaRespuestaDeDarkSky(){
		Double temp = gestor.getTemperaturaActual();
		System.out.println(temp);
		assertNotNull(temp);
	}
	@Test
	public void seRecibeCorrectamenteLaRespuestaDeOwm(){
		ApiClima api2= new ApiOwm();
		gestor.setApiClima(api2);
		Double temp = gestor.getTemperaturaActual();
		System.out.println(temp);
		assertNotNull(temp);
	}
}
