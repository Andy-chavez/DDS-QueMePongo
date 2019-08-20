package domain;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Tipos.Short;
import domain.Tipos.*;
import services.ApiDs;
//import static org.mockito.Mockito.*
;public class ObtenerSugerencia {
	private Guardarropa guardarropa;

	private Tipo antiparrasTipo;
	private Tipo musculosaTipo;
	private Tipo shortsTipo;
	private Tipo ojotasTipo;
	private Tipo remeraTipo;
	private Tipo zapatillasTipo;
	private Tipo camisaTipo;
	private Tipo sweaterTipo;
	private Tipo camperaTipo;

	private Prenda antiparras;
	private Prenda musculosa;
	private Prenda shorts;
	private Prenda ojotas;
	private Prenda zapatillas;
	private Prenda remera;
	private Prenda camisa;
	private Prenda sweater;
	private Prenda campera;
	private Prenda antiparras2;
	private Prenda musculosa2;
	private Prenda shorts2;
	private Prenda ojotas2;
	private Prenda zapatillas2;
	private Prenda remera2;
	private Prenda camisa2;
	private Prenda sweater2;
	private Prenda campera2;
	private Usuario usuario;
	
	private List<Prenda> prendas;
	
	private GestorDeClima gestor;
	@Before
	public void init() {
		antiparrasTipo = new Antiparras();
		musculosaTipo = new Musculosa();
		shortsTipo = new Short();
		ojotasTipo = new Ojotas();
		remeraTipo = new Remera();
		zapatillasTipo = new Zapatillas();
		camisaTipo = new Camisa();
		sweaterTipo = new Sweater();
		camperaTipo = new Campera();
		
		// Prendas para el test de sugerencias
		remeraTipo.establecerTela(Tela.OTRO);
		remera = new Prenda(remeraTipo,Color.black,Color.blue);
		camisaTipo.establecerTela(Tela.OTRO);
		camisa = new Prenda(camisaTipo,Color.black,Color.blue);
		sweaterTipo.establecerTela(Tela.OTRO);
		sweater = new Prenda(sweaterTipo,Color.black,Color.blue);
		antiparrasTipo.establecerTela(Tela.OTRO);
		antiparras = new Prenda(antiparrasTipo,Color.black,Color.blue);
		shortsTipo.establecerTela(Tela.OTRO);
		shorts = new Prenda(shortsTipo,Color.black,Color.blue);
		musculosaTipo.establecerTela(Tela.OTRO);
		musculosa = new Prenda(musculosaTipo,Color.black,Color.blue);
		ojotasTipo.establecerTela(Tela.OTRO);
		ojotas = new Prenda(ojotasTipo,Color.black,Color.blue);
		zapatillasTipo.establecerTela(Tela.OTRO);
		zapatillas = new Prenda(zapatillasTipo,Color.black,Color.blue);
		
		remera = new Prenda(remeraTipo,Color.black,Color.blue);
		camisa = new Prenda(camisaTipo,Color.black,Color.blue);
		sweater = new Prenda(sweaterTipo,Color.black,Color.blue);
		antiparras = new Prenda(antiparrasTipo,Color.black,Color.blue);
		shorts = new Prenda(shortsTipo,Color.black,Color.blue);
		musculosa = new Prenda(musculosaTipo,Color.black,Color.blue);
		ojotas = new Prenda(ojotasTipo,Color.black,Color.blue);
		zapatillas = new Prenda(zapatillasTipo,Color.black,Color.blue);
		
		/*remera = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(remeraTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		camisa = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(camisaTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		sweater = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(sweaterTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		campera = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(camperaTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		antiparras = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(antiparrasTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		shorts = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(shortsTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		musculosa = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(musculosaTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		ojotas = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(ojotasTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		zapatillas = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(zapatillasTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		remera2 = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(remeraTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		camisa2 = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(camisaTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		sweater2 = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(sweaterTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		campera2 = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(camperaTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		antiparras2 = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(antiparrasTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		shorts2 = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(shortsTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		musculosa2 = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(musculosaTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		ojotas2 = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(ojotasTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		
		zapatillas2 = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(zapatillasTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();*/
		prendas = new ArrayList<Prenda>();
		prendas.add(antiparras);
		prendas.add(zapatillas);
		prendas.add(musculosa);
		prendas.add(remera);
		prendas.add(camisa);
		prendas.add(sweater);
		prendas.add(campera);
		prendas.add(shorts);
		prendas.add(ojotas);
		prendas.add(antiparras2);
		prendas.add(zapatillas2);
		prendas.add(musculosa2);
		prendas.add(remera2);
		prendas.add(camisa2);
		prendas.add(sweater2);
		prendas.add(campera2);
		prendas.add(shorts2);
		prendas.add(ojotas2);
		guardarropa = new Guardarropa("guardarropa",prendas);
		usuario= new Usuario("usuario",guardarropa);
		
		gestor = GestorDeClima.getInstance();
		List<ApiClima> apis= new ArrayList<ApiClima>();
		// ApiDs mockApi= mock(ApiDs.class);
		// apis.add(mockApi);
		// gestor.setApisDelClima(apis);
		// when(mockApi.getTemperaturaActual()).thenReturn(new Double(10));
		/*Ésto de los mocks es para testear. Ayuda mucho con los tests unitarios y nos permiten testear(valga la rebundancia)
		 * el comportamiento de una clase, independientemente de si los demás componentes de nuestro sistema están terminados.
		 * El GestorDeClima hace llamados a la API y me devuelve la temperatura real, pero para generar un atuendo en diferentes condiciones,
		 * creo un impostor que entienda los mismos mensajes que una instancia de ApiDs, pero que en lugar de hacer la implementación posta,
		 * devuelva un valor por defecto. De ésta forma yo me estoy abstrayendo del verdadero funcionamiento del getTemperatura,
		 * para probar lo que verdaderamente quiero probar, y si hay fallos, se que son del método obtenerSugerenia y no del Gestor.
		 * Con éstas 4 últmas lineas dde código, dentro del obtenerSugerencia, cuando solicitemos el clima al 
		 * GestorDeClima ( que será algo como: GestorDeClima.getInstance().getTemperatura())
		 * en realidad el mock va a devolver por default una temperatura de 10 gradillos.
		 * Despues podemos hacer varios métodos para ver como se van superponiendo capas disminuyendo la temperatura,
		 * es decir, disminuyendo el número que devuelve el mock. Aclaro que ésto de los mocks es sólo para tests.
		 * Es solo para poder testear e método obtenerSugerencia, independientemente de si funcionan las APIs (que sí lo hacen)
		 * e independientemente del valor que devuelven. Le seteamos un valor nosotros y listo.
		 
		 *
		 */
	}
	@Test
	public void obtenerNivelAbrigoPrenda() {
		System.out.println("\nobtenerNivelAbrigoPrenda()");

		remera = new BuilderPrenda().empezarCreacion()
				 .setTipoAUtilizar(remeraTipo)
				 .setearTelaATipo(Tela.OTRO)
				 .setColorPrimario(Color.black)
				 .setColorSecundarioOpcional(Color.blue)
				 .crearPrenda();
		System.out.println("Nivel abrigo remera: " + remera.getTipo().getNivelAbrigo());
	}
	
	@Test
	public void obtenerSugerencia(){
		System.out.println("\nobtenerSugerencia()");
		Atuendo atuendoSugerido = new Atuendo();
		System.out.println("PREPARANDO ATUENDO");
		atuendoSugerido=usuario.obtenerSugerencia(usuario.getGuardarropas().get(0));
		System.out.println("Atuendo sugerido: ");
		atuendoSugerido.getMap().forEach( (k,v) -> System.out.println(k));
		
		assertNotNull(atuendoSugerido);
	}
	
	@Test
	public void nivelDeAbrigoCorrecto() {
		System.out.println("\nnivelDeAbrigo()");
		Atuendo atuendoSugerido = new Atuendo();
		atuendoSugerido.agregarPrenda(remera); //8
		atuendoSugerido.agregarPrenda(zapatillas); //5
		atuendoSugerido.agregarPrenda(shorts); //5
		System.out.println("Nivel abrigo: " + atuendoSugerido.getNivelAbrigo());
		assertTrue(atuendoSugerido.bienAbrigado(24) == 0);
	}
	
	@Test
	public void nivelDeAbrigoIncorrecto() {
		System.out.println("\nnivelDeAbrigoIncorrecto()");
		Atuendo atuendoSugerido = new Atuendo();
		atuendoSugerido.agregarPrenda(remera); //8
		atuendoSugerido.agregarPrenda(sweater); //12
		atuendoSugerido.agregarPrenda(zapatillas); //5
		atuendoSugerido.agregarPrenda(shorts); //5
		atuendoSugerido.agregarPrenda(campera); //15
		System.out.println("Nivel abrigo: " + atuendoSugerido.getNivelAbrigo());
		assertTrue(atuendoSugerido.bienAbrigado(0) == 0);
	}
	
	@Test
	public void compararAtuendosDaTrue(){
		System.out.println("\ncompararAtuendosDaTrue()");
		Atuendo atuendoSugerido=new Atuendo();
		atuendoSugerido.agregarPrenda(remera);
		atuendoSugerido.agregarPrenda(ojotas);
		atuendoSugerido.agregarPrenda(antiparras);
		atuendoSugerido.agregarPrenda(shorts);
		atuendoSugerido.getMap().forEach( (k,v) -> System.out.println("Key: " + k + " Value: " + v.getTipo().getCategoria()));

		Atuendo otroAtuendo=new Atuendo();
		otroAtuendo.agregarPrenda(remera);
		otroAtuendo.agregarPrenda(ojotas);
		otroAtuendo.agregarPrenda(antiparras);
		otroAtuendo.agregarPrenda(shorts);
		otroAtuendo.getMap().forEach( (k,v) -> System.out.println("Key: " + k + " Value: " + v.getTipo().getCategoria()));

		assertTrue(atuendoSugerido.compararConOtroAtuendo(otroAtuendo));
	}
	
	@Test
	public void compararAtuendosDaFalse(){
		System.out.println("\ncompararAtuendosDaFalse()");
		Atuendo atuendoSugerido=new Atuendo();
		atuendoSugerido.agregarPrenda(remera);
		atuendoSugerido.agregarPrenda(ojotas);
		atuendoSugerido.agregarPrenda(antiparras);
		atuendoSugerido.agregarPrenda(shorts);
		atuendoSugerido.getMap().forEach( (k,v) -> System.out.println("Key: " + k + " Value: " + v.getTipo().getCategoria()));

		Atuendo otroAtuendo=new Atuendo();
		otroAtuendo.agregarPrenda(remera2);
		otroAtuendo.agregarPrenda(ojotas);
		otroAtuendo.agregarPrenda(antiparras);
		otroAtuendo.agregarPrenda(shorts);
		otroAtuendo.getMap().forEach( (k,v) -> System.out.println("Key: " + k + " Value: " + v.getTipo().getCategoria()));

		assertFalse(atuendoSugerido.compararConOtroAtuendo(otroAtuendo));
	}
	
	@Test
	public void prendaMasAbrigada(){
		System.out.println("\nprendaMasAbrigada()");
		Prenda prendaMasAbrigada = guardarropa.obtenerPrendaQueMasSeAcerque(10, prendas);
		System.out.println("Prenda mas abrigada: " + prendaMasAbrigada.getTipo().getNombre());
		assertTrue(prendaMasAbrigada.getTipo().getNombre() == "campera");
	}
	
	@Test
	public void prendaMasAdecuada(){
		System.out.println("\nprendaMasAdecuada()");
		Prenda prendaMasAdecuada = guardarropa.obtenerPrendaParaTemperatura(30, 0, prendas);
		System.out.println("Prenda mas adecuada: " + prendaMasAdecuada.getTipo().getNombre() + ", " + prendaMasAdecuada.getNivelAbrigo());
		assertTrue(prendaMasAdecuada.getTipo().getNombre() == "campera");
	}
}
