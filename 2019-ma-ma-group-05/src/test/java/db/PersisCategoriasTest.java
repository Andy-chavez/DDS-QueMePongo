package db;

import models.repositorios.RepositorioCategoria;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.entities.Categoria;
import models.entities.Categorias.Superior;

public class PersisCategoriasTest {

	Superior superior;
	@Before
	public void init(){
		superior = new Superior();
	}
	
    @Test
    public void PrimeroPersistirCategorias(){
	    //pongo a proposito varias veces la misma categoria -> si se persiste una vez, golazo Repo funciona
        RepositorioCategoria.getInstance().agregar(superior);
        RepositorioCategoria.getInstance().agregar(superior);
        RepositorioCategoria.getInstance().agregar(superior);
        RepositorioCategoria.getInstance().agregar(superior);
        RepositorioCategoria.getInstance().agregar(superior);
    }
    @Test
    public void SegundoHidratarCategoria(){
	    Categoria categ = RepositorioCategoria.getInstance().buscarPorNombre("Superior");
        Assert.assertEquals("Superior", categ.getNombre());
    }
}
