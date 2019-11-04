package db;

import models.entities.Categorias.Superior;
import models.entities.Tela;

import models.repositorios.RepositorioTipo;
import org.junit.Before;
import org.junit.Test;

import models.entities.Tipo;
import models.entities.Categorias.Inferior;

import java.util.ArrayList;
import java.util.List;

public class TiposTest {
	List<Tela> telasPosibles;
	Tipo remera;
	Tipo pantalon;
	Inferior inferior;
	Superior superior;


	@Before
	public void init() {
		telasPosibles = new ArrayList<Tela>();
		telasPosibles.add(new Tela("algodon"));
		telasPosibles.add(new Tela("nylon"));

		superior = new Superior();
		inferior = new Inferior();

		// creo un tipo "nuevo" para que se agregue a la db
		remera = new Tipo();
		remera.setCategoria(superior);
		remera.setTelasPosibles(telasPosibles);
		remera.setNombre("remera");
		remera.setCapa(0);
		remera.setNivelAbrigo(10);

		telasPosibles.add(new Tela("Cuero"));
		pantalon = new Tipo();
		pantalon.setCategoria(inferior);
		pantalon.setTelasPosibles(telasPosibles);
		pantalon.setNombre("pantalon");
		pantalon.setCapa(0);
		pantalon.setNivelAbrigo(20);
	}

	@Test
	public void persistirTipos() {
		RepositorioTipo.getInstance().agregar(remera);
		RepositorioTipo.getInstance().agregar(pantalon);
	}
}
