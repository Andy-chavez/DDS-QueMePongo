package domain.TiposDePrenda;

import java.util.List;

import domain.Categoria;
import domain.Color;
import domain.Prenda;
import domain.Tela;
import domain.Excepciones.PantalonMalConstruido;

public class Pantalon extends Prenda{

	public Pantalon(List<Color> colores,String unaDescripcion,Tela unaTela) throws PantalonMalConstruido{
		super(colores,unaDescripcion,Categoria.PARTE_INFERIOR,unaTela);
		telasInconsistentes.add(Tela.NYLON);
		telasInconsistentes.add(Tela.ELASTINA);
		if(this.prendaInconsistente()){
			throw new PantalonMalConstruido();
		}
	}
	public Pantalon(List<Color> colores,Tela unaTela) throws PantalonMalConstruido{
		super(colores,Categoria.PARTE_INFERIOR,unaTela);
		telasInconsistentes.add(Tela.NYLON);
		telasInconsistentes.add(Tela.ELASTINA);
		if(this.prendaInconsistente()){
			throw new PantalonMalConstruido();
		}
	}

}
