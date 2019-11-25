package testSalvaPapas;

import models.entities.*;
import models.entities.Categorias.Superior;
import models.repositorios.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuscarPorNombreTest {

    @Test
    public void buscoTela(){
        Tela telaBuscada = RepositorioTela.getInstance().buscarPorNombre("algodon");
        Assert.assertEquals("algodon", telaBuscada.getNombre());
    }
    @Test
    public void buscoTipo(){
        Tipo tipoBuscado = RepositorioTipo.getInstance().buscarPorNombre("Remera");
        Assert.assertEquals("Remera", tipoBuscado.getNombre());
    }
    @Test
    public void buscoCategoria(){
        Categoria categoriaBuscada = RepositorioCategoria.getInstance().buscarPorNombre("Superior");
        Assert.assertEquals("Superior", categoriaBuscada.getNombre());
    }
    @Test
    public void limpiarString(){
        String path = "C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_remera.jpg";
        List<String> pathlimpio = Arrays.asList(path.split("/"));
        pathlimpio.forEach(prenda->{System.out.println(prenda);});
        System.out.println(pathlimpio.get((pathlimpio.size()-1)));
    }
}
