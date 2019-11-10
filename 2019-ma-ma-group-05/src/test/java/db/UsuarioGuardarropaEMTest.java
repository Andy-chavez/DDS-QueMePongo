package db;

import models.domain.SimpleFactoryPrendas;
import models.repositorios.DAOs.*;
import models.entities.*;

import models.repositorios.RepositorioGuardarropa;
import models.repositorios.RepositorioPrenda;
import models.repositorios.RepositorioUsuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioGuardarropaEMTest{	
	private Prenda remera;
	private Prenda pantalon;
	private Usuario usuario;
	private Guardarropa guardarropa;
	@Before
	public void init(){
        remera = SimpleFactoryPrendas.crearPrenda("Remera");
        RepositorioPrenda.getInstance().setTela(remera,"Algodon");
        RepositorioPrenda.getInstance().setColorPrimario(remera, ColorPersistible.pink.getHex());

        pantalon = SimpleFactoryPrendas.crearPrenda("Pantalon");
        RepositorioPrenda.getInstance().setTela(pantalon,"Algodon");
        RepositorioPrenda.getInstance().setColorPrimario(pantalon, ColorPersistible.blue.getHex());

		usuario = new Usuario("mati");
        usuario.setCelular("123456789");
        usuario.setMail("X@gmail.com");

        guardarropa = new Guardarropa("formal");
	}
    @Test
    public void persistir1UsuarioTest(){
        RepositorioUsuario.getInstance().agregar(usuario);
    }

    @Test
    public void recuperandoAMati(){
        Usuario mati = (Usuario) RepositorioUsuario.getInstance().buscarPorNombre("mati");
        Assert.assertEquals("mati", mati.getNombre());
    }

    @Test
    public void persistirGuardarropaTest(){
        guardarropa.agregarPrenda(pantalon);
        RepositorioGuardarropa.getInstance().agregar(guardarropa);
    }
    
    @Test
    public void recuperandoGuardarropa(){
        Guardarropa g = RepositorioGuardarropa.getInstance().buscarPorNombre("formal");
        Assert.assertEquals("formal", g.getNombre());
    }
    @Test
    public void persistirPrenda(){
        RepositorioPrenda.getInstance().agregar(remera);
    }
}