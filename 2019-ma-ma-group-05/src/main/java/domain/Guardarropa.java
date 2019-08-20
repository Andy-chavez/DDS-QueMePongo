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
	private Prenda crearNuevaPrenda(FamiliaTipos tipoDeEstaPrenda, Tela unaTela, Color colorPrimario,Color colorSecundario){
		BuilderPrenda builderDePrenda = new BuilderPrenda();
		Prenda nuevaPrenda = builderDePrenda.empezarCreacion()
											.setTipoAUtilizar(tipoDeEstaPrenda)
											.crearTipoConTelaYCategoria(unaTela)
											.setColorPrimario(colorPrimario)
											.setColorSecundarioOpcional(colorSecundario)
											.crearPrenda();
		return nuevaPrenda;
	}
	@SuppressWarnings("unused")
	private Prenda crearNuevaPrenda(FamiliaTipos tipoDeEstaPrenda, Tela unaTela, Color colorPrimario,Color colorSecundario, String pathToImg){
		BuilderPrenda builderDePrenda = new BuilderPrenda();
		Prenda nuevaPrenda = builderDePrenda.empezarCreacion()
											.setTipoAUtilizar(tipoDeEstaPrenda)
											.crearTipoConTelaYCategoria(unaTela)
											.setColorPrimario(colorPrimario)
											.setColorSecundarioOpcional(colorSecundario)
											.setImagen(pathToImg)
											.crearPrenda();
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

	// Filtra las prendas que cubran el nivel de temperatura del usuario y elige una al azar. Si no hay ninguna, elige la que mas abrigue
	public Prenda obtenerPrendaParaTemperatura(double temperatura, int sensibilidadFrio, List<Prenda> prendas){
		int variableTemperaturaSarasa = 40;
		int margenAdmitido = 5;
		int nivelAbrigoRequerido = variableTemperaturaSarasa + sensibilidadFrio - (int) temperatura;
//		System.out.println("Nivel abrigo req = " + nivelAbrigoRequerido);
		
		List<Prenda> prendasConAbrigoOk = new ArrayList<Prenda>();
		// si la lista que me queda al filtrar es 0, agrando el margen y pruebo de nuevo, hasta que tenga al menos 1 prenda.
		do{
			int margenAdmitidoCopy = margenAdmitido;
			Predicate<Prenda> cubreLoNecesario = p -> Math.abs(nivelAbrigoRequerido - p.getNivelAbrigo()) <= margenAdmitidoCopy;
			prendasConAbrigoOk = prendas.stream().filter(cubreLoNecesario).collect(Collectors.toList());
//			System.out.println("Margen admitido = " + margenAdmitidoCopy);
//			System.out.println("Size List prendas: " + prendasConAbrigoOk.size());
			margenAdmitido *= 1.5;
		}while(prendasConAbrigoOk.size() == 0);
		
		Random random = new Random();
		
		// Devuelve una prenda random que cumple con el nivel de abrigo 
//		for(Prenda p : prendasConAbrigoOk){
//			System.out.println(p.getTipo().getNombre() + ", " + (nivelAbrigoRequerido - p.getNivelAbrigo()));
//		}
		return prendasConAbrigoOk.get(random.nextInt(prendasConAbrigoOk.size()));
	}
	
	public List<Prenda> obtenerCapasParaTemperatura(double temperatura, int sensibilidadFrio, List<Prenda> prendas){
		
		List<Prenda> capasSuperiores = new ArrayList<Prenda>();
		
		Prenda capa = obtenerPrendaParaTemperatura(temperatura, sensibilidadFrio, prendas);

		return capasSuperiores;
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
//		Atuendo atuendo;		
//		do {
//			atuendo = new Atuendo(); // lo inicializo aca para que se borre en caso de que no este bine hecho
//			// armado de atuendo basico: remera, pantalon, calzado y capaz un accesorio
//			
//			agregarPrendaDeCapa(atuendo, remerasOCamisas);
//			agregarPrendaDeCapa(atuendo, prendasInferiores);
//			agregarPrendaDeCapa(atuendo, calzados);
//			agregarPrendaDeCapaMaybe(atuendo, accesorios);	
//			
//			int capasMaximas = 3;
//			while(atuendo.bienAbrigado(temperatura) == -1 && capasMaximas > 0) { // mientras que el atuendo no cubra el nivel de abrigo necesario
//				agregarPrendaDeCapa(atuendo, prendasSuperiores);
//				capasMaximas--;
//			}
//			intentos--;
//		} while(atuendo.bienAbrigado(temperatura) != 0 && !atuendoNoRechazado(atuendo) && intentos > 0);
//		
		Atuendo atuendo = new Atuendo();
		
		Prenda top = obtenerPrendaParaTemperatura(temperatura, sensibilidadFrio.getSuperior(), remerasOCamisas);
		Prenda bot = obtenerPrendaParaTemperatura(temperatura, sensibilidadFrio.getInferior(), prendasInferiores);
		Prenda calzado = obtenerPrendaParaTemperatura(temperatura, 0, calzados);
		Prenda accesorio = obtenerPrendaParaTemperatura(temperatura, 0, accesorios);
//		List<Prenda> capasTop = obtenerCapasParaTemperatura(temperatura + top.getNivelAbrigo(), sensibilidadFrio.getSuperior(), prendasSuperiores);
		
		atuendo.agregarPrenda(top);
		atuendo.agregarPrenda(bot);
		atuendo.agregarPrenda(calzado);
		atuendo.agregarPrenda(accesorio);
		
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
