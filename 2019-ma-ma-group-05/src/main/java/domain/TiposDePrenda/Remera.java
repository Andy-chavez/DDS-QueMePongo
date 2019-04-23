package domain.TiposDePrenda;

import domain.Categoria;
import domain.Tela;
import domain.TipoDePrenda;
import domain.Excepciones.RemeraMalConstruida;

public class Remera extends TipoDePrenda{

	public Remera(Tela unaTela) throws RemeraMalConstruida{
		super(Categoria.PARTE_SUPERIOR,unaTela);
		/*Acá habría que setearle los tipos de tela que no admitiría. 
		 * Los datos reales no los tenemos así que los invento SOLO PARA PODER TESTEAR. 
		 * Seguro hay otra forma mejor.
		 */
		telasInconsistentes.add(Tela.CUERO);
		telasInconsistentes.add(Tela.POLYESTER);
		if(this.prendaInconsistente()){
			throw new RemeraMalConstruida();
		}
	}
	

}
