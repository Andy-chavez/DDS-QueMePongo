package domain;
import java.util.ArrayList;
import java.util.List;

import models.domain.GestorSugerencia;
import models.entities.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.entities.Categorias.*;

public class MoldeTest {
    Usuario usuario;
    GestorSugerencia gs;

    List<Prenda> prendas;

    Prenda remeraPrenda;
    Prenda musculosaPrenda;
    Prenda camisaPrenda;
    Prenda sweaterPrenda;
    Prenda camperaPrenda;
    Prenda shortsPrenda;
    Prenda pantalonPrenda;
    Prenda ojotasPrenda;
    Prenda zapatillasPrenda;
    Prenda relojPrenda;
    Prenda collarPrenda;

    Tipo remera;
    Tipo musculosa;
    Tipo camisa;
    Tipo sweater;
    Tipo campera;
    Tipo shorts;
    Tipo pantalon;
    Tipo ojotas;
    Tipo zapatillas;
    Tipo reloj;
    Tipo collar;

    @Before
    public void init() {
        prendas = new ArrayList<>();
        gs = GestorSugerencia.getInstance();

        List<Tela> cueroYAlgodon = new ArrayList<>();
        List<Tela> algNylPolYSed = new ArrayList<>();

        cueroYAlgodon.add(new Tela("cuero"));
        cueroYAlgodon.add(new Tela("algodon"));
        algNylPolYSed.add(new Tela("algodon"));
        algNylPolYSed.add(new Tela("nylon"));
        algNylPolYSed.add(new Tela("seda"));
        algNylPolYSed.add(new Tela("poliester"));

        remera = new Tipo("Remera",new Superior(),algNylPolYSed,0,10);
        musculosa = new Tipo("Musculosa",new Superior(),algNylPolYSed,0,8);
        camisa = new Tipo("Camisa",new Superior(),algNylPolYSed,1,12);
        sweater = new Tipo("Sweater",new Superior(),algNylPolYSed,2,12);
        campera = new Tipo("Campera",new Superior(),algNylPolYSed,3,25);
        shorts = new Tipo("Shorts",new Inferior(),algNylPolYSed,0,15);
        pantalon = new Tipo("Pantalon",new Inferior(),algNylPolYSed,0,30);
        ojotas = new Tipo("Ojotas",new Calzado(),cueroYAlgodon,0,1);
        zapatillas = new Tipo("Zapatillas",new Calzado(),cueroYAlgodon,0,30);
        reloj = new Tipo("Reloj",new Accesorio(),cueroYAlgodon,0,0);
        collar = new Tipo("Collar",new Accesorio(),cueroYAlgodon,0,0);

        remeraPrenda = new Prenda(remera);
        musculosaPrenda = new Prenda(musculosa);
        camisaPrenda = new Prenda(camisa);
        sweaterPrenda = new Prenda(sweater);
        camperaPrenda = new Prenda(campera);
        shortsPrenda = new Prenda(shorts);
        pantalonPrenda = new Prenda(pantalon);
        ojotasPrenda = new Prenda(ojotas);
        zapatillasPrenda = new Prenda(zapatillas);
        relojPrenda = new Prenda(reloj);
        collarPrenda = new Prenda(collar);


        prendas.add(remeraPrenda);
        prendas.add(musculosaPrenda);
        prendas.add(camisaPrenda);
        prendas.add(sweaterPrenda);
        prendas.add(camperaPrenda);
        prendas.add(shortsPrenda);
        prendas.add(pantalonPrenda);
        prendas.add(ojotasPrenda);
        prendas.add(zapatillasPrenda);
        prendas.add(relojPrenda);
        prendas.add(collarPrenda);
        usuario = new Usuario("mati");
    }

    @Test
    public void moldeCorrecto(){
        Atuendo atuendo = new Atuendo(usuario);
        gs.agregarPrendasSegunCategoria(atuendo, prendas, 30);
        atuendo.printPrendas();
        System.out.println("Abrigo superior: " + atuendo.getAbrigoSuperior());
        System.out.println("Abrigo inferior: " + atuendo.getAbrigoInferior());
        System.out.println("Abrigo calzado: " + atuendo.getAbrigoCalzado());
        SensibilidadFrio sf = new SensibilidadFrio();
        MoldeAtuendo molde = new MoldeAtuendo(atuendo);
        gs.agregarMoldeAtuendo(molde);
        MoldeAtuendo moldeEncontrado = gs.buscarMoldeParaNivelAbrigo(sf, 35);

        Assert.assertEquals(moldeEncontrado.getAbrigoInferior(),30);
    }
}
