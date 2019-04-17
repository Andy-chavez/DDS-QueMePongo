package domain;
import java.util.List;
public abstract class TipoDePrenda {
	private Categoria categoria;
	private List<Tela> telasPosibles;
	private Tela tela;
	
	
	public Categoria getCategoria(){
		return this.categoria;
	}
	public Boolean telaCorrecta(){
		return this.telasPosibles.contains(tela);
	}
}
