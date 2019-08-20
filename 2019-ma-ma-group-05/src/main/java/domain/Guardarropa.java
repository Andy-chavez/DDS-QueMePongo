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
		BuilderPrenda builderDePrenda = new BuilderPrenda();
		Prenda nuevaPrenda = builderDePrenda.empezarCreacion()
											.setTipoAUtilizar(tipoDeEstaPrenda)
											.setearTelaATipo(unaTela)
											.setColorPrimario(colorPrimario)
											.setColorSecundarioOpcional(colorSecundario)
											.crearPrenda();
		return nuevaPrenda;
	}
	@SuppressWarnings("unused")
	private Prenda crearNuevaPrenda(Tipo tipoDeEstaPrenda, Tela unaTela, Color colorPrimario,Color colorSecundario, String pathToImg){
		BuilderPrenda builderDePrenda = new BuilderPrenda();
		Prenda nuevaPrenda = builderDePrenda.empezarCreacion()
											.setTipoAUtilizar(tipoDeEstaPrenda)
											.setearTelaATipo(unaTela)
											.setColorPrimario(colorPrimario)
											.setColorSecundarioOpcional(colorSecundario)
											.setImagen(pathToImg)
											.crearPrenda();
		return nuevaPrenda;
	}
	
	// elije la prenda que mas se acerque al nivel de abrigo necesario (se usa cuando no hay prendas que queden dentro del rango)
	public Prenda obtenerPrendaQueMasSeAcerque(int diferenciaTemperatura, List<Prenda> prendas){
		//si la diferencia de temperatura es mayor a 10, quiere decir que hay que devolver la prenda que MAS abrigue, si es menor a -10, la MENOS abrigada
		if(diferenciaTemperatura >= 10){
			return prendas.stream().max(Comparator.comparing(p -> p.getNivelAbrigo())).get();
		}
		else{
			return prendas.stream().min(Comparator.comparing(p -> p.getNivelAbrigo())).get();
		}
	}

	// Filtra las prendas que cubran el nivel de temperatura del usuario y elige una al azar. Si no hay ninguna, elige la que mas abrigue
	public Prenda obtenerPrendaParaTemperatura(double temperatura, int sensibilidadFrio, List<Prenda> prendas){
		int variableTemperaturaSarasa = 40;
		int margenAdmitido = 10;
		int nivelAbrigoRequerido = variableTemperaturaSarasa + sensibilidadFrio - (int) temperatura;
		Predicate<Prenda> cubreLoNecesario = p -> Math.abs(nivelAbrigoRequerido - p.getNivelAbrigo()) >= margenAdmitido;
		List<Prenda> prendasConAbrigoOk = prendas.stream().filter(cubreLoNecesario).collect(Collectors.toList());
		Random random = new Random();
		
		for(Prenda p : prendas){
			System.out.println(p.getTipo().getNombre());
		}
		// Si la lista esta vacia, es porque no encontro inguna prenda que cumpla con el nivel de abrigo necesario
		// entonces elige la prenda que mas se acerque
		if(prendasConAbrigoOk.size() == 0){
			System.out.println("holaaaa");
			// TODO: elegir la prenda que mas se acerque, por ahora solo elige una random
			return prendas.get(random.nextInt(prendas.size()));
		}
		// Devuelve una prenda random que cumple con el nivel de abrigo 
		else{
			System.out.println(prendasConAbrigoOk);

			return prendasConAbrigoOk.get(random.nextInt(prendasConAbrigoOk.size()));
		}
	}
	
	public Atuendo obtenerSugerencia(double temperatura, SensibilidadFrio sensibilidadFrio) {
		Predicate<Prenda> esRemera = p -> p.getCapa() == Capa.REMERA;
		Predicate<Prenda> esCamisa = p -> p.getCapa() == Capa.CAMISA;

		List<Prenda> prendasSuperiores = this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.SUPERIOR));
		List<Prenda> remerasOCamisas = prendasSuperiores.stream().filter(esRemera.or(esCamisa)).collect(Collectors.toList());
		List<Prenda> prendasInferiores = this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.INFERIOR));
		List<Prenda> calzados = this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.CALZADO));
		List<Prenda> accesorios = this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.ACCESORIO));

		int intentos = 10;
		Atuendo atuendo;		
		do {
			atuendo = new Atuendo(); // lo inicializo aca para que se borre en caso de que no este bine hecho
			// armado de atuendo basico: remera, pantalon, calzado y capaz un accesorio
			
			agregarPrendaDeCapa(atuendo, remerasOCamisas);
			agregarPrendaDeCapa(atuendo, prendasInferiores);
			agregarPrendaDeCapa(atuendo, calzados);
			agregarPrendaDeCapaMaybe(atuendo, accesorios);	
			
			int capasMaximas = 3;
			while(atuendo.bienAbrigado(temperatura) == -1 && capasMaximas > 0) { // mientras que el atuendo no cubra el nivel de abrigo necesario
				agregarPrendaDeCapa(atuendo, prendasSuperiores);
				capasMaximas--;
			}
			intentos--;
		} while(atuendo.bienAbrigado(temperatura) != 0 && !atuendoNoRechazado(atuendo) && intentos > 0);
		
		return atuendo;
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

}
