package bd;

import java.util.List;

import models.entities.*;
import models.entities.Telas.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import db.EntityManagerHelper;
import models.entities.Categorias.SuperiorBase;

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
	}

	@Test
	public void persistirAtuendo(){
		usuario.obtenerSugerencia(guardarropa);
		usuario.obtenerSugerencia(guardarropa);
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().persist(usuario);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
	}
}
