package controllers;
import dtoClases.EventoDto;
import models.entities.*;
import models.entities.EstadosEvento.Inactivo;
import models.entities.EstadosEvento.Pendiente;
import models.repositorios.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventoController {
    private RepositorioEvento repo;

    public EventoController(){
        this.repo = RepositorioEvento.getInstance();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        Usuario usuario = RepositorioUsuario.getInstance().buscarPorId(request.session().attribute("currentUser"));
        List<Evento> eventos = usuario.getEventos();
        parametros.put("eventos", eventos);
        return new ModelAndView(parametros, "eventos.hbs");
    }

    public ModelAndView mostrar(Request request, Response response){
//        LoginController.ensureUserIsLoggedIn(request, response);
        Usuario usuario = RepositorioUsuario.getInstance().buscarPorId(1);
        Evento evento = repo.buscarPorId(Integer.valueOf(request.params(":idEvento")));
        Guardarropa g = evento.getGuardarropa();
        Map<String, Object> parametros = new HashMap<>();

        parametros.put("atuendo", evento.getAtuendo());
        parametros.put("atuendos", evento.getAtuendosSugeridos());
        parametros.put("evento", evento);
        return new ModelAndView(parametros, "evento.hbs");
    }

    public ModelAndView crearEvento(Request request, Response response){
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> parametros = new HashMap<>();
        Usuario usuario = RepositorioUsuario.getInstance().buscarPorId(request.session().attribute("currentUser"));
        List<Guardarropa> guardarropas = usuario.getGuardarropas();
        List<String> tipos = new ArrayList<String>();
        parametros.put("tipos", tipos);
        parametros.put("guardarropas", guardarropas);
        return new ModelAndView(parametros, "crearEvento.hbs");
    }

    // ni miren esta funcion, es horrible
    private String parseFecha(String fecha, String hora){
        String[] splittedFecha= fecha.split("/");

        String instantString =  splittedFecha[2] + "-" + splittedFecha[0] + "-" + splittedFecha[1]  + "T" + hora + ":00Z";
        return instantString;
    }
    public Response guardarEvento(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Usuario usuario = RepositorioUsuario.getInstance().buscarPorId(request.session().attribute("currentUser"));
        EventoDto eventoDto = new EventoDto();
        eventoDto.usuario = usuario;
        eventoDto.nombre = request.queryParams("nombre");
        eventoDto.lugar = request.queryParams("lugar");
        eventoDto.fecha = parseFecha(request.queryParams("fecha"), request.queryParams("hora"));
        eventoDto.tipo = request.queryParams("tipo");
        Guardarropa guardarropa =RepositorioGuardarropa.getInstance().buscarPorId(Integer.valueOf(request.queryParams("guardarropa")));
        eventoDto.guardarropa = guardarropa;
        eventoDto.repeticionDias = Integer.valueOf(request.queryParams("repeticionDias"));
        eventoDto.anticipacionHoras = Integer.valueOf(request.queryParams("anticipacionHoras"));
        eventoDto.estado = new Pendiente();
        eventoDto.repetir = Integer.valueOf(request.queryParams("repeticionDias")) != 0;

        Evento evento = new Evento(eventoDto);
        evento.confirmarEvento();

        Atuendo atuendo = usuario.obtenerSugerencia(guardarropa);
        evento.addAtuendoSugerido(atuendo);

        this.repo.agregar(evento);
        response.redirect("/eventos");
        return response;
    }
    public Response aceptarAtuendo(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Atuendo atuendo =  RepositorioAtuendo.getInstance().buscarPorId(Integer.valueOf(request.params(":idAtuendo")));
        Evento evento =  repo.buscarPorId(Integer.valueOf(request.params(":idEvento")));
        evento.setAtuendo(atuendo);
        this.repo.modficar(evento);
        return response;
    }
    public Response rechazarAtuendo(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Atuendo atuendo =  RepositorioAtuendo.getInstance().buscarPorId(Integer.valueOf(request.params(":idAtuendo")));
        Evento evento =  repo.buscarPorId(Integer.valueOf(request.params(":idEvento")));
        atuendo.setRechazado(true);
        RepositorioAtuendo.getInstance().modficar(atuendo);
        Atuendo nuevoAtuendo = evento.getGestorSugerencia().obtenerSugerencia(evento.getFecha(), evento.getGuardarropa(), evento.getUsuario());
        evento.addAtuendoSugerido(nuevoAtuendo);
        repo.modficar(evento);
        response.redirect("/eventos/" + evento.getId());
        return response;
    }
}
