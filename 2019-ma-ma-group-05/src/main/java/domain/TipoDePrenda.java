package domain;
import java.util.ArrayList;
import java.util.List;
public abstract class TipoDePrenda {
	private Categoria categoria;
	private List<Tela> telasPosibles;
	private Tela tela;
	
	public TipoDePrenda(Categoria unaCategoria, Tela unaTela, List<Tela> telasPosibles){
		this.categoria=unaCategoria;
		this.tela=unaTela;
		this.telasPosibles=new ArrayList<Tela>();
		this.telasPosibles.addAll(telasPosibles);
	}
	public Categoria getCategoria(){
		return this.categoria;
	}
	public Boolean telaCorrecta(){
		return this.telasPosibles.contains(tela);
	}
}
