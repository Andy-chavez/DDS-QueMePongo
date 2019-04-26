package domain;

import java.util.ArrayList;
import java.util.List;
import domain.Excepciones.AccesorioMalConstruido;
import domain.Excepciones.PantalonMalConstruido;
import domain.Excepciones.RemeraMalConstruida;
import domain.Excepciones.ZapatosMalConstruidos;
import domain.TiposDePrenda.Accesorio;
import domain.TiposDePrenda.Pantalon;
import domain.TiposDePrenda.Remera;
import domain.TiposDePrenda.Zapatos;

public abstract class Prenda {
	private List<Color> colores;
	private String descripcion;
	private Categoria categoria;
	protected static List<Tela> telasInconsistentes;
	private Tela tela;
	
	public Prenda(List<Color> colores,String unaDescripcion, Categoria unaCategoria,Tela unaTela){
		telasInconsistentes=new ArrayList<Tela>();
		this.colores=new ArrayList<Color>();
		this.colores.addAll(colores);
		this.descripcion=unaDescripcion;
		this.categoria=unaCategoria;
		this.tela=unaTela;
		
	}
	public Prenda(List<Color> colores,Categoria unaCategoria,Tela unaTela) {
		telasInconsistentes=new ArrayList<Tela>();
		this.colores=new ArrayList<Color>();
		this.colores.addAll(colores);
		this.categoria=unaCategoria;
		this.tela=unaTela;
	} //Agrego constructor sin la descripción en caso de que el usuario lo quiera sin la misma
	
	public static void setTelasInconsistentes(List<Tela> unasTelas){
		telasInconsistentes.addAll(unasTelas);
	}
	public static List<Tela> getTelasInconsistentes(){return telasInconsistentes;}
	public Categoria getCategoria(){
		return this.categoria;
	}
	public Boolean prendaInconsistente(){
		return telasInconsistentes.contains(this.tela);
	}
	
	
	//Test. DESPUES VEO SI ME SALE LO DE IMPLEMENTAR EL USO DE JSON. NUNCA LO HICE POR ESO PRIMERO HAGO ÉSTO.
	public static List<Prenda> testCrearPrendas() throws RemeraMalConstruida, PantalonMalConstruido,
	ZapatosMalConstruidos, AccesorioMalConstruido{
		List<Prenda> unasPrendas= new ArrayList<Prenda>();
		
		List<Color> unosColores1=new ArrayList<Color>();
		unosColores1.add(Color.AMARILLO);
		Prenda prenda1= new Remera(unosColores1,Tela.ALGODON);
		unasPrendas.add(prenda1);
		
		List<Color> unosColores2=new ArrayList<Color>();
		unosColores2.add(Color.AZUL);
		unosColores2.add(Color.NEGRO);
		Prenda prenda2 = new Pantalon(unosColores2,Tela.CUERO);
		unasPrendas.add(prenda2);
		
		List<Color> unosColores3=new ArrayList<Color>();
		unosColores2.add(Color.AZUL);
		unosColores2.add(Color.NEGRO);
		Prenda prenda3 = new Zapatos(unosColores3,Tela.CUERO);
		unasPrendas.add(prenda3);
		
		List<Color> unosColores4=new ArrayList<Color>();
		unosColores2.add(Color.AZUL);
		Prenda prenda4 = new Accesorio(unosColores4,Tela.CUERO);
		unasPrendas.add(prenda4);
		
		List<Color> unosColores5=new ArrayList<Color>();
		unosColores2.add(Color.BLANCO);
		Remera prenda5 = new Remera(unosColores5,Tela.SEDA);
		unasPrendas.add(prenda5);
		
		return unasPrendas;
	}
}
