package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ObtenerSugerencia {
	// checkea que el atuendo tenga el nivel de temperatura adecuado y que no haya sido rechazado previamente
	public List<Prenda> filtrarPrendasSegunCondicion(List<Prenda> prendas, Predicate<Prenda> predicado) {
		return prendas.stream().filter(predicado).collect(Collectors.toList());
	}

	public Predicate<Prenda> esDeCategoria(Categoria unaCategoria) {
		return prenda -> prenda.getTipo().getCategoria() == unaCategoria;
	}
	
	public Predicate<Prenda> esDeTipo(Tipo unTipo) {
		return prenda -> prenda.getTipo() == unTipo;
	}

	
	public boolean atuendoNoRechazado(Guardarropa g, Atuendo atuendo) {
		for (Atuendo atuendoYaSugerido : g.getAtuendosSugeridos()) {
			if(atuendo.compararConOtroAtuendo(atuendoYaSugerido)) {
				return false;
			}
		}
		return true;
	}
	
	
	// Filtra las prendas que cubran el nivel de temperatura del usuario y elige una al azar. Si no hay ninguna, elige la que mas abrigue
	public Prenda obtenerPrendaParaNivelAbrigo(int nivelAbrigoRequerido, List<Prenda> prendas){
		if(prendas.size() == 0) { return null; }

		int margenAdmitido = 5;		
		List<Prenda> prendasConAbrigoOk = new ArrayList<Prenda>();
		
		// si la lista que me queda al filtrar es 0, agrando el margen y pruebo de nuevo, hasta que tenga al menos 1 prenda.
		do{
			int margenAdmitidoCopy = margenAdmitido; // tengo que copiar el int porque sino se queja por alguna razon el predicate de abajo :/
			Predicate<Prenda> cubreLoNecesario = p -> Math.abs(nivelAbrigoRequerido - p.getNivelAbrigo()) <= margenAdmitidoCopy;
			// todo falta que luego de elegir la primer prenda, filtre esa capa fuera de la lista asi no agrega ds veces la misma prenda
			prendasConAbrigoOk =  prendas.stream().filter(cubreLoNecesario).collect(Collectors.toList());
			margenAdmitido *= 1.5;
		}while(prendasConAbrigoOk.size() == 0);
		
		Random random = new Random();
		
		return prendasConAbrigoOk.get(random.nextInt(prendasConAbrigoOk.size()));
	}
	

	public List<Prenda> obtenerCapasParaNivelAbrigo(int nivelAbrigoRequerido, List<Prenda> prendas){		
		List<Prenda> capasSuperiores = new ArrayList<Prenda>();
		int nivelAbrigoFaltante = nivelAbrigoRequerido;
		int margenAdmitido = 5;
			
		while(nivelAbrigoFaltante > margenAdmitido){
			Prenda capa = obtenerPrendaParaNivelAbrigo(nivelAbrigoFaltante, prendas);
			nivelAbrigoFaltante -= capa.getNivelAbrigo();
			capasSuperiores.add(capa);
		}
		return capasSuperiores;
	}
	
	public Atuendo crearAtuendoConMolde(Guardarropa g, MoldeAtuendo moldeAtuendo){
		List <Prenda> prendasElegidas = new ArrayList<Prenda>();
		for(Tipo tipo : moldeAtuendo.getMoldeTipos()){
			List<Prenda> prendasDeTipo = filtrarPrendasSegunCondicion(g.getPrendas(), esDeTipo(tipo));

			Random random = new Random();
			prendasElegidas.add(prendasDeTipo.get(random.nextInt(prendasDeTipo.size())));
		}
		Atuendo atuendo = new Atuendo();
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
	
	public Atuendo obtenerSugerencia(Guardarropa g, double temperatura, SensibilidadFrio sensibilidadFrio) {
		int variableTemperaturaSarasa = 40;
		int nivelAbrigoRequerido = variableTemperaturaSarasa - (int) temperatura;
		
		// se fija si ya hay un molde hecho, y lo rellena con otras prendas
		MoldeAtuendo moldeAtuendo = buscarMoldeParaNivelAbrigo(g, nivelAbrigoRequerido);
		if(moldeAtuendo != null){
			Atuendo atuendo = crearAtuendoConMolde(g, moldeAtuendo);
			g.agregarSugerencia(atuendo);
			return atuendo;
		}
		
		Atuendo atuendo = new Atuendo();
		
		Predicate<Prenda> esRemeraOCamisa = p -> p.getCapa() == Capa.REMERA || p.getCapa() == Capa.CAMISA;

		List<Prenda> prendasSuperiores = filtrarPrendasSegunCondicion(g.getPrendas(), esDeCategoria(Categoria.SUPERIOR));
		List<Prenda> remerasOCamisas = filtrarPrendasSegunCondicion(prendasSuperiores, esRemeraOCamisa);
//		List<Prenda> remerasOCamisas = prendasSuperiores.stream().filter(esRemera.or(esCamisa)).collect(Collectors.toList());
		List<Prenda> prendasInferiores = filtrarPrendasSegunCondicion(g.getPrendas(), esDeCategoria(Categoria.INFERIOR));
		List<Prenda> calzados = filtrarPrendasSegunCondicion(g.getPrendas(), esDeCategoria(Categoria.CALZADO));
		List<Prenda> accesorios = filtrarPrendasSegunCondicion(g.getPrendas(), esDeCategoria(Categoria.ACCESORIO));
		
		
		Prenda top = obtenerPrendaParaNivelAbrigo(nivelAbrigoRequerido + sensibilidadFrio.getSuperior(), remerasOCamisas);
		Prenda bot = obtenerPrendaParaNivelAbrigo(nivelAbrigoRequerido + sensibilidadFrio.getInferior(), prendasInferiores);
		Prenda calzado = obtenerPrendaParaNivelAbrigo(nivelAbrigoRequerido, calzados);
		Prenda accesorio = obtenerPrendaParaNivelAbrigo(nivelAbrigoRequerido, accesorios);
		List<Prenda> capasTop = obtenerCapasParaNivelAbrigo(nivelAbrigoRequerido - top.getNivelAbrigo() + sensibilidadFrio.getSuperior(), prendasSuperiores);

		atuendo.agregarPrenda(top);
		atuendo.agregarPrenda(bot);
		atuendo.agregarPrenda(calzado);
		atuendo.agregarPrenda(accesorio);
		atuendo.agregarPrendas(capasTop);
		
		atuendo.setNivelAbrigo(nivelAbrigoRequerido);
		g.agregarSugerencia(atuendo);
		
		moldeAtuendo = new MoldeAtuendo(atuendo);
		g.agregarMoldeAtuendo(moldeAtuendo);
		
		return atuendo;
	}
}
