package domain;
import java.sql.NClob;
import java.util.ArrayList;
import java.util.List;
public abstract class TipoDePrenda {
	private Categoria categoria;
	private List<Tela> telasInconsistentes;
	private Tela tela;
	
	public TipoDePrenda(Categoria unaCategoria, Tela unaTela){
		this.categoria=unaCategoria;
		this.tela=unaTela;
		this.telasInconsistentes=new ArrayList<Tela>();
		
	}
	public Categoria getCategoria(){
		return this.categoria;
	}
	public Boolean telaInconsistente(){
		return this.telasInconsistentes.contains(tela);
	}
}
