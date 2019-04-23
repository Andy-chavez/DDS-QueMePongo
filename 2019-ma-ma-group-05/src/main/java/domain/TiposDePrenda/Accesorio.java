package domain.TiposDePrenda;

import domain.Categoria;
import domain.Tela;
import domain.TipoDePrenda;
import domain.Excepciones.AccesorioMalConstruido;

public class Accesorio extends TipoDePrenda{

	public Accesorio(Tela unaTela) throws AccesorioMalConstruido{
		super(Categoria.ACCESORIO,unaTela);
		if(this.prendaInconsistente()){
			throw new AccesorioMalConstruido();
		}
	}

}
