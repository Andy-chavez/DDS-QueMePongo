package db;

import models.domain.SimpleFactoryPrendas;
import models.entities.*;

import models.repositorios.RepositorioPrenda;
import models.repositorios.RepositorioUsuario;
import org.junit.Before;
import org.junit.Test;

public class PersistirAtuendoTest {
	Usuario usuario;
	Guardarropa guardarropa;
	Prenda remera;
	Prenda pantalon;
	Prenda zapatillas;
	Prenda campera;
	Prenda reloj;

	@Before
	public void init(){
		usuario = new Usuario("mati");
		usuario.setCelular("123456789");
		usuario.setMail("X@gmail.com");

		guardarropa = new Guardarropa("deportivo");

		remera = SimpleFactoryPrendas.crearPrenda("remera");
		RepositorioPrenda.getInstance().setTela(remera,"algodon");
		RepositorioPrenda.getInstance().setColorPrimario(remera, ColorPersistible.pink.getHex());

		pantalon = SimpleFactoryPrendas.crearPrenda("pantalon");
		RepositorioPrenda.getInstance().setTela(pantalon,"algodon");
		RepositorioPrenda.getInstance().setColorPrimario(pantalon, ColorPersistible.blue.getHex());

		zapatillas = SimpleFactoryPrendas.crearPrenda("zapatillas");
		RepositorioPrenda.getInstance().setTela(zapatillas,"cuero");
		RepositorioPrenda.getInstance().setColorPrimario(zapatillas, ColorPersistible.white.getHex());

		campera = SimpleFactoryPrendas.crearPrenda("campera");
		RepositorioPrenda.getInstance().setTela(campera,"algodon");
		RepositorioPrenda.getInstance().setColorPrimario(campera, ColorPersistible.black.getHex());

		reloj = SimpleFactoryPrendas.crearPrenda("reloj");
		RepositorioPrenda.getInstance().setTela(reloj,"cuero");
		RepositorioPrenda.getInstance().setColorPrimario(reloj, ColorPersistible.yellow.getHex());

		usuario.agregarGuardarropa(guardarropa);
		usuario.agregarPrenda(guardarropa, remera);
		usuario.agregarPrenda(guardarropa, pantalon);
		usuario.agregarPrenda(guardarropa, zapatillas);
		usuario.agregarPrenda(guardarropa, campera);
		usuario.agregarPrenda(guardarropa, reloj);
	}

	@Test
	public void persistirAtuendo(){
		Atuendo atuendo1 = usuario.obtenerSugerencia(guardarropa);
		Atuendo atuendo2 = usuario.obtenerSugerencia(guardarropa);
		RepositorioUsuario.getInstance().agregar(usuario);

	}
}
