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

	public Guardarropa(String unNombre, List<Prenda> unasPrendas) {
		this.nombre = unNombre;
		this.prendas = new ArrayList<Prenda>();
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

	private void agregarAlgunaPrendaAlAtuendo(Atuendo atuendo, List<Prenda> prendas) {
		Random random = new Random();
		atuendo.agregarPrenda(prendas.get(random.nextInt(prendas.size())));
	}
	
	private void agregarAlgunaPrendaAlAtuendoMaybe(Atuendo atuendo, List<Prenda> prendas) {
		Random random = new Random();
		if(random.nextDouble() > 0.5) {
			agregarAlgunaPrendaAlAtuendo(atuendo, prendas);
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
	public Atuendo obtenerSugerencia() {
		Predicate<Prenda> esRemera = p -> p.getCapa() == Capa.REMERA;
		Predicate<Prenda> esCamisa = p -> p.getCapa() == Capa.CAMISA;

		List<Prenda> prendasSuperiores = this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.SUPERIOR));
		List<Prenda> remerasOCamisas = prendasSuperiores.stream().filter(esRemera.or(esCamisa)).collect(Collectors.toList());
		List<Prenda> prendasInferiores = this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.INFERIOR));
		List<Prenda> calzados = this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.CALZADO));
		List<Prenda> accesorios = this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.ACCESORIO));

		List<Atuendo> atuendos = new ArrayList<Atuendo>();
		Atuendo atuendo = new Atuendo();

		int numeroDeCapas = 0;
		//TODO: no hardcodear el numero 3 (cantidad de max capas que tiene la parte superior)
		agregarAlgunaPrendaAlAtuendo(atuendo, remerasOCamisas);
		while(numeroDeCapas < 3) {
			agregarAlgunaPrendaAlAtuendoMaybe(atuendo, prendasSuperiores);
			numeroDeCapas ++;
		}

		agregarAlgunaPrendaAlAtuendo(atuendo, prendasInferiores);
		agregarAlgunaPrendaAlAtuendo(atuendo, calzados);
		agregarAlgunaPrendaAlAtuendo(atuendo, accesorios);
		atuendo.getMap().forEach( (k,v) -> System.out.println(k));

		return atuendo;
	}

	public Boolean tieneLaPrenda(Prenda unaPrenda) {
		return this.prendas.stream().anyMatch(prenda -> prenda.esIgualA(unaPrenda));
	}

}
