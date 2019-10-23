package models.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import models.entities.Categorias.*;

public class GestorSugerencia {
	private List<Categoria> categorias;
	private GestorDeClima gestorDeClima;
	
	// lo hago singleton
	private GestorSugerencia(){
		this.gestorDeClima = GestorDeClima.getInstance();
		this.categorias = new ArrayList<Categoria>();
		this.categorias.add(new SuperiorBase());
		this.categorias.add(new SuperiorExtra());
		this.categorias.add(new Inferior());
		this.categorias.add(new Calzado());
		this.categorias.add(new Accesorio());
		
	}
	private static GestorSugerencia singleInstance = null;
	public static GestorSugerencia getInstance(){
		if(singleInstance == null){
			singleInstance = new GestorSugerencia();
		}
		return singleInstance;
	}

	public Atuendo crearAtuendoConMolde(List<Prenda> prendas, MoldeAtuendo moldeAtuendo, Usuario u){
		List <Prenda> prendasElegidas = new ArrayList<Prenda>();
		for(Tipo tipo : moldeAtuendo.getMoldeTipos()){
			List<Prenda> prendasDeTipo = prendas.stream().filter(p -> p.esDeTipo(tipo)).collect(Collectors.toList());
			Random random = new Random();
			prendasElegidas.add(prendasDeTipo.get(random.nextInt(prendasDeTipo.size())));
		}
		Atuendo atuendo = new Atuendo(moldeAtuendo.getNivelAbrigo(),u);//, moldeAtuendo.getSensibilidadFrio());
		atuendo.agregarPrendas(prendasElegidas);
		atuendo.setNivelAbrigo(moldeAtuendo.getNivelAbrigo());
		return atuendo;
	}
	
	public MoldeAtuendo buscarMoldeParaNivelAbrigo(Guardarropa g, int nivelAbrigoRequerido){
		int margenAdmitido = 5;
		for(MoldeAtuendo moldeAtuendo : g.getMoldesAtuendos()){
			if(Math.abs(moldeAtuendo.getNivelAbrigo() - nivelAbrigoRequerido) <= margenAdmitido){
				System.out.println("Nivel abrigo del molde: " + moldeAtuendo.getNivelAbrigo());
				return moldeAtuendo;
			}
		}
		return null;
	}
	
	
	// hago este metodo aparte para poder probar con una temperatura especifica
	public Atuendo obtenerSugerencia(Instant fecha, Guardarropa g, Usuario u) {
		int variableTemperaturaSarasa = 40;
		double temperatura = this.gestorDeClima.getTemperaturaActual();
		int nivelAbrigoRequerido = variableTemperaturaSarasa - (int) temperatura;
		
		// se fija si ya hay un molde hecho, y lo rellena con otras prendas
		MoldeAtuendo moldeAtuendo = buscarMoldeParaNivelAbrigo(g, nivelAbrigoRequerido);
		List<Prenda> prendasLibres = g.getPrendas().stream().filter(p -> !p.estaReservada(fecha)).collect(Collectors.toList());
		if(moldeAtuendo != null){
			Atuendo atuendo = crearAtuendoConMolde(prendasLibres, moldeAtuendo, u);
			g.agregarSugerencia(atuendo);
			return atuendo;
		}
		
		Atuendo atuendo = new Atuendo(nivelAbrigoRequerido, u);//, sensibilidadFrio);	
		this.categorias.forEach(c -> c.agregarPrendas(atuendo, prendasLibres, nivelAbrigoRequerido));
		g.agregarSugerencia(atuendo);
		
		moldeAtuendo = new MoldeAtuendo(atuendo);
		g.agregarMoldeAtuendo(moldeAtuendo);
		
		return atuendo;
	}
}
