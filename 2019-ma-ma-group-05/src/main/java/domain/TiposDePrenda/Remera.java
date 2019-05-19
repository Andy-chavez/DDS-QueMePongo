package domain.TiposDePrenda;

import java.util.List;

import domain.Categoria;
import domain.Color;
import domain.Prenda;
import domain.Tela;
import domain.Excepciones.*;

public class Remera extends Prenda{

	public Remera(List<Color> colores,String unaDescripcion,Tela unaTela) throws PrendaMalConstruida{
		super(colores,unaDescripcion,Categoria.PARTE_SUPERIOR,unaTela);
		telasInconsistentes.add(Tela.CUERO);
		telasInconsistentes.add(Tela.POLYESTER);
		this.chequearConstruccionDePrenda();

	}
	public Remera(List<Color> colores,Tela unaTela) throws PrendaMalConstruida{
		super(colores,Categoria.PARTE_SUPERIOR,unaTela);
		telasInconsistentes.add(Tela.CUERO);
		telasInconsistentes.add(Tela.POLYESTER);
		this.chequearConstruccionDePrenda();
	}
}
