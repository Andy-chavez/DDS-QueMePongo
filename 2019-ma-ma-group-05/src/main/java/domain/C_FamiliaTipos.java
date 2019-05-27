package domain;

import java.util.EnumSet;

public interface C_FamiliaTipos {

	public String getTipo();
	public Categoria getCategoria();
	public EnumSet<Tela> getTelasPosibles();
	
}
