package services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.ApiClima;
import domain.GestorDeClima;
import static org.mockito.Mockito.*;
public class TestApiClima {
	private GestorDeClima gestor;
	@Before
	public void init(){
		gestor=GestorDeClima.getInstance();
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
	@Test
	public void mocks(){
		ApiDs mockApi=mock(ApiDs.class);
		gestor.setApiClima(mockApi);
		when(mockApi.getTemperaturaActual()).thenReturn(10.0);
		assertEquals(gestor.getTemperaturaActual(),new Double(10));
		verify(mockApi,times(1)).getTemperaturaActual();
	}
}
