package domain;

import java.util.ArrayList;
import java.util.List;
import domain.Tela;
import domain.Categoria;

public class TipoDePrenda {
	private String tipo;
	private Categoria categoria;
	private List<Tela> telasInconsistentes;
	private Tela tela;
	
	public TipoDePrenda(String unTipo, Categoria unaCategoria, Tela unaTela){
		this.tipo =unTipo;
		this.categoria=unaCategoria;
		this.tela=unaTela;
		this.telasInconsistentes=new ArrayList<Tela>();
		
	}
	public Categoria getCategoria(){
		return this.categoria;
	}
	public Boolean telaInconsistente(Tela unaTela){
		return this.telasInconsistentes.contains(unaTela);
	}
}
