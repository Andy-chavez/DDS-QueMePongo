package domain.TiposDePrenda;

import java.util.List;

import domain.Categoria;
import domain.Color;
import domain.Prenda;
import domain.Tela;
import domain.Excepciones.AccesorioMalConstruido;

public class Accesorio extends Prenda{

	public Accesorio(List<Color> colores,String unaDescripcion,Tela unaTela) throws AccesorioMalConstruido{
		super(colores,unaDescripcion,Categoria.ACCESORIO,unaTela);
		telasInconsistentes.add(Tela.ALGODON);
		if(prendaInconsistente()){
			throw new AccesorioMalConstruido();
		}
	}
	public Accesorio(List<Color> colores,Tela unaTela) throws AccesorioMalConstruido{
		super(colores,Categoria.ACCESORIO,unaTela);
		telasInconsistentes.add(Tela.ALGODON);
		if(prendaInconsistente()){
			throw new AccesorioMalConstruido();
		}
	}

}
