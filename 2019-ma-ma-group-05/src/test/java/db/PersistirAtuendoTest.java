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
	}

	@Test
	public void persistirAtuendo(){
		Atuendo atuendo1 = usuario.obtenerSugerencia(guardarropa);
		Atuendo atuendo2 = usuario.obtenerSugerencia(guardarropa);
		RepositorioUsuario.getInstance().agregar(usuario);

	}
}
