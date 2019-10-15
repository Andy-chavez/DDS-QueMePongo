package bd;

import org.junit.Before;
import org.junit.Test;

import db.EntityManagerHelper;
import models.entities.Tela;
import models.entities.Telas.*;

public class SingleTableTelasTest {
	Algodon algodon;
	Tela gabardina;
	
	@Before
	public void init(){
		algodon = new Algodon();
		gabardina = new Tela();
		gabardina.setNombre("gabardina");

	}
    @Test
    public void persistirTelas(){
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(algodon);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(gabardina);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
}
