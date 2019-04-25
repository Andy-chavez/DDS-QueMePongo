package domain;

import java.util.ArrayList;
import java.util.List;
import domain.TipoDePrenda;
import domain.Excepciones.AccesorioMalConstruido;
import domain.Excepciones.CalzadoMalConstruido;
import domain.Excepciones.PantalonMalConstruido;
import domain.Excepciones.RemeraMalConstruida;
import domain.TiposDePrenda.Accesorio;
import domain.TiposDePrenda.Pantalon;
import domain.TiposDePrenda.Remera;
import domain.TiposDePrenda.Zapatos;

public class Prenda {
	private List<Color> colores;
	private String descripcion;
	private TipoDePrenda tipo;
	
	public Prenda(List<Color> colores,String unaDescripcion,TipoDePrenda unTipo){
		this.descripcion=unaDescripcion;
		this.tipo=unTipo;
		this.colores=new ArrayList<Color>();
		this.colores.addAll(colores);
	}
	public Prenda(List<Color> colores,TipoDePrenda unTipo) {
		this.tipo=unTipo;
		this.colores=new ArrayList<Color>();
		this.colores.addAll(colores);
	} //Agrego constructor sin la descripción en caso de que el usuario lo quiera sin la misma
	
	
	public Categoria getCategoria(){
		return this.tipo.getCategoria();
	}
	
	
	//Test. DESPUES VEO SI ME SALE LO DE IMPLEMENTAR EL USO DE JSON. NUNCA LO HICE POR ESO PRIMERO HAGO ÉSTO.
	public static List<Prenda> testCrearPrendas() throws RemeraMalConstruida, PantalonMalConstruido,
	CalzadoMalConstruido, AccesorioMalConstruido{
		List<Prenda> unasPrendas= new ArrayList<Prenda>();
		
		List<Color> unosColores1=new ArrayList<Color>();
		unosColores1.add(Color.AMARILLO);
		TipoDePrenda unTipo1= new Remera(Tela.ALGODON);
		Prenda prenda1= new Prenda(unosColores1,unTipo1);
		unasPrendas.add(prenda1);
		
		List<Color> unosColores2=new ArrayList<Color>();
		unosColores2.add(Color.AZUL);
		unosColores2.add(Color.NEGRO);
		TipoDePrenda unTipo2= new Pantalon(Tela.CUERO);
		Prenda prenda2 = new Prenda(unosColores2,unTipo2);
		unasPrendas.add(prenda2);
		
		List<Color> unosColores3=new ArrayList<Color>();
		unosColores2.add(Color.AZUL);
		unosColores2.add(Color.NEGRO);
		TipoDePrenda unTipo3= new Zapatos(Tela.CUERO);
		Prenda prenda3 = new Prenda(unosColores3,unTipo3);
		unasPrendas.add(prenda3);
		
		List<Color> unosColores4=new ArrayList<Color>();
		unosColores2.add(Color.AZUL);
		TipoDePrenda unTipo4= new Accesorio(Tela.CUERO);
		Prenda prenda4 = new Prenda(unosColores4,unTipo4);
		unasPrendas.add(prenda4);
		
		List<Color> unosColores5=new ArrayList<Color>();
		unosColores2.add(Color.BLANCO);
		TipoDePrenda unTipo5= new Remera(Tela.SEDA);
		Prenda prenda5 = new Prenda(unosColores5,unTipo5);
		unasPrendas.add(prenda5);
		
		return unasPrendas;
	}
}
