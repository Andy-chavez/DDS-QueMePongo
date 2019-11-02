package db;

import models.repositorios.RepositorioCategoria;
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
        RepositorioCategoria.getInstance().agregar(superior);
    }
    @Test
    public void hidratarCategoria(){
	    Categoria categ = RepositorioCategoria.getInstance().buscarPorNombre("SuperiorBase");
        Assert.assertEquals("SuperiorBase", categ.getNombre());
    }
}
