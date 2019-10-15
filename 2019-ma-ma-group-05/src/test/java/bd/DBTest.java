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
import org.junit.Before;
import org.junit.Test;

public class DBTest{	
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
        Usuario mati = (Usuario) EntityManagerHelper.getEntityManager().find(Usuario.class, usuario.getId());//createQuery("from usuario where nombre = 'mati'").getSingleResult();
        EntityManagerHelper.closeEntityManager();;
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
        Guardarropa g = (Guardarropa) EntityManagerHelper.getEntityManager().find(Guardarropa.class, 1);//createQuery("select nombre from guardarropa as g where g.nombre = 'formal'").getSingleResult();
        EntityManagerHelper.closeEntityManager();
        Assert.assertEquals("formal", g.getNombre());
    }
    
    @Test
    public void persistirPrenda(){ //TODO esto parece no tener efecto
//    	TipoAttributeConverter tipoAttr = new TipoAttributeConverter();
//    	System.out.println(tipoAttr.convertToDatabaseColumn(Camisa.getInstance()));
//    	System.out.println(tipoAttr.convertToEntityAttribute("Remera"));
    	//remera.setColorPrimario(Color.pink);

        //EntityManagerHelper.beginTransaction(); "Error while commiting the transaction"
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