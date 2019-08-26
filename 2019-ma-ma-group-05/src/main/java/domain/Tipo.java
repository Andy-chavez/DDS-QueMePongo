package domain;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Tipo {
	protected Categoria categoria;
	protected ArrayList<Tela> telasPosibles = new ArrayList<>();
	protected String nombre;
	protected Tela tela;
	protected Capa capa;
	protected int nivelAbrigo;
	
	public void setNivelAbrigo(int nivelAbrigo){
		this.nivelAbrigo = nivelAbrigo;
	}
	
	public int getNivelAbrigo() {
		return this.nivelAbrigo;
	}
	
	public Capa getCapa() {
		return this.capa;
	}
	
	public void setCapa(Capa capa) {
		this.capa = capa;
	}
	
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
	public boolean estaTelaEsPosible(String tela) {
		ArrayList<Tela> lista = new ArrayList<>();
		lista = this.telasPosibles;
		lista.stream().filter(t -> t.getNombre() == tela).collect(Collectors.toList());
		return !lista.isEmpty();
	}
	public Tela getTela() {
		return tela;
	}
	public void establecerTela(Tela tela) {
		if (this.estaTelaEsPosible(tela.getNombre())) {
			this.setTela(tela);
		}
		else
			throw new IllegalArgumentException("Tela no permitida");
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
