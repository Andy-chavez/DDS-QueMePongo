package bd;

import models.entities.Tela;
import models.entities.Telas.Algodon;
import models.entities.Telas.Cuero;
import models.entities.Telas.Nylon;
import models.entities.Tipos.Campera;
import org.junit.Before;
import org.junit.Test;

import db.EntityManagerHelper;
import models.entities.Tipo;
import models.entities.Categorias.Inferior;
import models.entities.Categorias.SuperiorBase;
import models.entities.Tipos.Remera;

import java.util.ArrayList;
import java.util.List;

//public class SingleTableTiposTest {
//	Remera remera;
//	Tipo pantalon;
//	Inferior inf;
//	SuperiorBase sup;
//
//	@Before
//	public void init(){
//		remera = new Remera();
//		pantalon = new Tipo();
//		inf = new Inferior();
//		sup = new SuperiorBase();
//		pantalon.setCategoria(sup); //aca, cambiar por inf y el test da bien
//
//	}
//    @Test
//    public void persistirTipos(){
//    	//no se que pasa aca, si persisto la categoria primero a manopla, dps el pantalon se persiste todo ok
//    	//pero si no persisto la categoria, no infiere a donde va, debuggee pero no ayudo de mucho
//    	//quiza es la relacion pero no logro encontrarle el error
//    	EntityManagerHelper.beginTransaction();
//        EntityManagerHelper.getEntityManager().persist(inf);
//        EntityManagerHelper.commit();
//        EntityManagerHelper.closeEntityManager();
//        EntityManagerHelper.beginTransaction();
//        EntityManagerHelper.getEntityManager().persist(pantalon);
//        EntityManagerHelper.commit();
//        EntityManagerHelper.closeEntityManager();
//    }
//}

public class SingleTableTiposTest {
	List<Tela> telasPosibles;
	Tipo remera;
	Tipo pantalon;
	Campera campera;
	Tipo sup;

	@Before
	public void init() {
		telasPosibles = new ArrayList<Tela>();
		telasPosibles.add(new Algodon());
		telasPosibles.add(new Nylon());

		remera = new Tipo();
		remera.setCategoria(SuperiorBase.getInstance());
		remera.setTelasPosibles(telasPosibles);
		remera.setNombre("remera");
		remera.setCapa(0);
		remera.setNivelAbrigo(10);

		telasPosibles.add(new Cuero());
		pantalon = new Tipo();
		pantalon.setCategoria(Inferior.getInstance());
		pantalon.setTelasPosibles(telasPosibles);
		pantalon.setNombre("pantalon");
		pantalon.setCapa(0);
		pantalon.setNivelAbrigo(20);

		campera = Campera.getInstance();

	}

	@Test
	public void persistirTipos() {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().persist(pantalon);
		EntityManagerHelper.getEntityManager().persist(campera);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
	}
}
