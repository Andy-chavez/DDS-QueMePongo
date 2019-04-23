package domain.TiposDePrenda;

import domain.Categoria;
import domain.Tela;
import domain.TipoDePrenda;
import domain.Excepciones.PantalonMalConstruido;

public class Pantalon extends TipoDePrenda{

	public Pantalon(Tela unaTela) throws PantalonMalConstruido{
		super(Categoria.PARTE_INFERIOR,unaTela);
		/*Acá habría que setearle los tipos de tela que no admitiría. 
		 * Los datos reales no los tenemos así que los invento
		 */
		telasInconsistentes.add(Tela.NYLON);
		telasInconsistentes.add(Tela.ELASTINA);
		if(this.prendaInconsistente()){
			throw new PantalonMalConstruido();
		}
	}

}
