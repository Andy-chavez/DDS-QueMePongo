package bd;

import dtoClases.EventoDto;
import models.entities.*;
import models.entities.EstadosEvento.Inactivo;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;

public class PersistirEventoTest {
	Usuario usuario;
	Guardarropa guardarropa;
	Prenda remera;
	Prenda pantalon;
	Prenda zapatillas;
	Prenda campera;
	Prenda reloj;
	EventoDto eventoDto;
	Evento evento;

	@Before
	public void init(){
		usuario = new Usuario("mati");
		usuario.setCelular("123456789");
		usuario.setMail("X@gmail.com");


		Tela cuero = new Tela("cuero");
		Tela algodon = new Tela("algodon");
		guardarropa = new Guardarropa("deportivo");

		remera = SimpleFactoryPrendas.crearPrenda("remera");
		remera.setTela(algodon);
		remera.setColorPrimario(ColorPersistible.pink);

		pantalon = SimpleFactoryPrendas.crearPrenda("pantalon");
		pantalon.setTela(algodon);
		pantalon.setColorPrimario(ColorPersistible.blue);

		zapatillas = SimpleFactoryPrendas.crearPrenda("zapatillas");
		zapatillas.setTela(cuero);
		zapatillas.setColorPrimario(ColorPersistible.white);

		campera = SimpleFactoryPrendas.crearPrenda("campera");
		campera.setTela(algodon);
		campera.setColorPrimario(ColorPersistible.black);

		reloj = SimpleFactoryPrendas.crearPrenda("reloj");
		reloj.setTela(cuero);
		reloj.setColorPrimario(ColorPersistible.yellow);

		usuario.agregarGuardarropa(guardarropa);
		usuario.agregarPrenda(guardarropa, remera);
		usuario.agregarPrenda(guardarropa, pantalon);
		usuario.agregarPrenda(guardarropa, zapatillas);
		usuario.agregarPrenda(guardarropa, campera);
		usuario.agregarPrenda(guardarropa, reloj);

		eventoDto = new EventoDto();
		eventoDto.usuario = usuario;
		eventoDto.fecha = Instant.now().toString();
		eventoDto.nombre = "fiesta";
		eventoDto.estado = new Inactivo();
		eventoDto.guardarropa = guardarropa;
		eventoDto.repeticionDias = 2;
		eventoDto.repetir = false;
		eventoDto.lugar = "campus";
		eventoDto.tipo = "deportivo";
		usuario.crearEvento(eventoDto);
	}

	@Test
	public void persistirAtuendo(){
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().persist(usuario);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
	}
}
