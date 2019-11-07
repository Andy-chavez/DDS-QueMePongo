package db;

import models.domain.SimpleFactoryPrendas;
import models.repositorios.DAOs.*;
import models.entities.*;

import models.repositorios.RepositorioColor;
import models.repositorios.RepositorioUsuario;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PersistirEMTest {
    private DAOUsuario dao;
	private Usuario usuario;
    ColorPersistible verde;
    ColorPersistible negro;
    ColorPersistible azul;
	@Before
	public void init(){
        dao = new DAOUsuario();
        verde = ColorPersistible.green;
        negro = ColorPersistible.black;
        azul = ColorPersistible.blue;
		
        List<Prenda> prendas = new ArrayList<>();
        Prenda zapatillas = SimpleFactoryPrendas.crearPrenda("zapatillas");
        zapatillas.setColorPrimario(negro);
        Prenda pantalon = SimpleFactoryPrendas.crearPrenda("pantalon");
        pantalon.setColorPrimario(azul);
        Prenda camisa = SimpleFactoryPrendas.crearPrenda("camisa");
        camisa.setColorPrimario(verde);
        camisa.setTela(new Tela("algodon"));
        zapatillas.setTela(new Tela("algodon"));
        pantalon.setTela(new Tela("algodon"));
        prendas.add(zapatillas);
        prendas.add(pantalon);
        prendas.add(camisa);

        Guardarropa guardarropa = new Guardarropa("formal",prendas);
        usuario = new Usuario("carlos",guardarropa);
        usuario.setCelular("1160046715");
        usuario.setMail("elpepitoRockaronlero@gmail.com");

	}
	@Test
	public void persistirUsuarioTest() {
		RepositorioUsuario.getInstance().agregar(usuario);
	}

	@Test
	public void persistirYRemoverUsuarioTest() {
        RepositorioUsuario.getInstance().agregar(usuario);
        RepositorioUsuario.getInstance().buscarPorId(usuario.getId());
        RepositorioUsuario.getInstance().eliminar(usuario);
	}

	@Test
	public void persistoColor() {
		ColorPersistible orange = ColorPersistible.orange;
        RepositorioColor.getInstance().agregar(orange);
	}
}
