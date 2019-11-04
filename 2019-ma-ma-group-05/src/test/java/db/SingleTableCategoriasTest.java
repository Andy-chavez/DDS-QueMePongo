package db;

import models.repositorios.RepositorioCategoria;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.entities.Categoria;
import models.entities.Categorias.Superior;

public class SingleTableCategoriasTest {

	Superior superior;
	@Before
	public void init(){
		superior = new Superior();
	}
	
    @Test
    public void persistirCategorias(){
        RepositorioCategoria.getInstance().agregar(superior);
    }
    @Test
    public void hidratarCategoria(){
	    Categoria categ = RepositorioCategoria.getInstance().buscarPorNombre("Superior");
        Assert.assertEquals("Superior", categ.getNombre());
    }
}
