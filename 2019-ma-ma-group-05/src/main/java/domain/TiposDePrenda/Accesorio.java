package domain.TiposDePrenda;

import domain.Categoria;
import domain.Tela;
import domain.TipoDePrenda;
import domain.Excepciones.AccesorioMalConstruido;

public class Accesorio extends TipoDePrenda{

	public Accesorio(Tela unaTela) throws AccesorioMalConstruido{
		super(Categoria.ACCESORIO,unaTela);
		/*Acá habría que setearle los tipos de tela que no admitiría. 
		 * Los datos reales no los tenemos así que los invento SOLO PARA PODER TESTEAR. 
		 * Seguro hay otra forma mejor.
		 */
		telasInconsistentes.add(Tela.ALGODON);
		if(this.prendaInconsistente()){
			throw new AccesorioMalConstruido();
		}
	}

}
