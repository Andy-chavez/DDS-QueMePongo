package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import domain.Atuendo;
import domain.Prenda;
import domain.Excepciones.AccesorioMalConstruido;
import domain.Excepciones.PantalonMalConstruido;
import domain.Excepciones.RemeraMalConstruida;
import domain.Excepciones.ZapatosMalConstruidos;

public class Guardarropa {
	private String nombre;
	private List<Prenda> prendas;
	
	public Guardarropa(String unNombre){
		this.nombre=unNombre;
		this.prendas=new ArrayList<Prenda>();
	} 
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
		return prenda->prenda.getCategoria()==unaCategoria;
	}
	/*Supongo que éstos 2 anteriores métodos en realidad van en otra clase que se encargue de filtrar.
	Además en esa clase podríamos poner otros métodos como "esDeColor(Color unColor)" y otras boludeces más para que
	con el método "filtrarSegunCondicion" 
	filtremos la lista según cualquier condición, pero no lo piden todavía así que...
	
	*/
public List<Atuendo> obtenerTodasLasSugerencias() { 
		
		List<Prenda> prendasSuperiores=this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.PARTE_SUPERIOR));
		List<Prenda> prendasInferiores=this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.PARTE_INFERIOR));
		List<Prenda> calzados=this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.CALZADO));
		List<Prenda> accesorios=this.filtrarPrendasSegunCondicion(this.esDeCategoria(Categoria.ACCESORIO));
		
		List<Atuendo> atuendos = new ArrayList<Atuendo>();
		for(int i=0;i<prendasSuperiores.size();i++){
			Atuendo atuendoSugerido= new Atuendo();
			atuendoSugerido.setParteSuperior(prendasSuperiores.get(i));
			for(int j=0;j<prendasInferiores.size();j++){
				atuendoSugerido.setParteInferior(prendasInferiores.get(j));
				for(int h=0;h<calzados.size();h++){
					atuendoSugerido.setCalzado(calzados.get(h));
					for(int g=0;g<accesorios.size();g++){
						atuendoSugerido.setAccesorio(accesorios.get(g));
						atuendos.add(atuendoSugerido);
					}
				}
			}
		}
		return atuendos;
	}
	public Atuendo obtenerSugerencia(){
		List<Atuendo> atuendosSugeridos= this.obtenerTodasLasSugerencias();
		/*Random random =  new Random();
		return atuendosSugeridos.get(random.nextInt(atuendosSugeridos.size()));*/
		return atuendosSugeridos.get(0);
	}
	
	//Test
	public static Guardarropa testCrearGuardarropa() throws RemeraMalConstruida, PantalonMalConstruido,
	ZapatosMalConstruidos, AccesorioMalConstruido{
		Guardarropa guardarropa= new Guardarropa("ropalinda");
		guardarropa.prendas.addAll(Prenda.testCrearPrendas());
		return guardarropa;
	}
	
}
