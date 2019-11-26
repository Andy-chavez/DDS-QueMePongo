package testSalvaPapas;

import db.EntityManagerHelper;
import models.entities.*;
import models.repositorios.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalvaPapasTest {

    @Test
    public void salvaPapinesTest(){
        Guardarropa g = RepositorioGuardarropa.getInstance().buscarPorId(1);
        List<Prenda> prendas = g.getPrendas();
        prendas.forEach(prenda->{System.out.println(prenda.getId());});
    }
    @Test
    public void salvaPapinesTest2(){
        RepositorioPrenda.getInstance().eliminar(RepositorioPrenda.getInstance().buscarPorId(4));
    }
    @Test
    public void verAtuendos(){
        List<Atuendo> atuendos =  RepositorioAtuendo.getInstance().buscarTodos(1);
        atuendos.forEach(prenda->{System.out.println(prenda.getId());});
    }
    @Test
    public void verTiposdeCategoria(){
        String categoria = "Superior";
        String query = "from Tipo where categoria.id =" + RepositorioCategoria.getInstance().buscarPorNombre(categoria).getId();
        List<Tipo> tipos =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        tipos.forEach(tipo->{System.out.println(tipo.getNombre());});
    }
    @Test
    public void verEventos(){
        Usuario usuario = RepositorioUsuario.getInstance().buscarPorId(1);
        List<Evento> eventos = usuario.getEventos();
        System.out.println(usuario.getNombre());
        eventos.forEach(prenda->{System.out.println(prenda.getFecha());});
    }

}
