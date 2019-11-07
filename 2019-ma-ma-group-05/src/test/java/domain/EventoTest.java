package domain;

import static org.junit.Assert.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dtoClases.EventoDto;
import models.entities.Atuendo;
import models.domain.CronGenerarSugerencia;
import models.entities.Evento;
import models.domain.GestorSugerencia;
import models.entities.Guardarropa;
import models.entities.Prenda;
import models.entities.Usuario;
import models.entities.EstadosEvento.*;

public class EventoTest {
	private Guardarropa guardarropa;
	private Usuario usuario;
	private List<Prenda> prendas;
	GestorSugerencia gestorSugerencia;
	private EventoDto eventoDto;
	private CronGenerarSugerencia cron;
	
	@Before
	public void init(){
		prendas = new ArrayList<Prenda>();
		prendas = TestCargaDePrendas.init();
		guardarropa = new Guardarropa("guardarropa",prendas);
		usuario= new Usuario("usuario",guardarropa);
		gestorSugerencia = GestorSugerencia.getInstance();
		
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
