package controllers;
import dtoClases.EventoDto;
import models.entities.*;
import models.entities.EstadosEvento.Inactivo;
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
//        List<Evento> eventos = new ArrayList<Evento>();
//        EventoDto eventoDto = new EventoDto();
//        eventoDto.fecha = Instant.now().toString();
//        eventoDto.nombre = "fiesta";
//        eventoDto.estado = new Inactivo();
//        eventoDto.repeticionDias = 2;
//        eventoDto.repetir = false;
//        eventoDto.lugar = "campus";
//        eventoDto.tipo = "deportivo";
//        eventos.add(new Evento(eventoDto));
//        eventoDto.fecha = Instant.now().plus(Duration.ofDays(2)).toString();
//        eventos.add(new Evento(eventoDto));
//        eventoDto.fecha = Instant.now().plus(Duration.ofDays(30)).toString();
//        eventos.add(new Evento(eventoDto));
//        parametros.put("eventos", eventos);

        return new ModelAndView(parametros, "eventos.hbs");
    }

    public ModelAndView mostrar(Request request, Response response){
//        EventoDto eventoDto = new EventoDto();
//        eventoDto.fecha = Instant.now().toString();
//        eventoDto.nombre = "fiesta";
//        eventoDto.estado = new Inactivo();
//        eventoDto.repeticionDias = 2;
//        eventoDto.repetir = false;
//        eventoDto.lugar = "campus";
//        eventoDto.tipo = "deportivo";
//        Evento evento = new Evento(eventoDto);

        Evento evento = this.repo.buscarPorId(Integer.parseInt(request.params("id")));
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("evento", evento);
        return new ModelAndView(parametros, "evento.hbs");
    }

    public ModelAndView crearEvento(Request request, Response response){
        LoginController.ensureUserIsLoggedIn(request, response);
        return new ModelAndView(null, "crearEvento.hbs");
    }

    private String parseFecha(String fecha, String hora){
        String instantString =  fecha + "T" + hora + ":00Z";
        instantString = instantString.replaceAll("/", "-");
        return instantString;
    }
    public Response guardarEvento(Request request, Response response) {
        LoginController.ensureUserIsLoggedIn(request, response);
        Evento evento = new Evento();
        evento.setNombre(request.queryParams("nombre"));
        evento.setTipo(request.queryParams("tipo"));
        evento.setLugar(request.queryParams("lugar"));
        String fecha = parseFecha(request.queryParams("fecha"), request.queryParams("hora"));
        evento.setFecha(fecha); // tiene que tener este formato: "2019-09-04T10:15:30Z";
        Guardarropa g = RepositorioGuardarropa.getInstance().buscarPorId(new Integer(request.queryParams("guardarropa")));
        evento.setGuardarropa(g);
        this.repo.agregar(evento);
        response.redirect("/eventos");
        return response;
    }
}
