package domain;

import java.util.ArrayList;
import java.util.List;

import dtoClases.EventoDto;
import models.domain.ApiClima;
import models.domain.CronGenerarSugerencia;
import models.entities.Evento;
import models.domain.GestorDeClima;
import models.domain.GestorSugerencia;
import models.entities.Guardarropa;
import models.entities.Prenda;
import models.entities.Usuario;
import models.entities.EstadosEvento.*;

// esta clase existe porque en los tests no corren los timers.
public class CronTestMain {
	public static void main(String args[]){ 
		List<Prenda> prendas;
		Guardarropa guardarropa;
		prendas = new ArrayList<Prenda>();
		prendas = TestCargaDePrendas.init();
		guardarropa = new Guardarropa("guardarropa",prendas);
		Usuario usuario = new Usuario("usuario",guardarropa);
		GestorSugerencia gestorSugerencia = GestorSugerencia.getInstance();
		GestorDeClima gestor = GestorDeClima.getInstance();
		List<ApiClima> apis= new ArrayList<ApiClima>();
		
		EventoDto eventoDto = new EventoDto();
		eventoDto.repeticionDias = 2000;
		eventoDto.anticipacionHoras = 2;
		eventoDto.fecha = "2019-09-04T00:04:00Z";
		eventoDto.estado = new Pendiente();
		eventoDto.usuario = usuario;
		eventoDto.guardarropa = guardarropa;
		
		Evento evento = new Evento(eventoDto);
		CronGenerarSugerencia cron = CronGenerarSugerencia.getInstance();		
		cron.run();
	}
}
