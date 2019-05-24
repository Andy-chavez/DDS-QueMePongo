package domain.TiposDePrenda;

import java.util.List;

import domain.Categoria;
import domain.Color;
import domain.Prenda;
import domain.Tela;
import domain.Excepciones.PrendaMalConstruida;

public class Accesorio extends Prenda{

	public Accesorio(List<Color> colores,String unaDescripcion,Tela unaTela) throws PrendaMalConstruida{
		super(colores,unaDescripcion,Categoria.ACCESORIO,unaTela);
		telasInconsistentes.add(Tela.ALGODON);
		this.chequearConstruccionDePrenda();
	}
	public Accesorio(List<Color> colores,Tela unaTela) throws PrendaMalConstruida{
		super(colores,Categoria.ACCESORIO,unaTela);
		telasInconsistentes.add(Tela.ALGODON);
		this.chequearConstruccionDePrenda();
}
}


