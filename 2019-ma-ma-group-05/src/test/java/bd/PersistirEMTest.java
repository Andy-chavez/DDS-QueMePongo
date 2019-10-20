package bd;

import db.EntityManagerHelper;
import models.entities.*;
import models.entities.Tipos.Camisa;
import models.entities.Tipos.Pantalon;
import models.entities.Tipos.Zapatillas;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PersistirEMTest {
	private Usuario usuario;
    Zapatillas zapatillas;
    ColorPersistible verde;
    ColorPersistible negro;
    ColorPersistible azul;
	@Before
	public void init(){

        verde = ColorPersistible.green;
        negro = ColorPersistible.black;
        azul = ColorPersistible.blue;
        
		
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
		EntityManagerHelper.persist(usuario);
        EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
	}

//	@Test
//	public void persistirYRemoverUsuarioTest() {
//        EntityManagerHelper.beginTransaction();
//        EntityManagerHelper.persist(usuario);
//        Usuario user = EntityManagerHelper.getEntityManager().find(usuario.getClass(), usuario.getId());
//        EntityManagerHelper.getEntityManager().remove(user);
//        EntityManagerHelper.commit();
//        EntityManagerHelper.closeEntityManager();
//	}


	@Test
	public void persistoColor() {
		ColorPersistible orange = ColorPersistible.orange;
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.persist(orange);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
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
