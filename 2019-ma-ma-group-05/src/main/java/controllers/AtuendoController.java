package controllers;

import models.entities.Atuendo;
import models.entities.Guardarropa;
import models.entities.Prenda;
import models.repositorios.RepositorioAtuendo;
import models.repositorios.RepositorioGuardarropa;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AtuendoController {
    private RepositorioAtuendo repo;

    public AtuendoController(){
        this.repo = RepositorioAtuendo.getInstance();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        List<Atuendo> atuendos =  repo.getInstance().buscarTodos(4);
        parametros.put("atuendos", atuendos);
        return new ModelAndView(parametros, "calificarAtuendos.hbs");
    }
}
