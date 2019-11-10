package db;

import models.entities.Categorias.Accesorio;
import models.entities.Categorias.Calzado;
import models.entities.Categorias.Inferior;
import models.repositorios.RepositorioCategoria;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.entities.Categoria;
import models.entities.Categorias.Superior;

public class PersisCategoriasTest {

	Superior superior;
	Inferior inferior;
	Calzado calzado;
	Accesorio accesorio;
	@Before
	public void init(){
		superior = new Superior();
		inferior = new Inferior();
		calzado = new Calzado();
		accesorio = new Accesorio();
	}
	
    @Test
    public void PrimeroPersistirCategorias(){
	    RepositorioCategoria.getInstance().iniciarBase();
	    //pongo a proposito varias veces la misma categoria -> si se persiste una vez, golazo Repo funciona
        RepositorioCategoria.getInstance().agregar(superior);
        RepositorioCategoria.getInstance().agregar(superior);
        RepositorioCategoria.getInstance().agregar(inferior);
        RepositorioCategoria.getInstance().agregar(calzado);
        RepositorioCategoria.getInstance().agregar(accesorio);
    }
    @Test
    public void SegundoHidratarCategoria(){
	    Categoria categ = RepositorioCategoria.getInstance().buscarPorNombre("Superior");
        Assert.assertEquals("Superior", categ.getNombre());
    }
}
