package controllers;
import models.entities.*;
import models.entities.Guardarropa;
import models.repositorios.RepositorioGuardarropa;
import models.repositorios.RepositorioPrenda;
import models.repositorios.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarropaController {
    private RepositorioGuardarropa repo;

    public GuardarropaController(){
        this.repo = RepositorioGuardarropa.getInstance();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();

        Usuario usuario = RepositorioUsuario.getInstance().buscarPorId(request.session().attribute("currentUser"));
        List<Guardarropa> guardarropas = usuario.getGuardarropas();
        parametros.put("guardarropas", guardarropas);
        return new ModelAndView(parametros, "guardarropas.hbs");
    }

    public ModelAndView mostrar(Request request, Response response){
        LoginController.ensureUserIsLoggedIn(request, response);
        RepositorioPrenda repoPrendas = RepositorioPrenda.getInstance();
        Usuario usuario = RepositorioUsuario.getInstance().buscarPorId(request.session().attribute("currentUser"));
        Guardarropa guardarropa = usuario.getGuardarropa(Integer.valueOf(request.params(":idguardarropa")));
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("guardarropa", guardarropa);
        parametros.put("prendas", usuario.getPrendasDelguardarropa(Integer.valueOf(request.params(":idguardarropa"))));
        return new ModelAndView(parametros, "prendas.hbs");
    }

    public ModelAndView mostrarAtuendos(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();

        Usuario usuario = RepositorioUsuario.getInstance().buscarPorId(request.session().attribute("currentUser"));
        Guardarropa guardarropa =  repo.buscarPorId(Integer.valueOf(request.params(":idGuardarropa")));
        parametros.put("guardarropa", guardarropa);
        parametros.put("atuendos", guardarropa.getAtuendosSugeridos());
        parametros.put("atuendosRechazados", guardarropa.getAtuendosRechazados());
        return new ModelAndView(parametros, "atuendos_sugeridos.hbs");
    }
    public ModelAndView generarSugerencia(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();

        Usuario usuario = RepositorioUsuario.getInstance().buscarPorId(request.session().attribute("currentUser"));
        Guardarropa guardarropa =  repo.buscarPorId(Integer.valueOf(request.params(":idGuardarropa")));
        parametros.put("guardarropa", guardarropa);
        Atuendo atuendo = usuario.obtenerSugerencia(guardarropa);
        guardarropa.agregarSugerencia(atuendo);
        RepositorioAtuendo.getInstance().agregar(atuendo);
        parametros.put("atuendo", atuendo);
        return new ModelAndView(parametros, "generar_sugerencia.hbs");
    }

    public Response modificar(Request request, Response response){
        Guardarropa guardarropa = this.repo.buscarPorId(Integer.valueOf(request.params("id")));
//        asignarAtributosA(guardarropa, request);
//        this.repo.modificar(guardarropa);
        response.redirect("/guardarropas");
        return response;
    }
    public Response aceptarAtuendo(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Atuendo atuendo =  RepositorioAtuendo.getInstance().buscarPorId(Integer.valueOf(request.params(":idAtuendo")));
        Guardarropa guardarropa = repo.buscarPorId(Integer.valueOf(request.params(":idGuardarropa")));
        atuendo.setRechazado(false);
        repo.modficar(guardarropa);
        response.redirect("/guardarropas/" + guardarropa.getId() + "/atuendos");
        return response;
    }
    public Response rechazarAtuendo(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Atuendo atuendo =  RepositorioAtuendo.getInstance().buscarPorId(Integer.valueOf(request.params(":idAtuendo")));
        Guardarropa guardarropa = repo.buscarPorId(Integer.valueOf(request.params(":idGuardarropa")));
        atuendo.setRechazado(true);
//        guardarropa.getAtuendosSugeridos().remove(atuendo);
//        guardarropa.agregarAtuendoRechazado(atuendo);
        guardarropa.agregarSugerencia(atuendo);
        repo.modficar(guardarropa);
        response.redirect("/guardarropas/" + guardarropa.getId() + "/atuendos");
        return response;
    }

//    private void asignarAtributosA(Guardarropa guardarropa, Request request){
//        if(request.queryParams("telefono") != null){
//            int telefono = Integer.valueOf(request.queryParams("telefono"));
//            guardarropa.setTelefono(telefono);
//        }
//
//        if(request.queryParams("nombre") != null){
//            guardarropa.setNombre(request.queryParams("nombre"));
//        }
//
//        if(request.queryParams("email") != null){
//            guardarropa.setEmail(request.queryParams("email"));
//        }
//
//        if(request.queryParams("nombreDeUsuario") != null){
//            guardarropa.setNombreDeUsuario(request.queryParams("nombreDeUsuario"));
//        }
//
//        if(request.queryParams("apellido") != null){
//            guardarropa.setApellido(request.queryParams("apellido"));
//        }
//
//        if(request.queryParams("legajo") != null){
//            int legajo = Integer.valueOf(request.queryParams("legajo"));
//            guardarropa.setLegajo(legajo);
//        }
//
//        if(request.queryParams("fechaDeNacimiento") != null && !request.queryParams("fechaDeNacimiento").isEmpty()){
//            LocalDate fechaDeNacimiento = LocalDate.parse(request.queryParams("fechaDeNacimiento"));
//            guardarropa.setFechaDeNacimiento(fechaDeNacimiento);
//        }
//
//        if(request.queryParams("rol") != null){
//            RepositorioRol repoRol = FactoryRepositorioRol.get();
//            Rol unRol = repoRol.buscar(Integer.valueOf(request.queryParams("rol")));
//            guardarropa.setRol(unRol);
//        }
//    }

    public ModelAndView crear(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        RepositorioGuardarropa repoGuardarropa = RepositorioGuardarropa.getInstance();

        parametros.put("guardarropas", repoGuardarropa.buscarTodos());
        return new ModelAndView(parametros, "guardarropa.hbs");
    }

    public Response guardar(Request request, Response response){
        Guardarropa guardarropa = new Guardarropa();
//        asignarAtributosA(guardarropa, request);
        this.repo.agregar(guardarropa);
        response.redirect("/guardarropas");
        return response;
    }

    public Response eliminar(Request request, Response response){
        Guardarropa guardarropa = this.repo.buscarPorId(Integer.valueOf(request.params("id")));
        this.repo.eliminar(guardarropa);
        return response;
    }
}
