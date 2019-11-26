package db;

import models.domain.SimpleFactoryPrendas;
import models.domain.Suscripciones.Free;
import models.domain.Suscripciones.Premium;
import models.entities.ColorPersistible;
import models.entities.Guardarropa;
import models.entities.Prenda;
import models.entities.Usuario;
import models.repositorios.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CargaDatosDespliegue {
    private Usuario jazul;
    private Prenda jazul_remeraCuelloRedondoMangaLarga;
    private Prenda jazul_remeraEscoteVMangaLarga;
    private Prenda jazul_musculosa;
    private Prenda jazul_sueter;
    private Prenda jazul_pollera;
    private Prenda jazul_calza;
    private Prenda jazul_buzo;
    private Prenda jazul_zapatos;
    private Prenda jazul_sandalias;
    private List<Prenda> jazul_prendas;
    private Guardarropa jazul_guardarropa;

    private Usuario aroco;
    private Prenda aroco_remeraCuelloRedondoMangaCorta;
    private Prenda aroco_remeraEscoteVMangaCorta;
    private Prenda aroco_musculosa;
    private Prenda aroco_campera;
    private Prenda aroco_sueter;
    private Prenda aroco_bermuda;
    private Prenda aroco_pantalónLargo;
    private Prenda aroco_zapatillas;
    private Prenda aroco_zapatos;
    private List<Prenda> aroco_prendas;
    private Guardarropa aroco_guardarropa;
    @Before
    public void init(){
        jazul_prendas = new ArrayList<>();
        aroco_prendas = new ArrayList<>();
    }
    @Test
    public void cargarBaseDelSistema(){
        RepositorioCategoria.getInstance().iniciarBase();
        RepositorioTela.getInstance().iniciarBase();
        RepositorioTipo.getInstance().iniciarBase();
        RepositorioColor.getInstance().iniciarBase();
    }
    @Test
    public void cargarDatosDeJazul(){
        jazul = new Usuario("Julieta", "Azul","jazul","123456", Premium.getInstance());
        jazul_buzo = SimpleFactoryPrendas.crearPrenda("buzo");
        RepositorioPrenda.getInstance().setTela(jazul_buzo, "Algodon");
        RepositorioPrenda.getInstance().setColorPrimario(jazul_buzo, ColorPersistible.white.getHex());
        jazul_buzo.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_sueter.jpg");
        jazul_calza = SimpleFactoryPrendas.crearPrenda("calza");
        RepositorioPrenda.getInstance().setTela(jazul_calza,"Nylon");
        RepositorioPrenda.getInstance().setColorPrimario(jazul_calza, ColorPersistible.black.getHex());
        jazul_calza.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_jean.jpg");
        jazul_musculosa = SimpleFactoryPrendas.crearPrenda("musculosa");
        RepositorioPrenda.getInstance().setTela(jazul_musculosa, "Lycra");
        RepositorioPrenda.getInstance().setColorPrimario(jazul_musculosa, ColorPersistible.green.getHex());
        jazul_musculosa.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_remeras.jpg");
        jazul_pollera = SimpleFactoryPrendas.crearPrenda("pollera");
        RepositorioPrenda.getInstance().setTela(jazul_pollera, "Seda");
        RepositorioPrenda.getInstance().setColorPrimario(jazul_pollera,ColorPersistible.black.getHex());
        jazul_pollera.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_pollera.jpg");
        jazul_remeraCuelloRedondoMangaLarga = SimpleFactoryPrendas.crearPrenda("Remera cuello redondo manga larga");
        RepositorioPrenda.getInstance().setTela(jazul_remeraCuelloRedondoMangaLarga, "Lycra");
        RepositorioPrenda.getInstance().setColorPrimario(jazul_remeraCuelloRedondoMangaLarga, ColorPersistible.yellow.getHex());
        jazul_remeraCuelloRedondoMangaLarga.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_remeras.jpg");
        jazul_remeraEscoteVMangaLarga = SimpleFactoryPrendas.crearPrenda("Remera escote V manga larga");
        RepositorioPrenda.getInstance().setTela(jazul_remeraEscoteVMangaLarga, "Algodon");
        RepositorioPrenda.getInstance().setColorPrimario(jazul_remeraEscoteVMangaLarga, ColorPersistible.white.getHex());
        jazul_remeraEscoteVMangaLarga.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_remeras.jpg");
        jazul_sandalias = SimpleFactoryPrendas.crearPrenda("sandalias");
        RepositorioPrenda.getInstance().setTela(jazul_sandalias, "Cuero");
        RepositorioPrenda.getInstance().setColorPrimario(jazul_sandalias, ColorPersistible.black.getHex());
        jazul_sandalias.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_sandalias.jpg");
        jazul_sueter = SimpleFactoryPrendas.crearPrenda("sueter");
        RepositorioPrenda.getInstance().setTela(jazul_sueter, "Poliester");
        RepositorioPrenda.getInstance().setColorPrimario(jazul_sueter, ColorPersistible.lightGray.getHex());
        jazul_sueter.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_sueter.jpg");
        jazul_zapatos = SimpleFactoryPrendas.crearPrenda("zapatos");
        RepositorioPrenda.getInstance().setTela(jazul_zapatos, "Cuero");
        RepositorioPrenda.getInstance().setColorPrimario(jazul_zapatos, ColorPersistible.black.getHex());
        jazul_zapatos.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_zapato.jpg");
        jazul_prendas.add(jazul_remeraCuelloRedondoMangaLarga);
        jazul_prendas.add(jazul_remeraEscoteVMangaLarga);
        jazul_prendas.add(jazul_musculosa);
        jazul_prendas.add(jazul_sueter);
        jazul_prendas.add(jazul_pollera);
        jazul_prendas.add(jazul_calza);
        jazul_prendas.add(jazul_buzo);
        jazul_prendas.add(jazul_zapatos);
        jazul_prendas.add(jazul_sandalias);

        jazul_guardarropa = new Guardarropa("Formal",jazul_prendas);

        jazul.agregarGuardarropa(jazul_guardarropa);
        RepositorioUsuario.getInstance().agregar(jazul);

    }
    @Test
    public void cargarDatosDeAroco(){
        aroco = new Usuario("Alejandro","Roco","aroco","123456",Free.getInstance());

        aroco_remeraCuelloRedondoMangaCorta = SimpleFactoryPrendas.crearPrenda("Remera cuello redondo manga corta");
        RepositorioPrenda.getInstance().setTela(aroco_remeraCuelloRedondoMangaCorta, "Algodon");
        RepositorioPrenda.getInstance().setColorPrimario(aroco_remeraCuelloRedondoMangaCorta, ColorPersistible.black.getHex());
        aroco_remeraCuelloRedondoMangaCorta.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_remeras.jpg");
        aroco_remeraEscoteVMangaCorta = SimpleFactoryPrendas.crearPrenda("Remera escote V manga corta");
        RepositorioPrenda.getInstance().setTela(aroco_remeraEscoteVMangaCorta,"Lycra");
        RepositorioPrenda.getInstance().setColorPrimario(aroco_remeraEscoteVMangaCorta, ColorPersistible.white.getHex());
        aroco_remeraEscoteVMangaCorta.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_remeras.jpg");
        aroco_musculosa = SimpleFactoryPrendas.crearPrenda("musculosa");
        RepositorioPrenda.getInstance().setTela(aroco_musculosa, "Lycra");
        RepositorioPrenda.getInstance().setColorPrimario(aroco_musculosa, ColorPersistible.yellow.getHex());
        aroco_musculosa.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_remeras.jpg");
        aroco_campera = SimpleFactoryPrendas.crearPrenda("campera");
        RepositorioPrenda.getInstance().setTela(aroco_campera, "Cuero");
        RepositorioPrenda.getInstance().setColorPrimario(aroco_campera,ColorPersistible.white.getHex());
        aroco_campera.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_campera.jpg");
        aroco_sueter = SimpleFactoryPrendas.crearPrenda("Sueter");
        RepositorioPrenda.getInstance().setTela(aroco_sueter, "Poliester");
        RepositorioPrenda.getInstance().setColorPrimario(aroco_sueter, ColorPersistible.white.getHex());
        aroco_sueter.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_sueter.jpg");
        aroco_bermuda = SimpleFactoryPrendas.crearPrenda("bermuda");
        RepositorioPrenda.getInstance().setTela(aroco_bermuda, "Jean");
        RepositorioPrenda.getInstance().setColorPrimario(aroco_bermuda, ColorPersistible.cyan.getHex());
        aroco_bermuda.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_bermuda.jpg");
        aroco_pantalónLargo = SimpleFactoryPrendas.crearPrenda("Pantalón Largo");
        RepositorioPrenda.getInstance().setTela(aroco_pantalónLargo, "Nylon");
        RepositorioPrenda.getInstance().setColorPrimario(aroco_pantalónLargo, ColorPersistible.darkGray.getHex());
        aroco_pantalónLargo.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_jean.jpg");
        aroco_zapatillas = SimpleFactoryPrendas.crearPrenda("zapatillas");
        RepositorioPrenda.getInstance().setTela(aroco_zapatillas, "Nylon");
        RepositorioPrenda.getInstance().setColorPrimario(aroco_zapatillas, ColorPersistible.darkRed.getHex());
        aroco_zapatillas.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_zapatillas.jpg");
        aroco_zapatos = SimpleFactoryPrendas.crearPrenda("zapatos");
        RepositorioPrenda.getInstance().setTela(aroco_zapatos, "Cuero");
        RepositorioPrenda.getInstance().setColorPrimario(aroco_zapatos, ColorPersistible.black.getHex());
        aroco_zapatos.setImage("C:/Users/Andy/Documents/GitHub/3 SISTEMAS/DDS/2019-ma-ma-group-05/2019-ma-ma-group-05/src/main/resources/public/images/foto_zapatos.jpg");

        aroco_prendas.add(aroco_remeraCuelloRedondoMangaCorta);
        aroco_prendas.add(aroco_remeraEscoteVMangaCorta);
        aroco_prendas.add(aroco_musculosa);
        aroco_prendas.add(aroco_campera);
        aroco_prendas.add(aroco_sueter);
        aroco_prendas.add(aroco_bermuda);
        aroco_prendas.add(aroco_pantalónLargo);
        aroco_prendas.add(aroco_zapatillas);
        aroco_prendas.add(aroco_zapatos);

        aroco_guardarropa = new Guardarropa("Formal",aroco_prendas);

        aroco.agregarGuardarropa(aroco_guardarropa);
        RepositorioUsuario.getInstance().agregar(aroco);
    }
}
