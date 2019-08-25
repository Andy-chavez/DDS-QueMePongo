package domain;
import java.util.Comparator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import domain.Atuendo;
import domain.Prenda;

public class Guardarropa {
	private String nombre;
	private List<Prenda> prendas;
	private List<Atuendo> atuendosSugeridos;

	public Guardarropa(String unNombre, List<Prenda> unasPrendas) {
		this.nombre = unNombre;
		this.prendas = new ArrayList<Prenda>();
		this.atuendosSugeridos = new ArrayList<Atuendo>();
		this.agregarPrendas(unasPrendas);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}

	public List<Prenda> getPrendas() {
		return this.prendas;
	}

	public void agregarPrenda(Prenda prenda) {
		this.prendas.add(prenda);
	}

	public void agregarPrendas(List<Prenda> unasPrendas) {
		this.prendas.addAll(unasPrendas);
	}

	public int cantidadDePrendas() {
		return this.prendas.size();
	}

	public List<Prenda> filtrarPrendasSegunCondicion(Predicate<Prenda> predicado) {
		return this.prendas.stream().filter(predicado).collect(Collectors.toList());
	}

	public Predicate<Prenda> esDeCategoria(Categoria unaCategoria) {
		return prenda -> prenda.getTipo().getCategoria() == unaCategoria;
	}

	private void agregarPrendaDeCapa(Atuendo atuendo, List<Prenda> prendas) {
		Random random = new Random();
		atuendo.agregarPrenda(prendas.get(random.nextInt(prendas.size())));
	}
	
	private void agregarPrendaDeCapaMaybe(Atuendo atuendo, List<Prenda> prendas) {
		Random random = new Random();
		if(random.nextDouble() > 0.5) {
			agregarPrendaDeCapa(atuendo, prendas);
		}

	}
	
	public void agregarSugerencia(Atuendo atuendo) {
		this.atuendosSugeridos.add(atuendo);
	}
	
	public void eliminarAtuendoSugerido(Atuendo atuendo) {
		for (Atuendo atuendoYaSugerido : this.atuendosSugeridos) {
			if(atuendo.compararConOtroAtuendo(atuendoYaSugerido)) {
				this.atuendosSugeridos.remove(atuendo);
			}
		}
	}

	@SuppressWarnings("unused")
	private Prenda crearNuevaPrenda(Tipo tipoDeEstaPrenda, Tela unaTela, Color colorPrimario,Color colorSecundario){
		tipoDeEstaPrenda.establecerTela(unaTela);
		Prenda nuevaPrenda = new Prenda(tipoDeEstaPrenda,colorPrimario,colorSecundario);
		return nuevaPrenda;
	}
	@SuppressWarnings("unused")
	private Prenda crearNuevaPrenda(Tipo tipoDeEstaPrenda, Tela unaTela, Color colorPrimario,Color colorSecundario, String pathToImg){
		tipoDeEstaPrenda.establecerTela(unaTela);
		Prenda nuevaPrenda = new Prenda(tipoDeEstaPrenda,colorPrimario,colorSecundario);
		nuevaPrenda.setImage(pathToImg);
		return nuevaPrenda;
	}
	
	// elije la prenda que mas se acerque al nivel de abrigo necesario (se usa cuando no hay prendas que queden dentro del rango)
	public Prenda obtenerPrendaQueMasSeAcerque(int nivelAbrigoRequerido, List<Prenda> prendas){
		//si la diferencia de temperatura es mayor a 10, quiere decir que hay que devolver la prenda que MAS abrigue, si es menor a -10, la MENOS abrigada
		int diferenciaTemperatura = 0;
		if(diferenciaTemperatura >= 10){
			return prendas.stream().max(Comparator.comparing(p -> p.getNivelAbrigo())).get();
		}
		else{
			return prendas.stream().min(Comparator.comparing(p -> p.getNivelAbrigo())).get();
		}
	}

	// checkea que el atuendo tenga el nivel de temperatura adecuado y que no haya sido rechazado previamente
	public boolean atuendoNoRechazado(Atuendo atuendo) {
		for (Atuendo atuendoYaSugerido : this.atuendosSugeridos) {
			if(atuendo.compararConOtroAtuendo(atuendoYaSugerido)) {
				System.out.println("este atuendo ya fue sugerido, obteniendo otro");
				return false;
			}
		}
		return true;
	}
	
	public Boolean tieneLaPrenda(Prenda unaPrenda) {
		return this.prendas.stream().anyMatch(prenda -> prenda.esIgualA(unaPrenda));
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
	
	
	
	public Atuendo obtenerSugerencia(double temperatura, SensibilidadFrio sensibilidadFrio) {
		int variableTemperaturaSarasa = 40;
		int nivelAbrigoRequerido = variableTemperaturaSarasa - (int) temperatura;

		Predicate<Prenda> esRemera = p -> p.getCapa() == Capa.REMERA;
		Predicate<Prenda> esCamisa = p -> p.getCapa() == Capa.CAMISA;

		List<Prenda> prendasSuperiores = this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.SUPERIOR));
		List<Prenda> remerasOCamisas = prendasSuperiores.stream().filter(esRemera.or(esCamisa)).collect(Collectors.toList());
		List<Prenda> prendasInferiores = this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.INFERIOR));
		List<Prenda> calzados = this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.CALZADO));
		List<Prenda> accesorios = this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.ACCESORIO));
		
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
