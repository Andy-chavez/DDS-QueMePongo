package domain;

import java.util.ArrayList;
import java.util.List;
import domain.Tela;
import domain.Categoria;

public abstract class TipoDePrenda {
	private Categoria categoria;
	protected static List<Tela> telasInconsistentes;
	private Tela tela;
	/*
	 * public TipoDePrenda(String unTipo, Categoria unaCategoria, Tela unaTela){
		this.tipo =unTipo;
		this.categoria=unaCategoria;
		this.tela=unaTela;
		this.telasInconsistentes=new ArrayList<Tela>();
		
	}
	 */
	public TipoDePrenda(Categoria unaCategoria, Tela unaTela){
		this.categoria=unaCategoria;
		this.tela=unaTela;
		telasInconsistentes=new ArrayList<Tela>();
		
	}
	public static void setTelasInconsistentes(List<Tela> unasTelas){
		telasInconsistentes.addAll(unasTelas);
	}
	public Categoria getCategoria(){
		return this.categoria;
	}
	public Boolean prendaInconsistente(){
		return this.telasInconsistentes.contains(this.tela);
	}
}
