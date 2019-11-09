package controllers;
import models.entities.Guardarropa;
import models.entities.Usuario;
import models.repositorios.RepositorioGuardarropa;
import models.repositorios.RepositorioPrenda;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class InicioController {
    private List<Usuario> usuarios;
//    private AdministradorDeSesion administradorDeSesion;

    public InicioController() {
        usuarios = new ArrayList<>();
//        administradorDeSesion = new AdministradorDeSesion();
    }

    public ModelAndView inicio(Request request, Response response) {
//        administradorDeSesion.cerrarSesion(request);
        return new ModelAndView(null, "inicio.hbs");
    }
}
