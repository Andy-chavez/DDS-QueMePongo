package controllers;

import models.entities.Usuario;
import models.repositorios.RepositorioGuardarropa;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioController {
    public ModelAndView pantallaDeInicio(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "inicioDeSesion.hbs");
    }
}
