package controllers;

import models.entities.Guardarropa;
import models.entities.Prenda;
import models.repositorios.RepositorioGuardarropa;
import models.repositorios.RepositorioPrenda;
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

        Map<String, Object> parametros = new HashMap<>();
        Guardarropa g = RepositorioGuardarropa.getInstance().buscarPorId(new Integer(request.params("idGuardarropa")));
        List<Prenda> prendas = g.getPrendas();
        parametros.put("prendas", prendas);
        return new ModelAndView(parametros, "prendas.hbs");
    }

    public Response eliminar(Request request, Response response){
        this.repo.eliminar(this.repo.buscarPorId(new Integer(request.params(":idPrenda"))));
        return response;
    }
/*

    private void asignarAtributosA(Usuario usuario, Request request){
        if(request.queryParams("telefono") != null){
            int telefono = new Integer(request.queryParams("telefono"));
            usuario.setTelefono(telefono);
        }

        if(request.queryParams("nombre") != null){
            usuario.setNombre(request.queryParams("nombre"));
        }

        if(request.queryParams("email") != null){
            usuario.setEmail(request.queryParams("email"));
        }

        if(request.queryParams("nombreDeUsuario") != null){
            usuario.setNombreDeUsuario(request.queryParams("nombreDeUsuario"));
        }

        if(request.queryParams("apellido") != null){
            usuario.setApellido(request.queryParams("apellido"));
        }

        if(request.queryParams("legajo") != null){
            int legajo = new Integer(request.queryParams("legajo"));
            usuario.setLegajo(legajo);
        }

        if(request.queryParams("fechaDeNacimiento") != null && !request.queryParams("fechaDeNacimiento").isEmpty()){
            LocalDate fechaDeNacimiento = LocalDate.parse(request.queryParams("fechaDeNacimiento"));
            usuario.setFechaDeNacimiento(fechaDeNacimiento);
        }

        if(request.queryParams("rol") != null){
            RepositorioRol repoRol = FactoryRepositorioRol.get();
            Rol unRol = repoRol.buscar(new Integer(request.queryParams("rol")));
            usuario.setRol(unRol);
        }
    }

    public ModelAndView crear(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        RepositorioRol repoRol = FactoryRepositorioRol.get();

        parametros.put("roles", repoRol.buscarTodos());
        return new ModelAndView(parametros, "usuario.hbs");
    }

    public Response guardar(Request request, Response response){
        Usuario usuario = new Usuario();
        asignarAtributosA(usuario, request);
        this.repo.agregar(usuario);
        response.redirect("/usuarios");
        return response;
    }
*/

}
