package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Categorias.*;
import models.entities.Tela;
import models.entities.Tipo;

import java.util.ArrayList;
import java.util.List;

public class DAOTipo implements DAO {
    private static DAOTipo instance;

    public static DAOTipo getInstance() {
        if(instance == null){
            instance = new DAOTipo();
        }
        return instance;
    }
    public void iniciarBase() { //(String nombre, Categoria c,List<Tela> telaList, int capa, int abrigo){
        List<Tela> cueroYAlgodon = new ArrayList<>();
        List<Tela> algNylPolYSed = new ArrayList<>();
        cueroYAlgodon.add(new Tela("cuero"));
        cueroYAlgodon.add(new Tela("algodon"));
        algNylPolYSed.add(new Tela("algodon"));
        algNylPolYSed.add(new Tela("nylon"));
        algNylPolYSed.add(new Tela("seda"));
        algNylPolYSed.add(new Tela("poliester"));
        Tipo collar = new Tipo("Collar",new Accesorio(),cueroYAlgodon,0,0);
        Tipo camisa = new Tipo("Camisa",new SuperiorBase(),algNylPolYSed,1,12);
        Tipo campera = new Tipo("Campera",new SuperiorExtra(),algNylPolYSed,3,25);
        Tipo musculosa = new Tipo("Musculosa",new SuperiorBase(),algNylPolYSed,0,8);
        Tipo ojotas = new Tipo("Ojotas",new Calzado(),cueroYAlgodon,0,1);
        Tipo pantalon = new Tipo("Pantalon",new Inferior(),algNylPolYSed,0,30);
        Tipo reloj = new Tipo("Reloj",new Accesorio(),cueroYAlgodon,0,0);
        Tipo remera = new Tipo("Remera",new SuperiorBase(),algNylPolYSed,0,10);
        Tipo shorts = new Tipo("Shorts",new Inferior(),algNylPolYSed,0,15);
        Tipo sweater = new Tipo("Sweater",new SuperiorExtra(),algNylPolYSed,2,12);
        Tipo zapatillas = new Tipo("Zapatillas",new Calzado(),cueroYAlgodon,0,10);

        this.agregar(collar);
        this.agregar(camisa);
        this.agregar(campera);
        this.agregar(musculosa);
        this.agregar(ojotas);
        this.agregar(pantalon);
        this.agregar(reloj);
        this.agregar(remera);
        this.agregar(shorts);
        this.agregar(sweater);
        this.agregar(zapatillas);
    }
    @Override
    public Object buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(Tipo.class, id);
    }

    @Override
    public Object buscarPorNombre(String nombre) {
        //obtiene el primer resultado en caso de haber varios
        String query = "from Tipo as u where u.nombre = '" + nombre + "'";
        List listTipos =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        if(listTipos.size()>0){
            return listTipos.get(0);
        }
        return null;
    }

    @Override
    public List<Object> buscarTodos() {
        String query = "from Tipo";
        List listTipos =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listTipos;
    }

    @Override
    public List<Object> buscarTodos(int id) {
        return null;
    }

}
