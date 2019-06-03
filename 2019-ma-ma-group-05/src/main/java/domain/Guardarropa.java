package domain;

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
	 
	public Guardarropa(String unNombre, List<Prenda> unasPrendas){
		this.nombre=unNombre;
		this.prendas=new ArrayList<Prenda>();
		this.agregarPrendas(unasPrendas);
	}
	
	public String getNombre(){return this.nombre;}
	
	public void setNombre(String unNombre){this.nombre=unNombre;}
	
	public List<Prenda> getPrendas(){return this.prendas;}
	
	public void agregarPrenda(Prenda prenda) {this.prendas.add(prenda);}
	public void agregarPrendas(List<Prenda> unasPrendas){this.prendas.addAll(unasPrendas);}
		
	public List<Prenda> filtrarPrendasSegunCondicion(Predicate<Prenda> predicado){		
		return this.prendas.stream().filter(predicado).collect(Collectors.toList());		
	}
	public Predicate<Prenda> esDeCategoria(Categoria unaCategoria){
		return prenda->prenda.getTipo().getCategoria()==unaCategoria;
	}
	public Atuendo obtenerSugerencia() { 
		Random random = new Random();
		
		List<Prenda> prendasSuperiores=this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.SUPERIOR));
		List<Prenda> prendasInferiores=this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.INFERIOR));
		List<Prenda> calzados=this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.CALZADO));
		List<Prenda> accesorios=this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.ACCESORIO));
		
		List<Atuendo> atuendos = new ArrayList<Atuendo>();
		for(int i=0;i<prendasSuperiores.size();i++){
			for(int j=0;j<prendasInferiores.size();j++){
				for(int h=0;h<calzados.size();h++){
					for(int g=0;g<accesorios.size();g++){
						Atuendo atuendoSugerido = new Atuendo();
						atuendoSugerido.agregarPrenda(prendasSuperiores.get(i));
						atuendoSugerido.agregarPrenda(prendasInferiores.get(j));
						atuendoSugerido.agregarPrenda(calzados.get(h));
						atuendoSugerido.agregarPrenda(accesorios.get(g));
						atuendos.add(atuendoSugerido);
					}
				}
			}
		}
		return atuendos.get(random.nextInt(atuendos.size()));
	}
	public Boolean tieneLaPrenda(Prenda unaPrenda) {
		return this.prendas.stream().anyMatch(prenda -> prenda.esIgualA(unaPrenda));
	}
	
}
