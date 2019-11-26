package controllers;

import models.entities.*;
import models.repositorios.*;
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
        List<Tipo> tipos = RepositorioTipo.getInstance().buscarTodos();
        List<Tela> telas = RepositorioTela.getInstance().buscarTodos();
        List<ColorPersistible> colores = RepositorioColor.getInstance().buscarTodos();
        Usuario usuario = RepositorioUsuario.getInstance().buscarPorId(request.session().attribute("currentUser"));
        List<Guardarropa> guardarropas = usuario.getGuardarropas();
        parametros.put("tipo", tipos);
        parametros.put("tela", telas);
        parametros.put("color", colores);
        parametros.put("guardarropas", guardarropas);
        return new ModelAndView(parametros, "crearPrendaPedorro.hbs");
    }

    public ModelAndView eleccionDeCategoria(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
//        List<Tipo> tipos = RepositorioTipo.getInstance().buscarPorCategoria(request.params("nombre"));
//        parametros.put("tipos", tipos);
        return new ModelAndView(parametros, "eleccionDeCategoria.hbs");
    }
    public Response guardarPrenda(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Usuario usuario = RepositorioUsuario.getInstance().buscarPorId(request.session().attribute("currentUser"));
        Prenda prenda = new Prenda();
        if(request.queryParams("nombre") != null)
            prenda.setImage(request.queryParams("imagen"));
        RepositorioPrenda.getInstance().setTipo(prenda, request.queryParams("tipo"));
        RepositorioPrenda.getInstance().setTela(prenda, request.queryParams("tela"));
        RepositorioPrenda.getInstance().setColorPrimario(prenda, request.queryParams("colorPrimario"));
        RepositorioPrenda.getInstance().setColorSecundario(prenda, request.queryParams("colorSecundario"));

        Guardarropa g = RepositorioGuardarropa.getInstance().buscarPorId(new Integer(request.queryParams("guardarropa")));
        g.agregarPrenda(prenda);

        RepositorioGuardarropa.getInstance().modficar(g);

        response.redirect("/guardarropas");
        return response;
    }
}

