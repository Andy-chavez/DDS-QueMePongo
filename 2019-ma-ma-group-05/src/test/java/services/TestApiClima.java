package services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.ApiClima;
import domain.GestorDeClima;
import static org.mockito.Mockito.*;
public class TestApiClima {
	private GestorDeClima gestor;
	private ApiDs apiDs;
	private ApiOwm apiOwm;
	@Before
	public void init(){
		gestor=GestorDeClima.getInstance();
		apiDs=new ApiDs();
		apiOwm=new ApiOwm();
	}
	@Test
	public void seRecibeCorrectamenteElClimaActualDeDarkSky(){
		gestor.setApiClima(apiDs);
		Double temp = gestor.getTemperaturaActual();
		System.out.println(temp);
		assertNotNull(temp);
	}
	@Test
	public void seRecibeCorrectamenteElClimaActualDeOwm(){
		gestor.setApiClima(apiOwm);
		Double temp = gestor.getTemperaturaActual();
		System.out.println(temp);
		assertNotNull(temp);
	}
	@Test
	public void seRecibeCorrectamenteElPronosticoDeOwm(){
		gestor.setApiClima(apiOwm);
		Double temp = gestor.getPronostico();
		System.out.println(temp);
		assertNotNull(temp);
	}
	@Test
	public void seRecibeCorrectamenteElPronosticoDeDs(){
		gestor.setApiClima(apiDs);
		Double temp = gestor.getPronostico();
		System.out.println(temp);
		assertNotNull(temp);
	}
	@Test
	public void mocks(){
		ApiDs mockApi=mock(ApiDs.class);
		gestor.setApiClima(mockApi);
		when(mockApi.getTemperaturaActual()).thenReturn(10.0);
		assertEquals(gestor.getTemperaturaActual(),new Double(10));
		verify(mockApi,times(1)).getTemperaturaActual();
	}
}
