package domain;

import java.util.List;

public class Prenda {
	private List<Color> colores;
	private String descripcion;
	
	private TipoDePrenda tipo;
	
	public Categoria categoria(){
		return this.tipo.getCategoria();
	}
}
