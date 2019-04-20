package domain;

import java.util.ArrayList;
import java.util.List;
import domain.TipoDePrenda;

public class Prenda {
	private List<Color> colores;
	private String descripcion;
	private TipoDePrenda tipo;
	/*
	 * public Prenda(List<Color> colores,String unaDescripcion,String unTipo, Categoria unaCategoria, Tela unaTela){
		this.descripcion=unaDescripcion;
		this.tipo=new TipoDePrenda(unTipo, unaCategoria, unaTela);
		this.colores=new ArrayList<Color>();
		this.colores.addAll(colores);
	}
	 */
	public Prenda(List<Color> colores,String unaDescripcion,TipoDePrenda unTipo){
		this.descripcion=unaDescripcion;
		this.tipo=unTipo;
		this.colores=new ArrayList<Color>();
		this.colores.addAll(colores);
	}
	public Prenda(List<Color> colores,TipoDePrenda unTipo){
		this.tipo=unTipo;
		this.colores=new ArrayList<Color>();
		this.colores.addAll(colores);
	} //Agrego constructor sin la descripción en caso de que el usuario lo quiera sin la misma
	
	public Categoria categoria(){
		return this.tipo.getCategoria();
	}
}
