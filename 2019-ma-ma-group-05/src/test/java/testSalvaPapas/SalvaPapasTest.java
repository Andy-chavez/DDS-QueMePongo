package testSalvaPapas;

import db.EntityManagerHelper;
import models.entities.Atuendo;
import models.entities.Guardarropa;
import models.entities.Prenda;
import models.repositorios.RepositorioAtuendo;
import models.repositorios.RepositorioGuardarropa;
import models.repositorios.RepositorioPrenda;
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
        List<Atuendo> atuendos =  RepositorioAtuendo.getInstance().buscarTodos(4);
        atuendos.forEach(prenda->{System.out.println(prenda.getId());});
    }

}
