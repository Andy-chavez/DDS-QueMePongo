package services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.ApiClima;
import domain.GestorDeClima;
import domain.Excepciones.FallaronTodasLasApisException;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
public class TestApiClima {
	private GestorDeClima gestor;
	private ApiDs apiDs;
	private ApiOwm apiOwm;
	private List<ApiClima> apis;
	@Before
	public void init(){
		gestor=GestorDeClima.getInstance();
		apiDs= new ApiDs();
		apiOwm = new ApiOwm();
		apis= new ArrayList<ApiClima>();
	}
	@Test
	public void seRecibeCorrectamenteElClimaActualDeDarkSky(){
		apis.add(apiDs);
		gestor.setApisDelClima(apis);
		Double temp = gestor.getTemperaturaActual();
		System.out.println(temp);
		assertNotNull(temp);
	}
	@Test
	public void seRecibeCorrectamenteElClimaActualDeOwm(){
		apis.add(apiOwm);
		gestor.setApisDelClima(apis);
		Double temp = gestor.getTemperaturaActual();
		System.out.println(temp);
		assertNotNull(temp);
	}
	@Test
	public void seRecibeCorrectamenteElPronosticoDeOwm(){
		apis.add(apiOwm);
		gestor.setApisDelClima(apis);
		Double temp = gestor.getPronostico();
		System.out.println(temp);
		assertNotNull(temp);
	}
	@Test
	public void seRecibeCorrectamenteElPronosticoDeDs(){
		apis.add(apiDs);
		gestor.setApisDelClima(apis);
		Double temp = gestor.getPronostico();
		System.out.println(temp);
		assertNotNull(temp);
	}
	@Test
	public void mocks(){
		ApiDs mockApi=mock(ApiDs.class);
		apis.add(mockApi);
		gestor.setApisDelClima(apis);
		when(mockApi.getTemperaturaActual()).thenReturn(10.0);
		assertEquals(gestor.getTemperaturaActual(),new Double(10));
		verify(mockApi,times(1)).getTemperaturaActual();
	}
	@Test
	public void laPrimerApiFallaPeroLaSegundaNo(){
		ApiDs mockApiDs=mock(ApiDs.class);
		apis.add(mockApiDs);
		ApiOwm mockApiOwm = mock(ApiOwm.class);
		apis.add(mockApiOwm);
		when(mockApiDs.getTemperaturaActual()).thenReturn(null);
		when(mockApiOwm.getTemperaturaActual()).thenReturn(20.0);
		gestor.setApisDelClima(apis);
		
		assertEquals(gestor.getTemperaturaActual(),new Double(20));
	}
	@Test(expected=FallaronTodasLasApisException.class)
	public void seLanzaExceptionSiTodasLasApisFallan(){
		ApiDs mockApiDs=mock(ApiDs.class);
		apis.add(mockApiDs);
		ApiOwm mockApiOwm = mock(ApiOwm.class);
		apis.add(mockApiOwm);
		when(mockApiDs.getTemperaturaActual()).thenReturn(null);
		when(mockApiOwm.getTemperaturaActual()).thenReturn(null);
		gestor.setApisDelClima(apis);
		gestor.getTemperaturaActual();
	}
}
