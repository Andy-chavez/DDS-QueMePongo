package bd;

import db.EntityManagerHelper;
import entities.*;
import entities.Tipos.Camisa;
import entities.Tipos.Pantalon;
import entities.Tipos.Zapatillas;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PersistirEMTest {
	private Usuario usuario;

	@Before
	public void init(){
        ColorPersistible verde = ColorPersistible.green;
        ColorPersistible negro = ColorPersistible.black;
        ColorPersistible azul = ColorPersistible.blue;
        List<Prenda> prendas = new ArrayList<>();
        Tipo zapatillas = new Zapatillas();
        Tipo pantalon = new Pantalon();
        Tipo camisa = new Camisa();

        prendas.add(new Prenda(zapatillas,negro));
        prendas.add(new Prenda(pantalon,azul));
        prendas.add(new Prenda(camisa,verde));

        Guardarropa guardarropa = new Guardarropa("formal",prendas);
        usuario = new Usuario("carlos",guardarropa);
        usuario.setCelular("1160046715");
        usuario.setMail("elpepitoRockaronlero@gmail.com");


	}
	@Test
	public void persistirUsuarioTest() throws InterruptedException {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().persist(usuario);
        EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
	}

	@Test
	public void persistirYRemoverUsuarioTest() {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(usuario);
        Usuario user = EntityManagerHelper.getEntityManager().find(usuario.getClass(), usuario.getId());
        EntityManagerHelper.getEntityManager().remove(user);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
	}

	@Test
	public void eventoSeAgregaAlCron() {
        Color negro = Color.orange;
        ColorPersistible orange = ColorPersistible.orange;
        System.out.println(negro.getRGB());
        System.out.println(negro.getRed());
        System.out.println(negro.getGreen());
        System.out.println(negro.getBlue());
        String hex = "#"+Integer.toHexString(negro.getRGB()).substring(2);
        System.out.println(hex);
        System.out.println(orange.name);
        System.out.println(orange.hex);
        assertTrue(true);
	}
}
