package domain;
import static org.junit.Assert.*;

import java.awt.Color;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dtoClases.EventoDto;
import entities.ApiClima;
import entities.Atuendo;
import entities.Categoria;
import entities.ColorPersistible;
import entities.CronGenerarSugerencia;
import entities.Evento;
import entities.GestorDeClima;
import entities.GestorSugerencia;
import entities.Guardarropa;
import entities.MoldeAtuendo;
import entities.Prenda;
import entities.SimpleFactoryPrendas;
import entities.Tela;
import entities.Tipo;
import entities.Usuario;
import entities.Categorias.SuperiorExtra;
import entities.EstadosEvento.Pendiente;
import entities.Telas.Algodon;
import entities.Telas.Cuero;

public class ObtenerSugerenciaTest {
	private Guardarropa guardarropa;

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
	private Cuero cuero;
	private List<Prenda> prendas;
	

	GestorSugerencia gestorSugerencia;
	private Tela algodon;
	
	@Before
	public void init() {    
		algodon = Algodon.getInstance();
		cuero = Cuero.getInstance();
		
		camisa = SimpleFactoryPrendas.crearPrenda("camisa");
		camisa.setColorPrimario(ColorPersistible.BLACK);
		camisa.setTela(algodon);
		sweater = SimpleFactoryPrendas.crearPrenda("sweater");
		sweater.setColorPrimario(ColorPersistible.BLACK);
		sweater.setTela(algodon);
		campera = SimpleFactoryPrendas.crearPrenda("campera");
		campera.setColorPrimario(ColorPersistible.BLACK);
		campera.setTela(algodon);
		
		camisa2 = SimpleFactoryPrendas.crearPrenda("camisa");
		camisa2.setColorPrimario(ColorPersistible.BLACK);
		camisa2.setTela(algodon);
		sweater2 = SimpleFactoryPrendas.crearPrenda("sweater");
		sweater2.setColorPrimario(ColorPersistible.BLACK);
		sweater2.setTela(algodon);
		campera2 = SimpleFactoryPrendas.crearPrenda("campera");
		campera2.setColorPrimario(ColorPersistible.BLACK);
		campera2.setTela(algodon);
		
		remera = SimpleFactoryPrendas.crearPrenda("remera");
		remera.setColorPrimario(ColorPersistible.BLACK);
		remera.setTela(algodon);
		
		antiparras = SimpleFactoryPrendas.crearPrenda("antiparras");
		antiparras.setColorPrimario(ColorPersistible.BLACK);
		antiparras.setTela(algodon);
		
		shorts = SimpleFactoryPrendas.crearPrenda("short");
		shorts.setColorPrimario(ColorPersistible.BLACK);
		shorts.setTela(algodon);
		
		musculosa = SimpleFactoryPrendas.crearPrenda("musculosa");
		musculosa.setColorPrimario(ColorPersistible.BLACK);
		musculosa.setTela(algodon);
		
		ojotas = SimpleFactoryPrendas.crearPrenda("ojotas");
		ojotas.setColorPrimario(ColorPersistible.BLACK);
		ojotas.setTela(cuero);
		
		zapatillas = SimpleFactoryPrendas.crearPrenda("zapatillas");
		zapatillas.setColorPrimario(ColorPersistible.BLACK);
		zapatillas.setTela(algodon);
		
		remera2 = SimpleFactoryPrendas.crearPrenda("remera");
		remera2.setColorPrimario(ColorPersistible.BLACK);
		remera2.setTela(algodon);
		
		antiparras2 = SimpleFactoryPrendas.crearPrenda("antiparras");
		antiparras2.setColorPrimario(ColorPersistible.BLACK);
		antiparras2.setTela(algodon);
		
		shorts2 = SimpleFactoryPrendas.crearPrenda("short");
		shorts2.setColorPrimario(ColorPersistible.BLACK);
		shorts2.setTela(algodon);
		
		musculosa2 = SimpleFactoryPrendas.crearPrenda("musculosa");
		musculosa2.setColorPrimario(ColorPersistible.BLACK);
		musculosa2.setTela(algodon);
		
		ojotas2 = SimpleFactoryPrendas.crearPrenda("ojotas");
		ojotas2.setColorPrimario(ColorPersistible.BLACK);
		ojotas2.setTela(cuero);
		
		zapatillas2 = SimpleFactoryPrendas.crearPrenda("zapatillas");
		zapatillas2.setColorPrimario(ColorPersistible.BLACK);
		zapatillas2.setTela(algodon);
		prendas = new ArrayList<Prenda>();
		prendas = TestCargaDePrendas.init();
		prendas.add(camisa);
		prendas.add(sweater);
		prendas.add(campera);
		prendas.add(camisa2);
		prendas.add(sweater2);
		prendas.add(campera2);
		guardarropa = new Guardarropa("guardarropa",prendas);
		usuario= new Usuario("usuario",guardarropa);
		gestorSugerencia = GestorSugerencia.getInstance();
		List<ApiClima> apis= new ArrayList<ApiClima>();
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
		Atuendo atuendoSugerido = new Atuendo(40, usuario);//, usuario.getSensibilidadFrio());
		System.out.println("PREPARANDO ATUENDO");
		atuendoSugerido = gestorSugerencia.obtenerSugerencia(Instant.now(), guardarropa, usuario);//.getSensibilidadFrio());
		System.out.println("Atuendo sugerido: ");
		atuendoSugerido.printPrendas();
		
		assertNotNull(atuendoSugerido);
	}
	
	@Test
	public void compararAtuendosDaTrue(){
		System.out.println("\ncompararAtuendosDaTrue()");
		Atuendo atuendoSugerido=new Atuendo(30, usuario);//, usuario.getSensibilidadFrio());
		atuendoSugerido.agregarPrenda(remera);
		atuendoSugerido.agregarPrenda(ojotas);
		atuendoSugerido.agregarPrenda(antiparras);
		atuendoSugerido.agregarPrenda(shorts);

		Atuendo otroAtuendo = new Atuendo(30, usuario);//, usuario.getSensibilidadFrio());
		otroAtuendo.agregarPrenda(remera);
		otroAtuendo.agregarPrenda(ojotas);
		otroAtuendo.agregarPrenda(antiparras);
		otroAtuendo.agregarPrenda(shorts);

		assertTrue(atuendoSugerido.compararConOtroAtuendo(otroAtuendo));
	}
	
	@Test
	public void compararAtuendosDaFalse(){
		System.out.println("\ncompararAtuendosDaFalse()");
		Atuendo atuendoSugerido=new Atuendo(30, usuario);//, usuario.getSensibilidadFrio());
		atuendoSugerido.agregarPrenda(remera);
		atuendoSugerido.agregarPrenda(ojotas);
		atuendoSugerido.agregarPrenda(antiparras);
		atuendoSugerido.agregarPrenda(shorts);

		Atuendo otroAtuendo=new Atuendo(30, usuario);//, usuario.getSensibilidadFrio());
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
		Atuendo atuendo = new Atuendo(30, usuario);//, usuario.getSensibilidadFrio());
		superiorExtra.agregarPrendas(atuendo, prendas, 30);
		atuendo.printPrendas();
	}
	

	@Test
	public void crearMoldeTest(){
		System.out.println("\ncrearMoldeTest()");
		Atuendo atuendoSugerido = new Atuendo(16, usuario);//, usuario.getSensibilidadFrio());
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
		//double temperatura = 24.0;
		double nivelAbrigoRequerido = (40 - GestorDeClima.getInstance().getTemperaturaActual());
		Atuendo atuendoSugerido = gestorSugerencia.obtenerSugerencia(Instant.now(), guardarropa, usuario);
		System.out.println("Nivel abrigo atuendo: " + atuendoSugerido.getNivelAbrigo());

		atuendoSugerido.printPrendas();
		assertEquals(atuendoSugerido.getNivelAbrigo(), nivelAbrigoRequerido,1);
	}
	
	@Test
	public void buscarMoldeAtuendo(){ //TODO printea bien pero no se porque da null pointer
		System.out.println("\nBuscarMoldeAtuendo()");

		double temperatura = 24.0;
		int nivelAbrigoRequerido = 40 - (int)temperatura;
		
		gestorSugerencia.obtenerSugerencia(Instant.now(), guardarropa, usuario);
		gestorSugerencia.obtenerSugerencia(Instant.now(), guardarropa, usuario);
		
		MoldeAtuendo moldeAtuendo = gestorSugerencia.buscarMoldeParaNivelAbrigo(guardarropa, nivelAbrigoRequerido);
		for(Tipo t : moldeAtuendo.getMoldeTipos()){
			System.out.println(t);
		}

	}
	
	@Test
	public void crearAtuendoConMolde(){
		System.out.println("\ncrearAtuendoConMolde()");
		Atuendo atuendoSugerido = new Atuendo(16, usuario);//, usuario.getSensibilidadFrio());
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
	public void cronSugerencia(){ //todo kind of faltan cosas aca
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
		
		}
}
