package domain.TiposDePrenda;

import java.util.List;

import domain.Categoria;
import domain.Color;
import domain.Prenda;
import domain.Tela;
import domain.Excepciones.*;

public class Zapatos extends Prenda{

	public Zapatos(List<Color> colores,String unaDescripcion,Tela unaTela)throws PrendaMalConstruida{
		super(colores,unaDescripcion,Categoria.CALZADO,unaTela);
		telasInconsistentes.add(Tela.POLYESTER);
		telasInconsistentes.add(Tela.SEDA);
		this.chequearConstruccionDePrenda();

	}
	public Zapatos(List<Color> colores,Tela unaTela)throws PrendaMalConstruida{
		super(colores,Categoria.CALZADO,unaTela);
		telasInconsistentes.add(Tela.POLYESTER);
		telasInconsistentes.add(Tela.SEDA);
		this.chequearConstruccionDePrenda();
	}
}
