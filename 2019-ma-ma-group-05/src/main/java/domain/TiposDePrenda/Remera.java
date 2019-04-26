package domain.TiposDePrenda;

import java.util.List;

import domain.Categoria;
import domain.Color;
import domain.Prenda;
import domain.Tela;
import domain.Excepciones.RemeraMalConstruida;

public class Remera extends Prenda{

	public Remera(List<Color> colores,String unaDescripcion,Tela unaTela) throws RemeraMalConstruida{
		super(colores,unaDescripcion,Categoria.PARTE_SUPERIOR,unaTela);
		telasInconsistentes.add(Tela.CUERO);
		telasInconsistentes.add(Tela.POLYESTER);
		if(this.prendaInconsistente()){
			throw new RemeraMalConstruida();
		}
	}
	public Remera(List<Color> colores,Tela unaTela) throws RemeraMalConstruida{
		super(colores,Categoria.PARTE_SUPERIOR,unaTela);
		telasInconsistentes.add(Tela.CUERO);
		telasInconsistentes.add(Tela.POLYESTER);
		if(this.prendaInconsistente()){
			throw new RemeraMalConstruida();
		}
	}
}
