package domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import domain.Categorias.*;

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

	public Atuendo crearAtuendoConMolde(Guardarropa g, MoldeAtuendo moldeAtuendo){
		List <Prenda> prendasElegidas = new ArrayList<Prenda>();
		for(Tipo tipo : moldeAtuendo.getMoldeTipos()){
			List<Prenda> prendasDeTipo = g.getPrendas().stream().filter(p -> p.esDeTipo(tipo)).collect(Collectors.toList());
			Random random = new Random();
			prendasElegidas.add(prendasDeTipo.get(random.nextInt(prendasDeTipo.size())));
		}
		Atuendo atuendo = new Atuendo(moldeAtuendo.getNivelAbrigo(), moldeAtuendo.getSensibilidadFrio());
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
	
	public Atuendo obtenerSugerencia(Instant fecha, Guardarropa g, SensibilidadFrio sensibilidadFrio) {
		double temperatura = this.gestorDeClima.getTemperaturaActual();
		return obtenerSugerenciaParaTemperatura(temperatura, g, sensibilidadFrio);
	}
	
	// hago este metodo aparte para poder probar con una temperatura especifica
	public Atuendo obtenerSugerenciaParaTemperatura(double temperatura, Guardarropa g, SensibilidadFrio sensibilidadFrio) {
		int variableTemperaturaSarasa = 40;
		int nivelAbrigoRequerido = variableTemperaturaSarasa - (int) temperatura;
		
		// se fija si ya hay un molde hecho, y lo rellena con otras prendas
		MoldeAtuendo moldeAtuendo = buscarMoldeParaNivelAbrigo(g, nivelAbrigoRequerido);
		if(moldeAtuendo != null){
			Atuendo atuendo = crearAtuendoConMolde(g, moldeAtuendo);
			g.agregarSugerencia(atuendo);
			return atuendo;
		}
		
		Atuendo atuendo = new Atuendo(nivelAbrigoRequerido, sensibilidadFrio);	
		this.categorias.forEach(c -> c.agregarPrendas(atuendo, g.getPrendas(), nivelAbrigoRequerido));
		g.agregarSugerencia(atuendo);
		
		moldeAtuendo = new MoldeAtuendo(atuendo);
		g.agregarMoldeAtuendo(moldeAtuendo);
		
		return atuendo;
	}
}
