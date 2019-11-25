package controllers;

import models.entities.Guardarropa;
import models.entities.Prenda;
import models.entities.Tipo;
import models.repositorios.RepositorioGuardarropa;
import models.repositorios.RepositorioPrenda;
import models.repositorios.RepositorioTipo;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrendaController {
    private RepositorioPrenda repo;

    public PrendaController(){
        this.repo = RepositorioPrenda.getInstance();
    }

   public ModelAndView mostrarTodos(Request request, Response response) {
       LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        Guardarropa g = RepositorioGuardarropa.getInstance().buscarPorId(new Integer(request.params("idGuardarropa")));
        List<Prenda> prendas = g.getPrendas();
        parametros.put("prendas", prendas);
        return new ModelAndView(parametros, "prendas.hbs");
    }

    public Response eliminar(Request request, Response response){
        this.repo.eliminar(this.repo.buscarPorId(new Integer(request.params("idPrenda"))));
        return response;
    }

    public ModelAndView pantallaDeCreacion(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "creacion_de_prendas.hbs");
    }

    public ModelAndView eleccionDeCategoria(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
//        List<Tipo> tipos = RepositorioTipo.getInstance().buscarPorCategoria(request.params("nombre"));
//        parametros.put("tipos", tipos);
        return new ModelAndView(parametros, "eleccionDeCategoria.hbs");
    }
}

