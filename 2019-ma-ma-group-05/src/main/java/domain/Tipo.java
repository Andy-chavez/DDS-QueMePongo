package domain;

import java.util.Objects;
import java.util.stream.Stream;

public class Tipo {
	private Categoria categoria;
	private Tela tela;
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Tela getTela() {
		return tela;
	}
	
	public void setTela(Tela tela) {
		this.tela = tela;
	}
	
	public Boolean validarAtributosDeTipo() {
		return Stream.of(categoria, tela, nombre).anyMatch(Objects::isNull);
	}
	
	public Boolean esDeCategoria(Categoria unaCategoria) {
		return unaCategoria == categoria;
	}

	public boolean todosLosAtributosDeTipoSonIgualesA(Tela unaTela, String tipo, Categoria unaCategoria) {
		return unaTela == this.tela && tipo == this.nombre && unaCategoria == this.categoria;
	}
	
	public boolean esIgualAOtro(Tipo otroTipo) {
		return otroTipo.todosLosAtributosDeTipoSonIgualesA(this.tela, this.nombre, this.categoria);
	}
}
