package bd;

import db.EntityManagerHelper;
import models.entities.Guardarropa;
import models.entities.Prenda;
import models.entities.SimpleFactoryPrendas;
import models.entities.Usuario;
import models.entities.Telas.Algodon;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioGuardarropaEMTest{	
	private Prenda remera;
	private Usuario usuario;
	private Guardarropa guardarropa;
	@Before
	public void init(){
		remera = SimpleFactoryPrendas.crearPrenda("remera");
		remera.setTela(Algodon.getInstance());
		
		usuario = new Usuario("mati");
        usuario.setCelular("123456789");
        usuario.setMail("X@gmail.com");
        
        guardarropa = new Guardarropa("formal");
	}
    @Test
    public void persistir1UsuarioTest(){
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(usuario);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Test
    public void recuperandoAMati(){
    	@SuppressWarnings("rawtypes")
		List h =  EntityManagerHelper.getEntityManager().createQuery("from Usuario as u where u.nombre = 'mati'").getResultList();
        EntityManagerHelper.closeEntityManager();
        Usuario mati = (Usuario) h.get(0);
        Assert.assertEquals("mati", mati.getNombre());
    }
    
    @Test
    public void persistirGuardarropaTest(){   	
//		remera.setColorPrimario(Color.pink);
//		
//    	Prenda pantalon  = SimpleFactoryPrendas.crearPrenda("pantalon");
//		pantalon.setTela(Cuero.getInstance());
//		pantalon.setColorPrimario(Color.black);
//    	
//		g.agregarPrenda(remera);
//		g.agregarPrenda(pantalon);
		
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(guardarropa);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
    
    @Test
    public void recuperandoGuardarropa(){
        @SuppressWarnings("rawtypes")
		List h =  EntityManagerHelper.getEntityManager().createQuery("from Guardarropa as g where g.nombre = 'formal'").getResultList();
        EntityManagerHelper.closeEntityManager();
        Guardarropa g = (Guardarropa) h.get(0);
        Assert.assertEquals("formal", g.getNombre());
    }
    
    @Test
    public void persistirPrenda(){ //TODO esto parece no tener efecto
//    	TipoAttributeConverter tipoAttr = new TipoAttributeConverter();
//    	System.out.println(tipoAttr.convertToDatabaseColumn(Camisa.getInstance()));
//    	System.out.println(tipoAttr.convertToEntityAttribute("Remera"));
    	//remera.setColorPrimario(Color.pink);

       // EntityManagerHelper.beginTransaction(); //"Error while commiting the transaction"
        EntityManagerHelper.persist(remera);
        EntityManagerHelper.commit();   
        EntityManagerHelper.closeEntityManager();
    }
    
    @Test
    public void recuperandoPrendas(){ //TODO este no funciona, parece ser que prenda jamas llego a estar en la bd o mismo que no le gusta el create query
//        Guardarropa g = (Guardarropa) EntityManagerHelper.createQuery("from Prendas where nombre = 'formal'").getSingleResult();
    	//Remera remeraTipo = new Remera();
    	//EntityManagerHelper.beginTransaction();
        //EntityManagerHelper.persist(remeraTipo);
        //EntityManagerHelper.commit();
    	Prenda rem = (Prenda) EntityManagerHelper.getEntityManager().find(Prenda.class, remera.getId());
    	//Prenda remera = (Prenda) EntityManagerHelper.createQuery("from prenda where tipo_nombre = 'remera'").getSingleResult();
    	EntityManagerHelper.closeEntityManager();
    	Assert.assertEquals("remera", rem.getTipo().toString());
    }
    
}