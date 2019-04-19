package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import domain.Atuendo;
import domain.Prenda;

public class Guardarropa {
	private String nombre;
	private List<Prenda> prendas;
	private List<Atuendo> atuendosRechazados;
	
	public Guardarropa(String unNombre, List<Prenda> unasPrendas){
		this.nombre=unNombre;
		this.prendas=new ArrayList<Prenda>();
		this.agregarPrendas(unasPrendas);
	}
	
	public String getNombre(){return this.nombre;}
	public void setNombre(String unNombre){
		this.nombre=unNombre;
	}
	
	public List<Prenda> getPrendas(){return this.prendas;}
	public void agregarPrenda(Prenda prenda){
		this.prendas.add(prenda);
	}
	public void agregarPrendas(List<Prenda> prendas) {
		this.prendas.addAll(prendas);
	}
	
	public List<Atuendo> getAtuendosRechazados(){return this.atuendosRechazados;}
	
	public List<Prenda> filtrarPrendasSegunCondicion(Predicate<Prenda> predicado){		
		return this.prendas.stream().filter(predicado).collect(Collectors.toList());		
	}
	public Predicate<Prenda> esDeCategoria(Categoria unaCategoria){
		return prenda->prenda.categoria()==unaCategoria;
	}
	/*Supongo que éstos 2 anteriores métodos en realidad van en otra clase que se encargue de filtrar.
	Además en esa clase podríamos poner otros métodos como "esDeColor(Color unColor)" y otras boludeces más para que
	con el método "filtrarSegunCondicion" 
	filtremos la lista según cualquier condición, pero no lo piden todavía así que...
	
	*/
	public Atuendo obtenerSugerencia() { 
		
		List<Prenda> prendasSuperiores=this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.PARTE_SUPERIOR));
		List<Prenda> prendasInferiores=this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.PARTE_INFERIOR));
		List<Prenda> calzados=this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.CALZADO));
		List<Prenda> accesorios=this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.ACCESORIO));
		
		Atuendo atuendoSugerido= new Atuendo();
		for(int i=0;i<prendasSuperiores.size();i++){
			atuendoSugerido.setParteSuperior(prendasSuperiores.get(i));
			for(int j=0;j<prendasInferiores.size();j++){
				atuendoSugerido.setParteInferior(prendasInferiores.get(j));
				for(int h=0;h<calzados.size();h++){
					atuendoSugerido.setCalzado(calzados.get(h));
					for(int g=0;g<accesorios.size();g++){
						atuendoSugerido.setAccesorio(accesorios.get(g));
						if(!this.atuendosRechazados.contains(atuendoSugerido)){
							return atuendoSugerido;
						}
					}
				}
			}
		}
		return atuendoSugerido;/*
		Si todos los atuendos son rechazados devuelvo el último de todos.
		Solución villera detected. Le tuve que agregar eso para sacar el throw exception,porque el profe
		me respondió que acá se va agregar otro requerimiento más tarde.
		*/
		
	}
	
}
