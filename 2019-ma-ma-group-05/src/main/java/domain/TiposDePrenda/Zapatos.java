package domain.TiposDePrenda;

import java.util.List;

import domain.Categoria;
import domain.Color;
import domain.Prenda;
import domain.Tela;
import domain.Excepciones.ZapatosMalConstruidos;

public class Zapatos extends Prenda{

	public Zapatos(List<Color> colores,String unaDescripcion,Tela unaTela)throws ZapatosMalConstruidos{
		super(colores,unaDescripcion,Categoria.CALZADO,unaTela);
		telasInconsistentes.add(Tela.POLYESTER);
		telasInconsistentes.add(Tela.SEDA);
		if(this.prendaInconsistente()){
			throw new ZapatosMalConstruidos();
		}
	}
	public Zapatos(List<Color> colores,Tela unaTela)throws ZapatosMalConstruidos{
		super(colores,Categoria.CALZADO,unaTela);
		telasInconsistentes.add(Tela.POLYESTER);
		telasInconsistentes.add(Tela.SEDA);
		if(this.prendaInconsistente()){
			throw new ZapatosMalConstruidos();
		}
	}
}
