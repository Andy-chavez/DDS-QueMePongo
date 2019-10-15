package bd;

import org.junit.Before;
import org.junit.Test;

import db.EntityManagerHelper;
import models.entities.Tipo;
import models.entities.Categorias.Inferior;
import models.entities.Categorias.SuperiorBase;
import models.entities.Tipos.Remera;

public class SingleTableTiposTest {
	Remera remera;
	Tipo pantalon;
	Inferior inf;
	SuperiorBase sup;

	@Before
	public void init(){
		remera = new Remera();
		pantalon = new Tipo();
		inf = new Inferior();
		sup = new SuperiorBase();
		pantalon.setCategoria(sup); //aca, cambiar por inf y el test da bien
		
	}
    @Test
    public void persistirTipos(){
    	//no se que pasa aca, si persisto la categoria primero a manopla, dps el pantalon se persiste todo ok
    	//pero si no persisto la categoria, no infiere a donde va, debuggee pero no ayudo de mucho
    	//quiza es la relacion pero no logro encontrarle el error
    	EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(inf);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(pantalon);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
}
