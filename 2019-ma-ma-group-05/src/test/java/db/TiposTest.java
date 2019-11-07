package db;

import models.entities.Categorias.Superior;
import models.entities.Tela;

import models.repositorios.Repositorio;
import models.repositorios.RepositorioTela;
import models.repositorios.RepositorioTipo;
import org.junit.Before;
import org.junit.Test;

import models.entities.Tipo;
import models.entities.Categorias.Inferior;

import java.util.ArrayList;
import java.util.List;

public class TiposTest {
	Tipo remera;
	Tipo pantalon;

	@Before
	public void init() {
		// creo un tipo "nuevo" para que se agregue a la db
		remera = RepositorioTipo.getInstance().crearNuevoTipo("remera");
		RepositorioTipo.getInstance().setTela(remera,"algodon");
		RepositorioTipo.getInstance().setTela(remera,"nylon");
		RepositorioTipo.getInstance().setCategoria(remera, "Superior");
		remera.setCapa(0);
		remera.setNivelAbrigo(10);

		pantalon = RepositorioTipo.getInstance().crearNuevoTipo("pantalon");
		RepositorioTipo.getInstance().setCategoria(pantalon, "Inferior");
		RepositorioTipo.getInstance().setTela(pantalon,"algodon");
		RepositorioTipo.getInstance().setTela(pantalon,"nylon");
		RepositorioTipo.getInstance().setTela(pantalon,"cuero");
		pantalon.setCapa(0);
		pantalon.setNivelAbrigo(20);
	}

	@Test
	public void persistirTipos() {
		RepositorioTipo.getInstance().agregar(remera);
		RepositorioTipo.getInstance().agregar(pantalon);
	}
}
