package db;

import org.junit.Before;
import org.junit.Test;

import models.entities.Tela;

public class TelasTest {
	Tela algodon;
	Tela gabardina;
	
	@Before
	public void init(){
		algodon = new Tela("algodon");
		gabardina = new Tela("gabardina");

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
