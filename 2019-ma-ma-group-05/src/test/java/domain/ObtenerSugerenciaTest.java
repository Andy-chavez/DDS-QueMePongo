package domain;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Tipos.Short;
import dtoClases.EventoDto;
import domain.Categorias.SuperiorExtra;
import domain.EstadosEvento.Pendiente;
import domain.Telas.Algodon;
import domain.Tipos.*;
import services.ApiDs;
//import static org.mockito.Mockito.*
public class ObtenerSugerenciaTest {
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
	GestorSugerencia gestorSugerencia;
	private Tela algodon;
	
	@Before
	public void init() {    
		algodon = new Algodon();
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
		remeraTipo.establecerTela(algodon);
		camisaTipo.establecerTela(algodon);
		sweaterTipo.establecerTela(algodon);
		antiparrasTipo.establecerTela(algodon);
		shortsTipo.establecerTela(algodon);
		musculosaTipo.establecerTela(algodon);
		ojotasTipo.establecerTela(algodon);
		zapatillasTipo.establecerTela(algodon);
		camperaTipo.establecerTela(algodon);

		remera = new Prenda(remeraTipo,Color.black,Color.blue);
		camisa = new Prenda(camisaTipo,Color.black,Color.blue);
		sweater = new Prenda(sweaterTipo,Color.black,Color.blue);
		antiparras = new Prenda(antiparrasTipo,Color.black,Color.blue);
		shorts = new Prenda(shortsTipo,Color.black,Color.blue);
		musculosa = new Prenda(musculosaTipo,Color.black,Color.blue);
		ojotas = new Prenda(ojotasTipo,Color.black,Color.blue);
		zapatillas = new Prenda(zapatillasTipo,Color.black,Color.blue);
		campera = new Prenda(camperaTipo,Color.black,Color.blue);

		
		remera2 = new Prenda(remeraTipo,Color.black,Color.blue);
		camisa2 = new Prenda(camisaTipo,Color.black,Color.blue);
		sweater2 = new Prenda(sweaterTipo,Color.black,Color.blue);
		antiparras2 = new Prenda(antiparrasTipo,Color.black,Color.blue);
		shorts2 = new Prenda(shortsTipo,Color.black,Color.blue);
		musculosa2 = new Prenda(musculosaTipo,Color.black,Color.blue);
		ojotas2 = new Prenda(ojotasTipo,Color.black,Color.blue);
		zapatillas2 = new Prenda(zapatillasTipo,Color.black,Color.blue);
		campera2 = new Prenda(camperaTipo,Color.black,Color.blue);

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
		gestorSugerencia = GestorSugerencia.getInstance();
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
		System.out.println("Nivel abrigo campera: " + campera.getTipo().getNivelAbrigo());
		assertEquals(campera.getNivelAbrigo(), 25);
	}
	
	@Test
	public void obtenerSugerenciaTest(){
		System.out.println("\nobtenerSugerencia()");
		Atuendo atuendoSugerido = new Atuendo(40, usuario.getSensibilidadFrio());
		System.out.println("PREPARANDO ATUENDO");
		atuendoSugerido = gestorSugerencia.obtenerSugerenciaParaTemperatura(20, guardarropa, usuario.getSensibilidadFrio());
		System.out.println("Atuendo sugerido: ");
		atuendoSugerido.printPrendas();
		
		assertNotNull(atuendoSugerido);
	}
	
	@Test
	public void compararAtuendosDaTrue(){
		System.out.println("\ncompararAtuendosDaTrue()");
		Atuendo atuendoSugerido=new Atuendo(30, usuario.getSensibilidadFrio());
		atuendoSugerido.agregarPrenda(remera);
		atuendoSugerido.agregarPrenda(ojotas);
		atuendoSugerido.agregarPrenda(antiparras);
		atuendoSugerido.agregarPrenda(shorts);

		Atuendo otroAtuendo = new Atuendo(30, usuario.getSensibilidadFrio());
		otroAtuendo.agregarPrenda(remera);
		otroAtuendo.agregarPrenda(ojotas);
		otroAtuendo.agregarPrenda(antiparras);
		otroAtuendo.agregarPrenda(shorts);

		assertTrue(atuendoSugerido.compararConOtroAtuendo(otroAtuendo));
	}
	
	@Test
	public void compararAtuendosDaFalse(){
		System.out.println("\ncompararAtuendosDaFalse()");
		Atuendo atuendoSugerido=new Atuendo(30, usuario.getSensibilidadFrio());
		atuendoSugerido.agregarPrenda(remera);
		atuendoSugerido.agregarPrenda(ojotas);
		atuendoSugerido.agregarPrenda(antiparras);
		atuendoSugerido.agregarPrenda(shorts);

		Atuendo otroAtuendo=new Atuendo(30, usuario.getSensibilidadFrio());
		otroAtuendo.agregarPrenda(remera2);
		otroAtuendo.agregarPrenda(ojotas);
		otroAtuendo.agregarPrenda(antiparras);
		otroAtuendo.agregarPrenda(shorts);

		assertFalse(atuendoSugerido.compararConOtroAtuendo(otroAtuendo));
	}
	
	@Test
	public void obtenerCapasParaTemperatura(){
		System.out.println("\nobtenerCapasParaTemperatura()");
		Categoria superiorExtra = new SuperiorExtra();
		Atuendo atuendo = new Atuendo(30, usuario.getSensibilidadFrio());
		superiorExtra.agregarPrendas(atuendo, prendas, 30);
		atuendo.printPrendas();
	}
	

	@Test
	public void crearMoldeTest(){
		System.out.println("\ncrearMoldeTest()");
		Atuendo atuendoSugerido = new Atuendo(16, usuario.getSensibilidadFrio());
		atuendoSugerido.agregarPrenda(remera);
		atuendoSugerido.agregarPrenda(ojotas);
		atuendoSugerido.agregarPrenda(antiparras);
		atuendoSugerido.agregarPrenda(shorts);
		MoldeAtuendo moldeAtuendo = new MoldeAtuendo(atuendoSugerido);
		
		for(Tipo t : moldeAtuendo.getMoldeTipos()){
			System.out.println(t.getNombre());
		}
	}
	
	@Test
	public void nivelAbrigoAtuendo(){
		System.out.println("\nnivelAbrigoAtuendo()");
		double temperatura = 24.0;
		int nivelAbrigoRequerido = 40 - (int)temperatura;
		Atuendo atuendoSugerido = gestorSugerencia.obtenerSugerenciaParaTemperatura(temperatura, guardarropa, usuario.getSensibilidadFrio());
		System.out.println("Nivel abrigo atuendo: " + atuendoSugerido.getNivelAbrigo());

		atuendoSugerido.printPrendas();
		assertEquals(atuendoSugerido.getNivelAbrigo(), nivelAbrigoRequerido);
	}
	
	@Test
	public void buscarMoldeAtuendo(){
		System.out.println("\nBuscarMoldeAtuendo()");

		double temperatura = 24.0;
		int nivelAbrigoRequerido = 40 - (int)temperatura;
		
		gestorSugerencia.obtenerSugerenciaParaTemperatura(temperatura, guardarropa, usuario.getSensibilidadFrio());
		gestorSugerencia.obtenerSugerenciaParaTemperatura(4.0, guardarropa, usuario.getSensibilidadFrio());
		
		MoldeAtuendo moldeAtuendo = gestorSugerencia.buscarMoldeParaNivelAbrigo(guardarropa, nivelAbrigoRequerido);
		for(Tipo t : moldeAtuendo.getMoldeTipos()){
			System.out.println(t);
		}

	}
	
	@Test
	public void crearAtuendoConMolde(){
		System.out.println("\ncrearAtuendoConMolde()");
		Atuendo atuendoSugerido = new Atuendo(16, usuario.getSensibilidadFrio());
		atuendoSugerido.agregarPrenda(remera);
		atuendoSugerido.agregarPrenda(ojotas);
		atuendoSugerido.agregarPrenda(antiparras);
		atuendoSugerido.agregarPrenda(shorts);
		atuendoSugerido.setNivelAbrigo(16);
		
		MoldeAtuendo moldeAtuendo = new MoldeAtuendo(atuendoSugerido);
		for(Tipo t : moldeAtuendo.getMoldeTipos()){
			System.out.println(t);
		}
		System.out.println(moldeAtuendo.getNivelAbrigo());
	}
	
	@Test
	public void cronSugerencia(){
		System.out.println("\ncronSugerencia()");
		EventoDto eventoDto = new EventoDto();
		eventoDto.repeticionDias = 2000;
		eventoDto.anticipacionHoras = 2;
		eventoDto.fecha = "2019-09-02T13:04:00Z";
		eventoDto.estado = new Pendiente();
		eventoDto.guardarropa = guardarropa;
		eventoDto.usuario = usuario;
		Evento evento = new Evento(eventoDto);
		CronGenerarSugerencia cron = CronGenerarSugerencia.getInstance();
		
		cron.planificarEvento(evento);
		}
}
