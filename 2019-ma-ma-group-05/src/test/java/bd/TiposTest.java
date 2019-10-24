package bd;

import models.entities.Tela;

import org.junit.Before;
import org.junit.Test;

import models.entities.Tipo;
import models.entities.Categorias.Inferior;
import models.entities.Categorias.SuperiorBase;

import java.util.ArrayList;
import java.util.List;

public class TiposTest {
	List<Tela> telasPosibles;
	Tipo remera;
	Tipo pantalon;
	Tipo campera;
	Tipo sup;
	Inferior inferior;
	SuperiorBase superiorBase;


	@Before
	public void init() {
		telasPosibles = new ArrayList<Tela>();
		telasPosibles.add(new Tela("algodon"));
		telasPosibles.add(new Tela("nylon"));

		superiorBase = new SuperiorBase();
		inferior = new Inferior();

		// creo un tipo "nuevo" para que se agregue a la db
		remera = new Tipo();
		remera.setCategoria(superiorBase);
		remera.setTelasPosibles(telasPosibles);
		remera.setNombre("remera");
		remera.setCapa(0);
		remera.setNivelAbrigo(10);

		// creo un tipo "nuevo" para que se agregue a la db
		telasPosibles.add(new Tela("Cuero"));
		pantalon = new Tipo();
		pantalon.setCategoria(inferior);
		pantalon.setTelasPosibles(telasPosibles);
		pantalon.setNombre("pantalon");
		pantalon.setCapa(0);
		pantalon.setNivelAbrigo(20);

		// uso un tipo sya definido para que se agregue a la db
//		campera = Campera.getInstance();

	}

	@Test
	public void persistirTipos() {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().persist(superiorBase);
		EntityManagerHelper.getEntityManager().persist(inferior);
		EntityManagerHelper.getEntityManager().persist(remera);
		EntityManagerHelper.getEntityManager().persist(pantalon);
//		EntityManagerHelper.getEntityManager().persist(campera);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
	}
}
