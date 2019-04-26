package domain.TiposDePrenda;

import domain.Categoria;
import domain.Tela;
import domain.TipoDePrenda;
import domain.Excepciones.ZapatosMalConstruidos;

public class Zapatos extends TipoDePrenda{

	public Zapatos(Tela unaTela)throws ZapatosMalConstruidos{
		super(Categoria.CALZADO,unaTela);
		/*Acá habría que setearle los tipos de tela que no admitiría. 
		 * Los datos reales no los tenemos así que los invento SOLO PARA PODER TESTEAR. 
		 * Seguro hay otra forma mejor.
		 */
		telasInconsistentes.add(Tela.POLYESTER);
		telasInconsistentes.add(Tela.SEDA);
		if(this.prendaInconsistente()){
			throw new ZapatosMalConstruidos();
		}
	}
}
