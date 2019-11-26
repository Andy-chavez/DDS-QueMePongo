package controllers;

import models.entities.*;
import models.repositorios.RepositorioAtuendo;
import models.repositorios.RepositorioEvento;
import models.repositorios.RepositorioGuardarropa;
import models.repositorios.RepositorioUsuario;
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
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        Usuario usuario = RepositorioUsuario.getInstance().buscarPorId(request.session().attribute("currentUser"));
        List<Atuendo> atuendos =  repo.getInstance().buscarTodos(usuario.getId());
        parametros.put("atuendos", atuendos);
        return new ModelAndView(parametros, "calificarAtuendos.hbs");
    }

 }
