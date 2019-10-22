package bd;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import db.EntityManagerHelper;
import models.entities.Categoria;
import models.entities.Usuario;
import models.entities.Categorias.SuperiorBase;

public class SingleTableCategoriasTest {
	

	Categoria cuerpoEntero; //ignoren esta que la super invente para probar algo
	SuperiorBase superior;
	@Before
	public void init(){
		
//		cuerpoEntero = new Categoria();
		superior = SuperiorBase.getInstance();
	}
	
    @Test
    public void persistirCategorias(){ 
    	//TODO quiza estaria bueno pensar en ponerle un nombre a las categorias, 
    	//parece irrelevante pero con las telas quedo copado el hecho de que sepas cual fue generada "nueva" 
    	//porque en el discriminador dice "Tela" a secas pero poniendole nombre sabes que es
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(superior);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(cuerpoEntero);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
    @Test
    public void hidratarCategoria(){ 
    	//TODO no se muy bien por que atributo matchear porque solo esta el id que no es muy consistente
    	Categoria cat1 = (Categoria) EntityManagerHelper.getEntityManager().createQuery("from Categoria as c where c.id = 2").getSingleResult();
        EntityManagerHelper.closeEntityManager();
        Assert.assertEquals("SuperiorBase", cat1.getClass().getSimpleName());
    }
}
