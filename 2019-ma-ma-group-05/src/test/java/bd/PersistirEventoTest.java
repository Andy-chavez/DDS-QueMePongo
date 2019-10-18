package bd;

import db.EntityManagerHelper;
import dtoClases.EventoDto;
import models.entities.*;
import models.entities.EstadosEvento.Inactivo;
import models.entities.Telas.Algodon;
import models.entities.Telas.Cuero;
import models.entities.Telas.Nylon;
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

		guardarropa = new Guardarropa("deportivo");

		remera = SimpleFactoryPrendas.crearPrenda("remera");
		remera.setTela(Algodon.getInstance());
		remera.setColorPrimario(ColorPersistible.pink);

		pantalon = SimpleFactoryPrendas.crearPrenda("pantalon");
		pantalon.setTela(Cuero.getInstance());
		pantalon.setColorPrimario(ColorPersistible.blue);

		zapatillas = SimpleFactoryPrendas.crearPrenda("zapatillas");
		zapatillas.setTela(Cuero.getInstance());
		zapatillas.setColorPrimario(ColorPersistible.white);

		campera = SimpleFactoryPrendas.crearPrenda("campera");
		campera.setTela(Nylon.getInstance());
		campera.setColorPrimario(ColorPersistible.black);

		reloj = SimpleFactoryPrendas.crearPrenda("reloj");
		reloj.setTela(Cuero.getInstance());
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
