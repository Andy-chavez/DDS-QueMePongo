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

    public Response guardarEvento(Request request, Response response) {
        Evento evento = new Evento();
        if(request.queryParams("nombre") != null){
            evento.setNombre(request.queryParams("nombre"));
        }

        if(request.queryParams("tipo") != null){
            evento.setTipo(request.queryParams("tipo"));
        }

        if(request.queryParams("lugar") != null){
            evento.setLugar(request.queryParams("lugar"));
        }

        if((request.queryParams("fecha") != null) && (request.queryParams("hora") != null)){
            evento.setFecha(request.queryParams("fecha")+request.queryParams("hora"));
        }
        else if((request.queryParams("fecha") != null) && (request.queryParams("hora") == null)){
            LocalDate fecha = LocalDate.parse(request.queryParams("fecha"));
            Instant instant = fecha.atStartOfDay(ZoneId.systemDefault()).toInstant();
            evento.setFecha(instant);
        }
        if(request.queryParams("guardarropa") != null){
            Guardarropa g = RepositorioGuardarropa.getInstance().buscarPorId(new Integer(request.queryParams("guardarropa")));
            evento.setGuardarropa(g);
        }
        this.repo.agregar(evento);
        response.redirect("/eventos");
        return response;
    }
}
