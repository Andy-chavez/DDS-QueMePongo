package db;

import dtoClases.EventoDto;
import models.domain.SimpleFactoryPrendas;
import models.entities.*;
import models.entities.EstadosEvento.Inactivo;
import models.repositorios.RepositorioPrenda;
import models.repositorios.RepositorioUsuario;
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

		remera = SimpleFactoryPrendas.crearPrenda("Remera");
		RepositorioPrenda.getInstance().setTela(remera,"Algodon");
		RepositorioPrenda.getInstance().setColorPrimario(remera, ColorPersistible.pink.getHex());

		pantalon = SimpleFactoryPrendas.crearPrenda("Pantalon");
		RepositorioPrenda.getInstance().setTela(pantalon,"Algodon");
		RepositorioPrenda.getInstance().setColorPrimario(pantalon, ColorPersistible.blue.getHex());

		zapatillas = SimpleFactoryPrendas.crearPrenda("Zapatillas");
		RepositorioPrenda.getInstance().setTela(zapatillas,"Cuero");
		RepositorioPrenda.getInstance().setColorPrimario(zapatillas, ColorPersistible.white.getHex());

		campera = SimpleFactoryPrendas.crearPrenda("Campera");
		RepositorioPrenda.getInstance().setTela(campera,"Algodon");
		RepositorioPrenda.getInstance().setColorPrimario(campera, ColorPersistible.black.getHex());

		reloj = SimpleFactoryPrendas.crearPrenda("Reloj");
		RepositorioPrenda.getInstance().setTela(reloj,"Cuero");
		RepositorioPrenda.getInstance().setColorPrimario(reloj, ColorPersistible.yellow.getHex());

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
	public void persistirUsuarioConEvento(){
		RepositorioUsuario.getInstance().agregar(usuario);
	}
}
