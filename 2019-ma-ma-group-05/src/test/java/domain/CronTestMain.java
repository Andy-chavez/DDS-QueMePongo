package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import org.junit.Before;

import dtoClases.EventoDto;
import entities.ApiClima;
import entities.CronGenerarSugerencia;
import entities.Evento;
import entities.GestorDeClima;
import entities.GestorSugerencia;
import entities.Guardarropa;
import entities.Prenda;
import entities.Tela;
import entities.Tipo;
import entities.Usuario;
import entities.EstadosEvento.*;
import entities.Telas.Algodon;
import entities.Tipos.Antiparras;
import entities.Tipos.Camisa;
import entities.Tipos.Campera;
import entities.Tipos.Musculosa;
import entities.Tipos.Ojotas;
import entities.Tipos.Remera;
import entities.Tipos.Short;
import entities.Tipos.Sweater;
import entities.Tipos.Zapatillas;

import java.awt.Color;
import java.time.Duration;
import java.time.Instant;

// esta clase existe porque en los tests no corren los timers.
public class CronTestMain {
	public static void main(String args[]){ 
		Guardarropa guardarropa;

		Tipo antiparrasTipo;
		Tipo musculosaTipo;
		Tipo shortsTipo;
		Tipo ojotasTipo;
		Tipo remeraTipo;
		Tipo zapatillasTipo;
		Tipo camisaTipo;
		Tipo sweaterTipo;
		Tipo camperaTipo;

		Prenda antiparras;
		Prenda musculosa;
		Prenda shorts;
		Prenda ojotas;
		Prenda zapatillas;
		Prenda remera;
		Prenda camisa;
		Prenda sweater;
		Prenda campera;
		Prenda antiparras2;
		Prenda musculosa2;
		Prenda shorts2;
		Prenda ojotas2;
		Prenda zapatillas2;
		Prenda remera2;
		Prenda camisa2;
		Prenda sweater2;
		Prenda campera2;
		Usuario usuario;
		List<Prenda> prendas;
		
		GestorDeClima gestor;
		GestorSugerencia gestorSugerencia;
		Tela algodon;
	
		algodon = new Algodon();
		antiparrasTipo = new Antiparras();
		musculosaTipo = new Musculosa();
		shortsTipo = new Short();
		ojotasTipo = new Ojotas();
		remeraTipo = new Remera();
		zapatillasTipo = new Zapatillas();
		camisaTipo = new Camisa();
		sweaterTipo = new Sweater();
		camperaTipo = new Campera();

    
		// Prendas para el test de sugerencias
		remeraTipo.setTela(algodon);
		camisaTipo.setTela(algodon);
		sweaterTipo.setTela(algodon);
		antiparrasTipo.setTela(algodon);
		shortsTipo.setTela(algodon);
		musculosaTipo.setTela(algodon);
		ojotasTipo.setTela(algodon);
		zapatillasTipo.setTela(algodon);
		camperaTipo.setTela(algodon);

		remera = new Prenda(remeraTipo,Color.black,Color.blue);
		camisa = new Prenda(camisaTipo,Color.black,Color.blue);
		sweater = new Prenda(sweaterTipo,Color.black,Color.blue);
		antiparras = new Prenda(antiparrasTipo,Color.black,Color.blue);
		shorts = new Prenda(shortsTipo,Color.black,Color.blue);
		musculosa = new Prenda(musculosaTipo,Color.black,Color.blue);
		ojotas = new Prenda(ojotasTipo,Color.black,Color.blue);
		zapatillas = new Prenda(zapatillasTipo,Color.black,Color.blue);
		campera = new Prenda(camperaTipo,Color.black,Color.blue);

		
		remera2 = new Prenda(remeraTipo,Color.black,Color.blue);
		camisa2 = new Prenda(camisaTipo,Color.black,Color.blue);
		sweater2 = new Prenda(sweaterTipo,Color.black,Color.blue);
		antiparras2 = new Prenda(antiparrasTipo,Color.black,Color.blue);
		shorts2 = new Prenda(shortsTipo,Color.black,Color.blue);
		musculosa2 = new Prenda(musculosaTipo,Color.black,Color.blue);
		ojotas2 = new Prenda(ojotasTipo,Color.black,Color.blue);
		zapatillas2 = new Prenda(zapatillasTipo,Color.black,Color.blue);
		campera2 = new Prenda(camperaTipo,Color.black,Color.blue);

		prendas = new ArrayList<Prenda>();
		prendas.add(antiparras);
		prendas.add(zapatillas);
		prendas.add(musculosa);
		prendas.add(remera);
		prendas.add(camisa);
		prendas.add(sweater);
		prendas.add(campera);
		prendas.add(shorts);
		prendas.add(ojotas);
		prendas.add(antiparras2);
		prendas.add(zapatillas2);
		prendas.add(musculosa2);
		prendas.add(remera2);
		prendas.add(camisa2);
		prendas.add(sweater2);
		prendas.add(campera2);
		prendas.add(shorts2);
		prendas.add(ojotas2);
		guardarropa = new Guardarropa("guardarropa",prendas);
		usuario= new Usuario("usuario",guardarropa);
		gestorSugerencia = GestorSugerencia.getInstance();
		gestor = GestorDeClima.getInstance();
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
