package domain.TiposDePrenda;

import domain.Categoria;
import domain.Tela;
import domain.TipoDePrenda;
import domain.Excepciones.CalzadoMalConstruido;

public class Zapatos extends TipoDePrenda{

	public Zapatos(Tela unaTela)throws CalzadoMalConstruido{
		super(Categoria.CALZADO,unaTela);
		/*Acá habría que setearle los tipos de tela que no admitiría. 
		 * Los datos reales no los tenemos así que los invento
		 */
		telasInconsistentes.add(Tela.NYLON);
		telasInconsistentes.add(Tela.ELASTINA);
		if(this.prendaInconsistente()){
			throw new CalzadoMalConstruido();
		}
	}
}
