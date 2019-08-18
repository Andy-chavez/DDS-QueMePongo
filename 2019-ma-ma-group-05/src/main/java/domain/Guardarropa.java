package domain;

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

  public Atuendo obtenerSugerencia(double temperatura) {
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
