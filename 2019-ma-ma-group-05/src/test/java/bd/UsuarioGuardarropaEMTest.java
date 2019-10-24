package bd;

import db.EntityManagerHelper;
import models.DAOs.DAOUsuario;
import models.entities.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioGuardarropaEMTest{	
	private Prenda remera;
	private Prenda pantalon;
	private Usuario usuario;
	private Guardarropa guardarropa;
	private DAOUsuario dao;
	@Before
	public void init(){
	    dao = new DAOUsuario();
		remera = SimpleFactoryPrendas.crearPrenda("remera");
		remera.setTela(new Tela("algodon"));
		remera.setColorPrimario(ColorPersistible.blue);

    	pantalon = SimpleFactoryPrendas.crearPrenda("pantalon");
		pantalon.setTela(new Tela("algodon"));
		pantalon.setColorPrimario(ColorPersistible.black);

		usuario = new Usuario("mati");
        usuario.setCelular("123456789");
        usuario.setMail("X@gmail.com");

        guardarropa = new Guardarropa("formal");
	}
    @Test
    public void persistir1UsuarioTest(){
	    dao.agregar(usuario);
    }

    @Test
    public void recuperandoAMati(){
        Usuario mati = (Usuario) dao.buscarPorNombre("mati");
        Assert.assertEquals("mati", mati.getNombre());
    }

    @Test
    public void persistirGuardarropaTest(){
//		guardarropa.agregarPrenda(remera); // si se persiste remera aca, no se puede persistir en el otro test
        guardarropa.agregarPrenda(pantalon);

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
    public void persistirPrenda(){
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.persist(remera);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
//    @Test
//    public void recuperandoPrendas(){ //TODO este no funciona, parece ser que prenda jamas llego a estar en la bd o mismo que no le gusta el create query
//        Guardarropa g = (Guardarropa) EntityManagerHelper.createQuery("from Prendas where nombre = 'formal'").getSingleResult();
//    	  Remera remeraTipo = new Remera();
//    	  EntityManagerHelper.beginTransaction();
//        EntityManagerHelper.persist(remeraTipo);
//        EntityManagerHelper.commit();
//    	  Prenda rem = (Prenda) EntityManagerHelper.getEntityManager().find(Prenda.class, remera.getId());
//    	  Prenda remera = (Prenda) EntityManagerHelper.createQuery("from prenda where tipo_nombre = 'remera'").getSingleResult();
//    	  EntityManagerHelper.closeEntityManager();
//    	  Assert.assertEquals("remera", rem.getTipo().toString());
//    }
}