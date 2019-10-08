package bd;

import db.EntityManagerHelper;
import entities.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class DBTest{

    @Test
    public void persistir1UsuarioTest(){
        Usuario usuario = new Usuario("mati");

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(usuario);
        EntityManagerHelper.commit();
    }

    @Test
    public void recuperandoAMati(){
        Usuario eze = (Usuario) EntityManagerHelper.createQuery("from Usuario where nombre = 'mati'").getSingleResult();
        Assert.assertEquals("mati", eze.getNombre());
    }

//    @Test
//    public void persistir2Aporte(){
//        Topico topicoApunte = new Topico();
//        topicoApunte.setNombre("Apunte");
//        topicoApunte.setDescripcion("Colaboración de un apunte");
//
//        EntityManagerHelper.beginTransaction();
//        EntityManagerHelper.getEntityManager().persist(topicoApunte);
//        EntityManagerHelper.commit();
//
//        Aporte unAporte = new Aporte();
//        unAporte.setTopico(topicoApunte);
//        Usuario eze = (Usuario) EntityManagerHelper.createQuery("from Usuario where nombre = 'Eze'").getSingleResult();
//        unAporte.setUsuario(eze);
//        unAporte.setNombre("Apunte de diseño");
//        unAporte.setDescripcion("Taller ORM");
//
//        EntityManagerHelper.beginTransaction();
//        EntityManagerHelper.getEntityManager().persist(unAporte);
//        EntityManagerHelper.commit();
//    }
}