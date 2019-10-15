package bd;

import org.junit.Before;
import org.junit.Test;

import db.EntityManagerHelper;
import models.entities.Categoria;
import models.entities.Tipo;
import models.entities.Categorias.SuperiorBase;
import models.entities.Tipos.Remera;

public class SingleTableTiposTest {
	Remera remera;
	Tipo pantalon;

	@Before
	public void init(){
		remera = new Remera();
		pantalon = new Tipo();
	}
    @Test
    public void persistirTipos(){
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(remera);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
}
