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
        Map<String, Object> parametros = new HashMap<>();

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
        List<Evento> eventos = this.repo.buscarTodos();

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

}
