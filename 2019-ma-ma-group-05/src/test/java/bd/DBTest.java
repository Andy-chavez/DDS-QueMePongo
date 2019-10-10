package bd;

import db.EntityManagerHelper;
import db.TipoAttributeConverter;
import entities.Guardarropa;
import entities.Prenda;
import entities.SimpleFactoryPrendas;
import entities.Usuario;
import entities.Telas.Algodon;
import entities.Telas.Cuero;
import entities.Tipos.Camisa;
import entities.Tipos.Remera;

import java.awt.Color;
import org.junit.Assert;
import org.junit.Test;

public class DBTest{	
    @Test
    public void persistir1UsuarioTest(){
        Usuario usuario = new Usuario("mati");
        usuario.setCelular("123456789");
        usuario.setMail("X@gmail.com");
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(usuario);
        EntityManagerHelper.commit();
    }

    @Test
    public void recuperandoAMati(){
        Usuario mati = (Usuario) EntityManagerHelper.getEntityManager().find(Usuario.class,1); //createQuery("from usuario where nombre = 'mati'").getSingleResult();
        Assert.assertEquals("mati", mati.getNombre());
    }
    
    @Test
    public void persistirGuardarropaTest(){
    	Guardarropa g = new Guardarropa("formal");
    	
//    	Prenda remera  = SimpleFactoryPrendas.crearPrenda("remera");
//		remera.setTela(Algodon.getInstance());
//		remera.setColorPrimario(Color.pink);
//		
//    	Prenda pantalon  = SimpleFactoryPrendas.crearPrenda("pantalon");
//		pantalon.setTela(Cuero.getInstance());
//		pantalon.setColorPrimario(Color.black);
//    	
//		g.agregarPrenda(remera);
//		g.agregarPrenda(pantalon);
		
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(g);
        EntityManagerHelper.commit();
    }
    
    @Test
    public void recuperandoGuardarropa(){
        Guardarropa g = (Guardarropa) EntityManagerHelper.createQuery("from guardarropa where nombre = 'formal'").getSingleResult();
        Assert.assertEquals("formal", g.getNombre());
    }
    
    @Test
    public void persistirPrenda(){
//    	TipoAttributeConverter tipoAttr = new TipoAttributeConverter();
//    	System.out.println(tipoAttr.convertToDatabaseColumn(Camisa.getInstance()));
//    	System.out.println(tipoAttr.convertToEntityAttribute("Remera"));
    	Prenda remera  = SimpleFactoryPrendas.crearPrenda("remera");
		remera.setTela(Algodon.getInstance());
		remera.setColorPrimario(Color.pink);
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(remera.getTipo());
        EntityManagerHelper.commit();
        
        EntityManagerHelper.beginTransaction();        
        EntityManagerHelper.getEntityManager().persist(remera);
        EntityManagerHelper.commit();   
    }
    
    @Test
    public void recuperandoPrendas(){
//        Guardarropa g = (Guardarropa) EntityManagerHelper.createQuery("from Prendas where nombre = 'formal'").getSingleResult();
    	Remera remeraTipo = new Remera();
    	EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(remeraTipo);
        EntityManagerHelper.commit();
       //aca el problema esta en que jamas se linkea prenda con remera, creo que lo arregle pero todavia no puedo hacer que remera se persista bien
    	Prenda remera = (Prenda) EntityManagerHelper.createQuery("from prenda where tipo_nombre = 'remera'").getSingleResult();
        Assert.assertEquals("remera", remera.getTipo().toString());
    }
}