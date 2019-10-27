package db;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.entities.Categoria;
import models.entities.Categorias.SuperiorBase;

public class SingleTableCategoriasTest {

	SuperiorBase superior;
	@Before
	public void init(){
		superior = new SuperiorBase();
	}
	
    @Test
    public void persistirCategorias(){
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(superior);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
    @Test
    public void hidratarCategoria(){
    	List<Categoria> cat1 = (List<Categoria>) EntityManagerHelper.getEntityManager().createQuery("from Categoria as c where c.nombre = 'SuperiorBase'").getResultList();
        Categoria g = (Categoria) cat1.get(0);
        EntityManagerHelper.closeEntityManager();
        Assert.assertEquals("SuperiorBase", g.getNombre());
    }
}
