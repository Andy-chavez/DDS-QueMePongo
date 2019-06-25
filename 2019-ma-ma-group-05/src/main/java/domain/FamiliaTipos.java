package domain;

import java.util.EnumSet;

public interface FamiliaTipos {

	public String getTipo();
	public Categoria getCategoria();
	public EnumSet<Tela> getTelasPosibles();
	public Capa getCapa();
	public int getNivelAbrigo();
	
}
