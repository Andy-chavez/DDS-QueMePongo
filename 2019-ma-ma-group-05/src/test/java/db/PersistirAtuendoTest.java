package db;

import models.entities.*;

import models.repositorios.RepositorioTela;
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
	}

	@Test
	public void persistirAtuendo(){
		Atuendo atuendo1 = usuario.obtenerSugerencia(guardarropa);
		Atuendo atuendo2 = usuario.obtenerSugerencia(guardarropa);
		RepositorioUsuario.getInstance().agregar(usuario);

	}
}
