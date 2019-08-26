package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ObtenerSugerencia {
	// checkea que el atuendo tenga el nivel de temperatura adecuado y que no haya sido rechazado previamente
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
	
	
	public Atuendo obtenerSugerencia(Guardarropa g, double temperatura, SensibilidadFrio sensibilidadFrio) {
		int variableTemperaturaSarasa = 40;
		int nivelAbrigoRequerido = variableTemperaturaSarasa - (int) temperatura;

		Predicate<Prenda> esRemera = p -> p.getCapa() == Capa.REMERA;
		Predicate<Prenda> esCamisa = p -> p.getCapa() == Capa.CAMISA;

		List<Prenda> prendasSuperiores = g.filtrarPrendasSegunCondicion(g.esDeCategoria(Categoria.SUPERIOR));
		List<Prenda> remerasOCamisas = prendasSuperiores.stream().filter(esRemera.or(esCamisa)).collect(Collectors.toList());
		List<Prenda> prendasInferiores = g.filtrarPrendasSegunCondicion(g.esDeCategoria(Categoria.INFERIOR));
		List<Prenda> calzados = g.filtrarPrendasSegunCondicion(g.esDeCategoria(Categoria.CALZADO));
		List<Prenda> accesorios = g.filtrarPrendasSegunCondicion(g.esDeCategoria(Categoria.ACCESORIO));
		
		for(Prenda p : prendasSuperiores){
			System.out.println(p.getTipo().getNombre());
		}
		
		Atuendo atuendo = new Atuendo();
		
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
		return atuendo;
	}
}
