package domain;

import static org.junit.Assert.*;

import java.awt.Color;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.EstadosEvento.*;
import domain.Telas.Algodon;
import domain.Tipos.Antiparras;
import domain.Tipos.Camisa;
import domain.Tipos.Campera;
import domain.Tipos.Musculosa;
import domain.Tipos.Ojotas;
import domain.Tipos.Remera;
import domain.Tipos.Short;
import domain.Tipos.Sweater;
import domain.Tipos.Zapatillas;
import dtoClases.EventoDto;

public class EventoTest {
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
	private EventoDto eventoDto;
	private CronGenerarSugerencia cron;
	
	@Before
	public void init(){
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
		
		eventoDto = new EventoDto();
		eventoDto.repetir = false;
		eventoDto.nombre = "party";
		eventoDto.repeticionDias = 2000;
		eventoDto.anticipacionHoras = 2;
		eventoDto.fecha = "2019-09-04T00:04:00Z";
		eventoDto.estado = new Pendiente();
		eventoDto.usuario = usuario;
		eventoDto.guardarropa = guardarropa;
		
		cron = CronGenerarSugerencia.getInstance();
	}
	@Test
	public void crearEventoTest() {
		Evento evento = new Evento(eventoDto);
		assertNotNull(evento);
	}
	@Test
	public void eventoSeAgregaAlCron() {
		Evento evento = new Evento(eventoDto);
		assertFalse(cron.getEventos().contains(evento));
		evento.confirmarEvento();
		assertTrue(cron.getEventos().contains(evento));
	}
	@Test
	public void eventoSeSacaDelCron() {
		Evento evento = new Evento(eventoDto);
		evento.confirmarEvento();
		assertTrue(cron.getEventos().contains(evento));
		evento.cancelarEvento();
		assertFalse(cron.getEventos().contains(evento));
	}
	@Test
	public void eventoActivoGeneraAtuendo() {
		Evento evento = new Evento(eventoDto);
		assertNull(evento.getAtuendo());
		evento.confirmarEvento();
		cron.run();
		assertNotNull(evento.getAtuendo());
	}
	@Test
	public void cambiaDeEstado() {
		Evento evento = new Evento(eventoDto);
		evento.confirmarEvento();
		assertTrue(evento.getEstado().getClass() == new Pendiente().getClass());
		cron.run();
		assertTrue(evento.getEstado().getClass() == new AtuendoListo().getClass());
	}
	@Test
	public void cambiaDeEstadoConRepetir() {
		eventoDto.repetir = true;
		Evento evento = new Evento(eventoDto);
		evento.confirmarEvento();
		assertTrue(evento.getEstado().getClass() == new Pendiente().getClass());
		cron.run();
		assertTrue(evento.getEstado().getClass() == new AtuendoListo().getClass());
		cron.run();
		assertTrue(evento.getEstado().getClass() == new Pendiente().getClass());
	}
	@Test
	public void cambiaDeEstadoSinRepetir() {
		Evento evento = new Evento(eventoDto);
		evento.confirmarEvento();
		assertTrue(evento.getEstado().getClass() == new Pendiente().getClass());
		cron.run();
		assertTrue(evento.getEstado().getClass() == new AtuendoListo().getClass());
		cron.run();
		assertTrue(evento.getEstado().getClass() == new Inactivo().getClass());
	}
	@Test
	public void reservaLasPrendas() {
		Evento evento = new Evento(eventoDto);
		evento.confirmarEvento();
		cron.run();
		List<Prenda> prendasAtuendoEvento = evento.getAtuendo().getPrendas();
		Prenda prenda = prendasAtuendoEvento.get(0);
		assertTrue(prenda.estaReservada(evento.getFecha()));
		assertFalse(prenda.estaReservada(evento.getFecha().plus(Duration.ofDays(1))));
	}
	@Test
	public void seGeneranDosAtuendosDistintos(){
		eventoDto.repetir = true;
		Evento evento = new Evento(eventoDto);
		evento.confirmarEvento();
		cron.run();
		Atuendo atuendo1 = evento.getAtuendo();
		cron.run();
		cron.run(); // hay que correrlo tres veces porque con una queda en AtuendoListo. Con otra pasa de nuevo a pendiente y con otra pasa a AtuendoListo de nuevo
		Atuendo atuendo2 = evento.getAtuendo();
		assertNotEquals(atuendo1, atuendo2);
		
	}
}
