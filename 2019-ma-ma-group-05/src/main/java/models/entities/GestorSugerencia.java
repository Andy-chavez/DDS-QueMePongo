package models.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import models.entities.Categorias.*;
import models.repositorios.DAOs.DAOMoldeAtuendo;
import models.repositorios.RepositorioMolde;

public class GestorSugerencia {
	private List<Categoria> categorias;
	private GestorDeClima gestorDeClima;
	private List<MoldeAtuendo> moldesAtuendos;
	// lo hago singleton
	private GestorSugerencia(){
		this.gestorDeClima = GestorDeClima.getInstance();
		this.categorias = new ArrayList<Categoria>();
		this.categorias.add(new SuperiorBase());
		this.categorias.add(new SuperiorExtra());
		this.categorias.add(new Inferior());
		this.categorias.add(new Calzado());
		this.categorias.add(new Accesorio());
		this.moldesAtuendos = new ArrayList<MoldeAtuendo>();
	}
	private static GestorSugerencia singleInstance = null;
	public static GestorSugerencia getInstance(){
		if(singleInstance == null){
			singleInstance = new GestorSugerencia();
		}
		return singleInstance;
	}
	public void agregarMoldeAtuendo(MoldeAtuendo moldeAtuendo){ this.moldesAtuendos.add(moldeAtuendo); }

	public Atuendo crearAtuendoConMolde(List<Prenda> prendas, MoldeAtuendo moldeAtuendo, Usuario u){
		List <Prenda> prendasElegidas = new ArrayList<Prenda>();
		for(Tipo tipo : moldeAtuendo.getMoldeTipos()){
			List<Prenda> prendasDeTipo = prendas.stream().filter(p -> p.esDeTipo(tipo)).collect(Collectors.toList());
			Random random = new Random();
			prendasElegidas.add(prendasDeTipo.get(random.nextInt(prendasDeTipo.size())));
		}
		Atuendo atuendo = new Atuendo(u);
		atuendo.agregarPrendas(prendasElegidas);
		return atuendo;
	}
	

	public MoldeAtuendo buscarMoldeParaNivelAbrigo(SensibilidadFrio sf, int nivelAbrigoRequerido){
		for(MoldeAtuendo moldeAtuendo : this.moldesAtuendos){
			if(moldeAtuendo.moldeAbrigaLoSuficiente(sf, nivelAbrigoRequerido)) return moldeAtuendo;
	//public MoldeAtuendo buscarMoldeParaNivelAbrigo(Guardarropa g, int nivelAbrigoRequerido){
	//	int margenAdmitido = 5;
	//	for(MoldeAtuendo moldeAtuendo : RepositorioMolde.getInstance(new DAOMoldeAtuendo()).obtenerMoldes()){ 
  //		if(Math.abs(moldeAtuendo.getNivelAbrigo() - nivelAbrigoRequerido) <= margenAdmitido){
	//			System.out.println("Nivel abrigo del molde: " + moldeAtuendo.getNivelAbrigo());
	//			return moldeAtuendo;
	//		}
		}
		return null;
	}

	public void agregarPrendasSegunCategoria(Atuendo atuendo, List<Prenda> prendasLibres, int nivelAbrigoRequerido){
		this.categorias.forEach(c -> c.agregarPrendas(atuendo, prendasLibres, nivelAbrigoRequerido));
	}
	
	// hago este metodo aparte para poder probar con una temperatura especifica
	public Atuendo obtenerSugerencia(Instant fecha, Guardarropa g, Usuario u) {
		int variableTemperaturaSarasa = 40;
		double temperatura = this.gestorDeClima.getTemperaturaActual();
		int nivelAbrigoRequerido = variableTemperaturaSarasa - (int) temperatura;
		
		// se fija si ya hay un molde hecho, y lo rellena con otras prendas
		MoldeAtuendo moldeAtuendo = buscarMoldeParaNivelAbrigo(u.getSensibilidadFrio(), nivelAbrigoRequerido);
		List<Prenda> prendasLibres = g.getPrendas().stream().filter(p -> !p.estaReservada(fecha)).collect(Collectors.toList());
		if(moldeAtuendo != null){
			Atuendo atuendo = crearAtuendoConMolde(prendasLibres, moldeAtuendo, u);
			g.agregarSugerencia(atuendo);
			return atuendo;
		}
		
		Atuendo atuendo = new Atuendo(u);
		agregarPrendasSegunCategoria(atuendo, prendasLibres, nivelAbrigoRequerido);
		g.agregarSugerencia(atuendo);
		agregarMoldeAtuendo(new MoldeAtuendo(atuendo));

		return atuendo;
	}
}
