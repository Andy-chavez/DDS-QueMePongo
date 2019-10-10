package entities;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;

import javax.persistence.*;

import entities.Categoria;

public abstract class Tipo{

	protected String nombre;
	protected int capa;
	protected int nivelAbrigo;
	protected Categoria categoria;
	protected ArrayList<Tela> telasPosibles = new ArrayList<>();


	// --- GETTERS Y SETTERS ---
	public void setNivelAbrigo(int nivelAbrigo){ this.nivelAbrigo = nivelAbrigo; }
	public int getNivelAbrigo() { return this.nivelAbrigo;	}
	public int getCapa() { return this.capa;}
	public String getNombre() { return nombre;	}
	public void setNombre(String nombre) { 	this.nombre = nombre; }
	public Categoria getCategoria() { return categoria;	}
	public void setCategoria(Categoria categoria) {	this.categoria = categoria;	}
	
	
	public boolean estaTelaEsPosible(String nombreTela) {
		ArrayList<Tela> lista = new ArrayList<>();
		lista = this.telasPosibles;
		return lista.stream().anyMatch(t -> t.getNombre() == nombreTela);
	}
	
	public Boolean validarAtributosDeTipo() {
		return Stream.of(categoria, nombre).anyMatch(Objects::isNull);
	}
	
	public Boolean esDeCategoria(Categoria unaCategoria) {
		return this.categoria.getClass() == unaCategoria.getClass();
	}

	public boolean todosLosAtributosDeTipoSonIgualesA(String tipo) {//, Categoria unaCategoria) {
		return tipo == this.nombre;// && unaCategoria == this.categoria;
	}
	
	public boolean esIgualAOtro(Tipo otroTipo) {
		return otroTipo.todosLosAtributosDeTipoSonIgualesA(this.nombre);//, this.categoria);
	}
}
